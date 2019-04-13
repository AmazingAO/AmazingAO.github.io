package JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Date;
import java.util.Properties;

public class selectSQL {
    @org.junit.Test
    public void selectSQL(){
        InputStream in = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCTools.testDriverManager();
            statement = connection.createStatement();
            String SQL  = null;
            SQL = "SELECT id ,name,email,birth FROM zhangao.table1";
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
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCTools.releaseSource(resultSet,statement,connection);
        }
        }

//        try {
//            String driverClass;
//            String jdbcUrl;
//            String user;
//            String password;
//            in = new FileInputStream(new File("jdbc.properties"));
//            Properties properties = new Properties();
//            properties.load(in);
//            driverClass = properties.getProperty("driver");
//            jdbcUrl = properties.getProperty("jdbcUrl");
//            user = properties.getProperty("user");
//            password = properties.getProperty("password");
//            Class.forName(driverClass);
//            connection = DriverManager.getConnection(jdbcUrl,user,password);
//            String SQL  = null;
//            SQL = "SELECT id ,name,email,birth FROM zhangao.table1";
//            statement = connection.createStatement();
//            resultSet = statement.executeQuery(SQL);
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String email = resultSet.getString("email");
//                Date date = resultSet.getDate("birth");
//                System.out.println(id);
//                System.out.println(name);
//                System.out.println(email);
//                System.out.println(date);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            if (resultSet!=null){
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (statement!=null){
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (connection!=null){
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (in!=null){
//                try {
//                    in.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
