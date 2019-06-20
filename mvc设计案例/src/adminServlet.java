import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

import DAO.*;
import domain.*;

@WebServlet(name = "adminServlet", urlPatterns = "*.admin")
public class adminServlet extends HttpServlet {
    private adminsDAO adminsDAO = new adminDAOjdbcimpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //1.获取ServletPath：/edit.do或add.do
        String servletPath = request.getServletPath();
        //2.去除/和.do,得到类似于edit和add这样的字符串

        try {
            String methodName = servletPath.substring(5);
            methodName = methodName.substring(0,methodName.length()-6);
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
    private void landing(HttpServletRequest request,HttpServletResponse response)throws java.io.UnsupportedEncodingException,ServletException,IOException{
        admin admin = new admin();
        String user  = new String(request.getParameter("user").getBytes("ISO-8859-1"),"UTF-8");
        String password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
        admin.setUser(user);
        admin.setPassword(password);
        long l = adminsDAO.get(admin);
        if (l>0){
            System.out.println("登陆成功");
            request.getRequestDispatcher("query.do").forward(request,response);
            //request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
        }else {
            request.setAttribute("massage","用户名或密码错误");
            System.out.println("登陆失败");
            request.getRequestDispatcher("/jsp/admin.jsp").forward(request,response);
        }
    }
    private void update(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        admin admin = new admin();
        String user  = new String(request.getParameter("user").getBytes("ISO-8859-1"),"UTF-8");
        String password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
        admin.setUser(user);
        admin.setPassword(password);
        long l = adminsDAO.get(admin);
        if (l>0) {
            admin admin1 = new admin();
            String user1 = new String(request.getParameter("user").getBytes("ISO-8859-1"), "UTF-8");
            String password1 = new String(request.getParameter("password1").getBytes("ISO-8859-1"), "UTF-8");
            admin1.setUser(user1);
            admin1.setPassword(password1);
            adminsDAO.update(admin1);
            System.out.println("修改密码成功");
            request.getRequestDispatcher("/WEB-INF/adminsucess.jsp").forward(request,response);
        }else {
            request.setAttribute("massage","原用户名或密码错误");
            request.getRequestDispatcher("/jsp/adminupdate.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request,response);
    }
}
