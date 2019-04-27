package JDBC.数据库连接池;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBCtest {
    /*
    1.加载dbcp的properties配置文件：配置文件中的键需要来自BasicDataSourceFactory的属性
    2.调用BasicDataSourceFactory的createDataSource方法创建DataSource实例
    3.从DataSource实例中获取数据库连接。
     */
    public void testDBCPWithDataSourceFactory()throws Exception{
        Properties properties = new Properties();
        InputStream in = new FileInputStream(new File("jdbc1.properties"));
        properties.load(in);
        DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
        System.out.println(dataSource);
        BasicDataSource basicDataSource = (BasicDataSource) dataSource;
        System.out.println(basicDataSource.getMaxWait());
    }
    /*
    使用DBCP数据库连接池
    1.加入jar包，依赖于Commons Pool
    2.创建数据库连接池
     */
    @org.junit.Test
    public void testDBCP()throws Exception{
        BasicDataSource dataSource = null;
        //1.创建DBPC数据源实例
        dataSource = new BasicDataSource();
        //2.为数据源实例指定必须的属性
        dataSource.setUsername("root");
        dataSource.setPassword("mysql123");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test??useUnicode=true&characterEncoding=utf8&useSSL=true");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        //3.指定数据源的一些可选的属性
        //1）.指定数据库连接池中初始化连接数的个数
        dataSource.setInitialSize(10);
        //2).指定最大的连接数：同一时刻同时向数据库申请的连接数
        dataSource.setMaxActive(50);
        //3).指定最小连接数：在数据库连接池中保存的最少的空闲连接数量
        dataSource.setMinIdle(5);
        //4).等待数据库连接池分配连接的最长时间。单位为毫秒。超出该时间将抛出异常。
        dataSource.setMaxWait(1000*5);
        //4.从数据源中获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        BasicDataSource basicDataSource = (BasicDataSource) dataSource;
        System.out.println(basicDataSource.getMaxWait());
    }
}
