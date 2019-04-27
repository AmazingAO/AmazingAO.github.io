package JDBC.DBUtilsTest;

import JDBC.JDBCTools;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
测试DBUtils测试类
该方法可用于INSERT,UPDATE,DELETE
 */
public class DBUtilsTest {
    /*
    ScalarHandler:把结果集转换为一个数值（可以是任意的基本数据类型 如：字符串）返回。
     */
    @org.junit.Test
    public void testScalarHandler(){
        Connection connection =null;
        QueryRunner queryRunner = new QueryRunner();
        try{
            connection = JDBCTools.testDriverManager();
            String SQL= "SELECT name FROM zhangao.tushan WHERE id = ?";
             Object tushans = queryRunner.query(connection,SQL,new ScalarHandler(),1);
            System.out.println(tushans);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCTools.releaseSource(null,connection);
        }
    }
    /*
    MapListHandler:将结果集转为一个Map的List
    Map 对应查询的一条记录：SQL查询的列名（不是列的别名），值：列的值。
    而MapListHandler:返回的多条记录对应的Map的集合。
     */
    @org.junit.Test
    public void  testMaoListHandler(){
        Connection connection =null;
        QueryRunner queryRunner = new QueryRunner();
        try{
            connection = JDBCTools.testDriverManager();
            String SQL= "SELECT id,name,ord FROM zhangao.tushan";
            List<Map<String,Object>> tushans = queryRunner.query(connection,SQL,new MapListHandler());
            System.out.println(tushans);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCTools.releaseSource(null,connection);
        }
    }
    /*
    MapHandler:返回SQL对应的第一条记录的Map对象。
    键：SQL查询的列名（不是列的别名），值：列的值。
     */
    @org.junit.Test
    public void testMapHandler(){
        Connection connection =null;
        QueryRunner queryRunner = new QueryRunner();
        try{
            connection = JDBCTools.testDriverManager();
            String SQL= "SELECT id,name,ord FROM zhangao.tushan";
           Map<String,Object> tushans = queryRunner.query(connection,SQL,new MapHandler());
            System.out.println(tushans);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCTools.releaseSource(null,connection);
        }

    }
    /*
    BeanListHandler:把结果集转为一个List,该List不为null，但可能为空集合（size()方法返回0）
    若SQL语句的确能查询到记录，List中存放创建BeanListHandler 传入的Class对象对应的对象。
     */
    @org.junit.Test
    public void testBeanListHandler(){
        Connection connection =null;
        QueryRunner queryRunner = new QueryRunner();
        try{
            connection = JDBCTools.testDriverManager();
            String SQL= "SELECT id,name,ord FROM zhangao.tushan";
            List<tushan> tushans = (List<tushan>) queryRunner.query(connection,SQL,new BeanListHandler(tushan.class));
            System.out.println(tushans);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCTools.releaseSource(null,connection);
        }
    }
    /*
    BeanHandler:把结果集的第一条记录转换为创建BeanHandler对象时传入的Class参数对应的对象。
     */
    @org.junit.Test
    public void testBeanHanlder(){
        Connection connection =null;
        QueryRunner queryRunner = new QueryRunner();
        try{
            connection = JDBCTools.testDriverManager();
            String SQL= "SELECT id,name,ord FROM zhangao.tushan WHERE id = ?;";
            tushan tushan = (JDBC.DBUtilsTest.tushan) queryRunner.query(connection,SQL,new BeanHandler(JDBC.DBUtilsTest.tushan.class),1);
            System.out.println(tushan);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCTools.releaseSource(null,connection);
        }
    }
    class MyResultSetHandler implements ResultSetHandler{
        @Override
        public Object handle(ResultSet resultSet) throws SQLException {
            //System.out.println("涂山红红......");
            List<tushan> tushans  = new ArrayList<>();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int ord = resultSet.getInt(3);
                tushan tushan = new tushan(id,name,ord);
                tushans.add(tushan);
            }
            return tushans;
        }
    }
    /*
    QueryRunner 的 query 方法的返回值取决于其ResultSetHandler 参数的handle方法的返回值
     */
    @org.junit.Test
    public void testQuery(){
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = null;
        try{
          connection = JDBCTools.testDriverManager();
          String SQL = "SELECT id,name,ord FROM zhangao.tushan;";
          Object obj = queryRunner.query(connection,SQL,new MyResultSetHandler());
          System.out.println(obj);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCTools.releaseSource(null,connection);
        }
    }
    @org.junit.Test
    public void testQueryRunnerUpdate(){
        //1.创建QueryRunner
        QueryRunner queryRunner = new QueryRunner();
        //2.使用其update方法
        String SQL = "DELETE FROM zhangao.table1 WHERE id = ?";
        Connection connection = null;
        try{
            connection = JDBCTools.testDriverManager();
             queryRunner.update(connection,SQL,4);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCTools.releaseSource(null,connection);
        }
    }
}
