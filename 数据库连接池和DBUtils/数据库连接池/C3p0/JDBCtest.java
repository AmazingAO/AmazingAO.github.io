package JDBC.数据库连接池.C3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class JDBCtest  {
    /*
    1.创建c3p0-config.xml文件
    2.创建ComboPooledDataSources实例：DataSource dataSource = new ComboPooledDataSource("helloC3P0");
    3.从DataSource实例中获取数据库连接。
     */
    @org.junit.Test
    public void testC3P0WithConfigFile()throws Exception{
        DataSource dataSource = new ComboPooledDataSource("helloC3P0");
        System.out.println(dataSource.getConnection());
        ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource)dataSource;
        System.out.println(comboPooledDataSource.getMaxStatements());
    }
    @org.junit.Test
    public void testC3P09()throws Exception{
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.jdbc.Driver" );
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test??useUnicode=true&characterEncoding=utf8&useSSL=true" );
        cpds.setUser("root");
        cpds.setPassword("mysql123");
        System.out.println(cpds.getConnection());
    }
}
