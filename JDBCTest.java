package JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTest {
    /*
     DriverManager 是驱动的管理类
     1）.可以通过重载的getConnection（）方法获取数据库连接，较为方便
     2）.可以同时管理多个驱动程序：若注册了多个数据库连接，则调用getConnection（）
     方法时传入的参数不同，即返回不同的数据库连接。
     */
    @org.junit.Test
    public void testDriverManager()throws Exception{
        //1.准备四个字符串
        //驱动的全类名
        String driverClsaa;
        //JDBC URL
        String jdbcURL;
        //user
        String user;
        //password
        String password;
        //读取jdbc.properties文件
        InputStream in = new FileInputStream(new File("jdbc.properties"));
        Properties properties = new Properties();
        properties.load(in);
        driverClsaa = properties.getProperty("driver");
        jdbcURL = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        in.close();
        //2.加载驱动程序（对应的Driver实现类中有注册驱动的静态代码块）
        Class.forName(driverClsaa);
       //3.通过DriverManager的getConnection方法获取数据库连接
        Connection connection = DriverManager.getConnection(jdbcURL,user,password);
       System.out.println(connection);
    }
    /*
      Driver 是一个接口：数据库厂商必须提供实现类的接口。能从中获取数据库连接。
      可以通过Drive的类实现对象获取数据库连接。
     */
    //不是通用的
    @org.junit.Test
    public void TestDriver() throws SQLException {
        //1.创建一个Driver 类实现的对象
        Driver driver = new com.mysql.cj.jdbc.Driver();
        //2.准备连接数据库的基本内容：url,user,password
        String url = "jdbc:mysql://localhost:3306/张傲?serverTimezone=GMT%2B8";
        Properties info = new Properties();
        info.put("user","root");
        info.put("password","mysql123");
        //3.调用Driver接口的 connect(url,info)获取数据库连接
        Connection connection = driver.connect(url,info);
        System.out.println(connection);
    }
    //是同用的
    public Connection getConnection() throws Exception{
        String driverClass = null;//所用数据库的类型
        String jdbcUrl = null;//数据库的URL
        String user = null;//账户
        String password = null;//密码
        //读取
        InputStream in = new FileInputStream(new File("jdbc.properties"));
//        byte[] b = new byte[40];
//        int len = 0;
//         while ((len = in.read(b))!=-1){
//             String s = new String(b,0,len);
//             System.out.println(s);
//         }
        System.out.println(1111);
        Properties properties = new Properties();
        properties.load(in);
        driverClass = properties.getProperty("driver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        System.out.println(driverClass);
        System.out.println(jdbcUrl);
        System.out.println(user);
        System.out.println(password);
        //通过反射建立Driver对象
        Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Properties info = new Properties();
        info.put("user",user);
        info.put("password",password);
        //通过Driver的connect方法获取数据库连接。
        Connection connection = driver.connect(jdbcUrl,info);

        return connection;
    }
    @org.junit.Test
    public void testGetConnection()throws Exception{
        System.out.println(getConnection());
    }
}
