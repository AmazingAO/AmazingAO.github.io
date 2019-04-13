package JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
/*
操作JDBC 的工具类。其中封装了一些工具方法
Version 1
 */
public class JDBCTools {
    /*
    1.获取连接的方法。
     */
    public static Connection testDriverManager() throws Exception {
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
        Connection connection = DriverManager.getConnection(jdbcURL, user, password);
        //System.out.println(connection);
        return connection;
    }

    //关闭数据库资源
    public static void releaseSource(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void releaseSource(ResultSet resultSet,Statement statement, Connection connection) {
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
