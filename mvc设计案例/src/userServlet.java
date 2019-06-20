import DAO.userDAO;
import domain.admin;
import domain.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;


@WebServlet(name = "userServlet",urlPatterns = "*.user")
public class userServlet extends HttpServlet {
    private userDAO userDAO = new userDAOjdbcimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取ServletPath：/edit.do或add.do
        String servletPath = request.getServletPath();
        //2.去除/和.do,得到类似于edit和add这样的字符串

        try {
            String methodName = servletPath.substring(5);
            methodName = methodName.substring(0,methodName.length()-5);
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
    //用户注册
    private void registered(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        user userpasswords = new user();
        String phones  = new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
        String passwords = new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
        userpasswords.setPhone(phones);
        userpasswords.setPassword(passwords);
        long l = userDAO.get1(userpasswords);
        if (l>0){
            request.setAttribute("massage", "该电话已被注册！！！");
            request.getRequestDispatcher("/jsp/userregistered.jsp").forward(request, response);
        }else {
            user user = new user();
            String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
            String older = new String(request.getParameter("older").getBytes("ISO-8859-1"), "UTF-8");
            String phone = new String(request.getParameter("phone").getBytes("ISO-8859-1"), "UTF-8");
            String password = new String(request.getParameter("password").getBytes("ISO-8859-1"), "UTF-8");
            String password1 = new String(request.getParameter("password1").getBytes("ISO-8859-1"), "UTF-8");
            if (password.equals(password1)) {
                user.setName(name);
                user.setOlder(older);
                user.setPhone(phone);
                user.setPassword(password);
                userDAO.registered(user);
                System.out.println("注册成功！！");
                request.setAttribute("sucess","注册成功！！");
                request.getRequestDispatcher("/jsp/userregistered.jsp").forward(request, response);
            } else {
                request.setAttribute("massage", "第二次输入的密码不匹配！！！");
                request.getRequestDispatcher("/jsp/userregistered.jsp").forward(request, response);
            }
        }
    }
    //用户登陆
    private void landing(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        user userpassword = new user();
        System.out.println(request.getParameter("phone"));
        System.out.println(request.getParameter("password"));
        String phone  = new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
        request.setAttribute("phone",phone);
        String password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
        userpassword.setPhone(phone);
        userpassword.setPassword(password);
        long l = userDAO.get(userpassword);
        if (l>0){
            System.out.println("登陆成功");
            request.getRequestDispatcher("select.page").forward(request,response);
        }else {
            request.setAttribute("massage","用户名或密码错误");
            System.out.println("登陆失败");
            request.getRequestDispatcher("/jsp/user.jsp").forward(request,response);
        }
    }
    //用户修改密码
    private void update(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        user userpassword = new user();
        String phone  = new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
        String password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
        userpassword.setPhone(phone);
        userpassword.setPassword(password);
        long l = userDAO.get(userpassword);
        if (l>0) {
            user user  = new user();
            String phone1  = new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
            String password1 = new String(request.getParameter("password1").getBytes("ISO-8859-1"),"UTF-8");
            user.setPhone(phone1);
            user.setPassword(password1);
            userDAO.update(user);
            System.out.println("修改密码成功");
            request.setAttribute("massage","修改密码成功");
            request.getRequestDispatcher("/jsp/userupdate.jsp").forward(request,response);
        }else {
            request.setAttribute("massage","原用户名或密码错误");
            request.getRequestDispatcher("/jsp/userupdate.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doPost(request,response);
    }
}
