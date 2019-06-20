import DAO.CustomerDAO;
import domain.CriteriaCustomer;
import domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "*.do")
public class CustomerServlet extends HttpServlet {
   private CustomerDAO customerDAO = new CustomerDAOjdbcImpl();
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String method = request.getParameter("method");
//        switch (method){
//            case "add":add(request,response);break;
//            case "query":query(request,response);break;
//            case "delete":delete(request,response);break;
//        }
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取ServletPath：/edit.do或add.do
        String servletPath = request.getServletPath();
        //2.去除/和.do,得到类似于edit和add这样的字符串

        try {
            String methodName = servletPath.substring(5);
            methodName = methodName.substring(0,methodName.length()-3);
            System.out.println(methodName);
            //3.利用反射获取methodName对应的方法
            Method method = getClass().getDeclaredMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            //4.利用反射调用对应的方法
            method.invoke(this,request,response);
        }
         catch (Exception e) {

             //request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request,response);
                   e.printStackTrace();
        }
    }
    private void add(HttpServletRequest request,HttpServletResponse response) throws Exception{
     //1.获取表单参数：name,address,phone
        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        String location = new String(request.getParameter("location").getBytes("ISO-8859-1"),"UTF-8");
        String QQ = request.getParameter("QQ");
        Integer number = Integer.parseInt(request.getParameter("number"));
        System.out.println(name);
        System.out.println(location);
        System.out.println(QQ);
        System.out.println(number);
        //检验name是否已经被占用：
        //调用CustomerDAO的getCountWithName(String name)获取name在数据库中是否存在
         long count = customerDAO.getCountWithName(name);
        //若返回值大于0，则响应newcustomer.jsp页面：通过转发的方式来响应
                if (count>0) {
                    //在request中放入一个属性message：用户名name已经被占用，请重新选择！在页面上通过request.getAttribute("message")的方式来显示
                    request.setAttribute("massage",  name + "信息已被录入");
                    //要求在newcustomer.jsp页面显示一个错误消息：用户名name已经被占用，请重新选择！
                    //newcustomer.jsp的表单值可以回显。
                    //通过value="<%=request.getParameter("name")==null ? "": request.getParameter("name")%>"方法来回显！
                    //方法结束return
                    request.getRequestDispatcher("/jsp/newcustomer.jsp").forward(request,response);
                    return;
                }
     //2.把表单参数封装为一个Customer对象customer
      Customer customer = new Customer(name,location,QQ,number);
     //3.调用CustomerDAO的save(Customer customer)执行保存操作
      customerDAO.save(customer);
     //4.重定向到success.jsp页面。
        request.getRequestDispatcher("query.do").forward(request,response);
      System.out.println("add");
    }
    private void query(HttpServletRequest request,HttpServletResponse response)throws Exception{

        //1.调用CustomerDAO的getAll（）得到Customer的集合
        List<Customer> customers = customerDAO.getAll();

        //2.把Customer的集合放入request中
        request.setAttribute("customers",customers);

        //3.转发页面到index.jsp（只能用转发）
        request.getRequestDispatcher("index.jsp").forward(request,response);
        System.out.println("query");
    }
    private void query1(HttpServletRequest request,HttpServletResponse response)throws Exception{
        //1.获取模糊查询的请求参数
        String name = request.getParameter("name");
        String names = new String(name.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(names);
        String Location = request.getParameter("location");
        String Locations = new String(Location.getBytes("ISO-8859-1"),"UTF-8");
        System.out.println(Locations);
        String QQ = request.getParameter("QQ");
        //2.把请求参数封装为一个CriteriaCustomer对象
        CriteriaCustomer criteriaCustomer = new CriteriaCustomer(names,Locations,QQ);
        //3.调用CustomerDAO的getAll（）得到Customer的集合
        List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(criteriaCustomer);

        //4.把Customer的集合放入request中
        request.setAttribute("customers",customers);

        //5.转发页面到index.jsp（只能用转发）
        request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
        System.out.println("query");
    }
    private void delete(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String idStr = request.getParameter("id");
        int id = 0;
        try{
            id = Integer.parseInt(idStr);
            customerDAO.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        response.sendRedirect("query.do");
      System.out.println("delete");
    }
    private void edit(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String forwardPath = "/WEB-INF/error.jsp";
        //1.获取请求参数id
        String idStr = request.getParameter("id");
        //2.调用CustomerDAO的customerDAO.get(id)对应的Customer对象customer
        try {
            Customer customer = customerDAO.get(Integer.parseInt(idStr));
            if (customer!=null){
                forwardPath = "/jsp/updatecustomer.jsp";
                //3.将customer放入request中
                request.setAttribute("customer",customer);
            }
        }catch (Exception e){}
        //4.响应updatecustomer.jsp页面：转发
        request.getRequestDispatcher(forwardPath).forward(request,response);
    }
    private void update(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
//        1.获取表单参数：id,name,address,phone,oldName
        String id = new String(request.getParameter("id").getBytes("ISO-8859-1"),"UTF-8");
        String name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
        String Location = new String(request.getParameter("location").getBytes("ISO-8859-1"),"UTF-8");
        String QQ = new String(request.getParameter("QQ").getBytes("ISO-8859-1"),"UTF-8");
        String oldName = new String(request.getParameter("oldName").getBytes("ISO-8859-1"),"UTF-8");
        Integer number = null;
        try {
             number = Integer.parseInt(new String(request.getParameter("number").getBytes("ISO-8859-1"), "utf-8"));
        }catch (Exception e){
            request.setAttribute("error","数量输入格式不正确！");
            request.getRequestDispatcher("/jsp/updatecustomer.jsp").forward(request,response);
            return;
        }
        //        String id = request.getParameter("id");
//        String name = request.getParameter("name");
//        String Location = request.getParameter("location");
//        String QQ = request.getParameter("QQ");
//        String oldName = request.getParameter("oldName");
        //2.检验name是否已经被占用：
        // 2.1 比较name和oldName是否相同，若相同说明name可用。
        //2.2若不相同，则调用CustomerDAO的getCountWithName(String name)获取name在数据库中是否存在
        System.out.println(id);
        System.out.println(name);
        System.out.println(Location);
        System.out.println(QQ);
        System.out.println(oldName);
        System.out.println(number);
        if (!oldName.equalsIgnoreCase(name)){
            long count = customerDAO.getCountWithName(name);
            //2.3若返回值大于0，则响应updatecustomer.jsp页面：通过转发的方式响应updatecustomer.jsp
            if (count>0){
                //2.4在updatecustomer.jsp页面显示一个错误消息；用户名name已经被占用，请重新选择！
                //在request中放入一个属性message：用户名name已经被占用，请重新选择！
                //在页面上通过request.getAttribute("message")的方式来显示
                request.setAttribute("massage","用户名"+name+"已经被占用，请重新选择！");
                //2.5updatecustomer.jsp的表单值可以回显。
                //name,phone 显示提交表单的新的值，而name显示oldName,而不是新提交的name
                //2.6结束方法:return
                System.out.println(request.getParameter("id"));
                request.getRequestDispatcher("/jsp/updatecustomer.jsp").forward(request,response);
                return;
            }
        }
        //3.若通过验证，则把表单参数封装为一个Customer对象customer
        Customer customer = new Customer(name,Location,QQ,number);
        customer.setId(Integer.parseInt(id));
        //4.调用CustomerDAO的update(Customer customer)执行更新操作
        customerDAO.update(customer);
        //5.重定向到query.do
        response.sendRedirect("query.do");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
