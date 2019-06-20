package DAO;

import DB.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

/**
 * 封装了基本的DAO操作方法，以供子类继承使用
 * 当前DAO直接在方法中获取数据库连接。
 * @param <T>:当前DAO处理的实体类的类型是什么
 */
public class DAO<T> {
    private QueryRunner queryRunner = new QueryRunner();
    private Class<T> clazz;
      public DAO(){
          Type superClass = getClass().getGenericSuperclass();
          if (superClass instanceof ParameterizedType){
              ParameterizedType parameterizedType = (ParameterizedType)superClass;
              Type [] types = parameterizedType.getActualTypeArguments();
              if (types!=null&&types.length>0){
                  if (types[0]instanceof Class){
                      clazz = (Class<T>)types[0];
                  }
              }
           }
      }
    /**
     * 返回某一个字段的值，例如返回某一条记录的customerName,或返回数据表中有多少条记录等。
     * @param sql
     * @param args
     * @param <E>
     * @return
     */
    public <E> E getForValue(String sql,Object ... args){
        Connection connection = null;
        try{
            connection = JDBCUtils.getConnection();
            return (E)queryRunner.query(connection,sql,new ScalarHandler(),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseConnection(connection);
        }
        return null;
    }
    /**
     * 返回T所对应的List
     * @param sql
     * @param args
     * @return
     */
    public List<T>getForList(String sql,Object ... args){
        Connection connection = null;
        try{
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanListHandler<>(clazz),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseConnection(connection);
        }
        return null;
    }
    /**
     * 返回对应的T的一个实例类的对象
     * @param sql
     * @param args
     * @return
     */
    public T get(String sql,Object ... args){
        Connection connection = null;
        try{
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseConnection(connection);
        }
        return null;
    }
    /**
     * 该方法封装了INSERT,DELETE,UPDATE操作
     * 整个DAO采用DBUtils解决方案
     * @param sql:SQL语句
     * @param args:填充SQL语句的占位符.
     */
    public void update(String sql,Object ... args){
        Connection connection = null;
        try{
            connection = JDBCUtils.getConnection();
            queryRunner.update(connection,sql,args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseConnection(connection);
        }
  }
  public void execute(String SQL){
        Connection connection = null;
        try{
            connection = JDBCUtils.getConnection();
            queryRunner.execute(SQL);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseConnection(connection);
        }
  }
}
