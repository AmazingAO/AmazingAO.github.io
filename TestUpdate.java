package JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestUpdate {
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
            Connection connection = null;
            Statement statement = null;
            try {
//                String driver;
//                String jdbcUrl;
//                String user;
//                String password;
                connection = JDBCTools.testDriverManager();
                //2.SQL语句
                String SQL = null;
                //SQL="insert into zhangao.table1 (name,email,birth) value('顾少春','1213222955@qq.com','1999-04-21');";
                //SQL="DELETE FROM zhangao.table1 WHERE id =2";
                //SQL="UPDATE  zhangao.table1 SET birth ='1999-04-28' WHERE id = 1";
                String s = "涂山红红";
                SQL="insert into zhangao.table1 (name,email,birth) value("+"'"+s+"'"+",'1213222955@qq.com','1999-04-21');";
                System.out.println(SQL);
                //3.执行插入
                //1）获取操作SQL语句的Statement对象：
                //调用Connection的createStatement（）方法来获取
                statement = connection.createStatement();
                //2）调用Statement对象的executeUpdate（sql）执行SQL语句进行插入
                statement.executeUpdate(SQL);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                JDBCTools.releaseSource(statement,connection);
            }
            //5.关闭Ststement对象

                //2.关闭连接

        }
    }
