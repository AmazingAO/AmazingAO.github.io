package JDBC.DBUtilsTest;

import JDBC.JDBCTools;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 使用QueryRunner提供具体的实现
 * @param <T>：子类需传入的泛型类型。
 */
public class JdbcDaoimp<T> implements DAO<T>{
    tushanDao tushanDao = new tushanDao();

    @Override
    public void batch(Connection connection, String sql, Object[]... args) throws SQLException {

    }

    @Override
    public <E> E getForValue(Connection connection, String sql, Object... args) throws SQLException {
        return null;
    }

    @Override
    public List<T> getForList(Connection connection, String sql, Object... args) throws SQLException {
        return null;
    }

    @Override
    public T get(Connection connection, String sql, Object... args) throws SQLException {

        return null;
    }

    @Override
    public void update(Connection connection, String sql, Object... args) throws SQLException {

    }
}
