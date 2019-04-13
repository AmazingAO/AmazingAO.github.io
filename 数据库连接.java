package JDBC.练习;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//zhangao.table1
public class 数据库连接 {
    @org.junit.Test
    public static Connection testDriverManager() throws Exception {
        String driverClass;
        String jdbcUrl;
        String user;
        String password;
        InputStream in = new FileInputStream(new File("jdbc.properties"));
        Properties properties = new Properties();
        properties.load(in);
        driverClass = properties.getProperty("driver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        in.close();
        Class.forName(driverClass);
        Connection connection = DriverManager.getConnection(jdbcUrl,user,password);
        return connection;
    }
}
