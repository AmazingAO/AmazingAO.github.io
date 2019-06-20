import DAO.DAO;
import DAO.adminsDAO;
import domain.admin;

import java.util.List;

public class adminDAOjdbcimpl extends DAO implements adminsDAO{
    @Override
    public long get(admin admin) {
        String sql = "SELECT count(id) FROM tushan.admin WHERE user=? and password=?";
          return (long)getForValue(sql,admin.getUser(),admin.getPassword());
    }

    @Override
    public void update(admin admin) {
        String sql = "UPDATE tushan.admin SET password=? WHERE user = ?";
        update(sql,admin.getPassword(),admin.getUser());
    }
}
