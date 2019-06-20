import com.mysql.jdbc.StringUtils;
import domain.*;
import domain.PageResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "PageServlet",urlPatterns = "*.page")
public class PageServlet extends HttpServlet {
    userDAOjdbcimpl userDAOjdbcimpl = new userDAOjdbcimpl();
    PageDAOjdbcimpl pageDAOjdbcimpl = new PageDAOjdbcimpl();
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
    private void select(HttpServletRequest request,HttpServletResponse response)throws  IOException,ServletException{
        String phone = request.getParameter("phone");
        request.setAttribute("phone",phone);
        Integer currentPage = 1;
        String sCurrentPage = request.getParameter("currentPage");
        if (sCurrentPage!=null){
            currentPage= Integer.valueOf(sCurrentPage);
        }
        PageResult pageResult = userDAOjdbcimpl.query(currentPage,12);
        request.setAttribute("currentPage",pageResult.getCurrentPage());
        request.setAttribute("pageSize",pageResult.getPageSize());
        request.setAttribute("TotalCount",pageResult.getTotalCount());
        request.setAttribute("totalPage",pageResult.getTotalPage());
        request.setAttribute("nextPage",pageResult.getNextPage());
        request.setAttribute("prevPage",pageResult.getPrevPage());
        request.setAttribute("beginPage",pageResult.getBeginPage());
        request.setAttribute("customers",pageResult.getListData());
//        System.out.println(pageResult.getListData().size());
        request.getRequestDispatcher("/jsp/Page.jsp").forward(request,response);
    }
    private void borrow(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        String ID = request.getParameter("id");
        int id = Integer.parseInt(ID);
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String img = request.getParameter("QQ");
        String action = request.getParameter("action");
        System.out.println(phone);
        pageDAOjdbcimpl.borrow(id,name,phone,img,action);
        request.getRequestDispatcher("select.page").forward(request,response);
    }
    private void get(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        String phone = request.getParameter("phone");
        List<borr> borr = pageDAOjdbcimpl.select(phone);
        System.out.println(borr.size());
        request.setAttribute("borr",borr);
        request.setAttribute("phone",phone);
        request.getRequestDispatcher("/jsp/borr.jsp").forward(request,response);
    }
    private void returnB(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        String ID = request.getParameter("id");
        String phone = request.getParameter("phone");
        request.setAttribute("phone",phone);
        int id = Integer.parseInt(ID);
        pageDAOjdbcimpl.returnB(id);
        request.getRequestDispatcher("get.page").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
