package JDBC;

import javax.swing.plaf.nimbus.State;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class insertSQL {
    //数据查询
    /*
    ResultSet:结果集。封装了使用JDBC进行查询的结果
    1.调用Statement对象的executeQuery(sql)可以得到结果集。
    2.ResultSet返回的实际上就是一张数据表。有一个指针指向数据表的第一样的前面。
    可以调用next（）方法检测下一行是否有效。若有效该方法返回true，切指针下移。相当于Iterator对象的hasNext（）和next（）方法的结合体。
    3.当指针对位到一行时，可以通过调用getXxx（index）或getXxx（columnName）获取每一列的值。例如：getInt（1），getString（“name”）
    4.ResultSet当然也需要进行关闭。
     */
    @org.junit.Test
    public void selectSQL(){
        InputStream in = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String driverClass;
            String jdbcUrl;
            String user;
            String password;
            in = new FileInputStream(new File("jdbc.properties"));
            Properties properties = new Properties();
            properties.load(in);
            driverClass = properties.getProperty("driver");
            jdbcUrl = properties.getProperty("jdbcUrl");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driverClass);
            connection = DriverManager.getConnection(jdbcUrl,user,password);
            String SQL  = null;
            SQL = "SELECT id ,name,email,birth FROM zhangao.table1";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date date = resultSet.getDate("birth");
                System.out.println(id);
                System.out.println(name);
                System.out.println(email);
                System.out.println(date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    通过JDBC向指定的数据表中插入一条记录

    1.Statement：用于执行SQL语句的对象
      1）通过Connection的createStatement（）方法来获取
      2）通过executeUpdate（sql）可以执行SQL语句
      3）传入的 SQL可以是INSRET,UPDATE,或DELETE。但不能是SELECT
    2.Connection，Statement都是应用程序和数据库服务的连接资源。使用后一定要关闭。
    需要在finally中关闭  Connection，Statement对象。
    3.关闭的顺序是：先关闭后获取的。即先关闭Statement后关闭Connection
     */
    @org.junit.Test
    public void insertinto(){
        //1.数据库连接
        String driver;
        String jdbcUrl;
        String user;
        String password;
        Connection connection = null;
        Statement statement = null;
        try {
            InputStream in = new FileInputStream(new File("jdbc.properties"));
            Properties properties = new Properties();
            properties.load(in);
            driver = properties.getProperty("driver");
            jdbcUrl = properties.getProperty("jdbcUrl");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driver);
            connection = DriverManager.getConnection(jdbcUrl,user,password);
            //2.SQL语句
            String SQL = null;
            //SQL="insert into zhangao.table1 (name,email,birth) value('顾少春','1213222955@qq.com','1999-04-21');";
            //SQL="DELETE FROM zhangao.table1 WHERE id =2";
            SQL="UPDATE  zhangao.table1 SET birth ='1999-04-28' WHERE id = 1";
            //3.执行插入
            //1）获取操作SQL语句的Statement对象：
            //调用Connection的createStatement（）方法来获取
            statement = connection.createStatement();
            //2）调用Statement对象的executeUpdate（sql）执行SQL语句进行插入
            statement.executeUpdate(SQL);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //5.关闭Ststement对象

        //2.关闭连接

    }
}
