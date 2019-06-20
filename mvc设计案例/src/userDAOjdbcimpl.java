import DAO.DAO;
import DAO.userDAO;
import domain.Customer;
import domain.PageResult;
import domain.user;
import domain.userpassword;

import java.util.ArrayList;
import java.util.List;

public class userDAOjdbcimpl extends DAO<Customer> implements userDAO {
    /**
     * 用户登陆
     * @param
     * @return
     */
    @Override
    public long get(user userpassword) {
        String sql = "SELECT count(id) FROM tushan.userinfo WHERE phone=? and password=?";
        return (long)getForValue(sql,userpassword.getPhone(),userpassword.getPassword());
    }
    public long get1(user userpassword) {
        String sql = "SELECT count(id) FROM tushan.userinfo WHERE phone=?";
        return (long)getForValue(sql,userpassword.getPhone());
    }

    /**
     * 用户修改密码
     * @param
     */
    @Override
    public void update(user user) {
       String sql = "UPDATE tushan.userinfo SET password=? WHERE phone =? ";
       update(sql,user.getPassword(),user.getPhone());
    }

    /**
     * 用户注册
     * @param user
     */
    @Override
    public void registered(user user) {
        String sql = "INSERT INTO tushan.userinfo(name,older,phone,password) VALUES(?,?,?,?)";
        update(sql,user.getName(),user.getOlder(),user.getPhone(),user.getPassword());
    }

    /**
     * 分页查询
     * @param currentPage 用户传入:当前需要跳转到哪一页
     * @param pageSize  用户传入：当前最多显示多少条数据
     * @return  分页的结果对象
     */
    @Override
    public PageResult query(Integer currentPage, Integer pageSize) {
        //查询结果总数
        String sql = "SELECT count(*) FROM tushan.xinxi";
        long totalCount = (long) getForValue(sql);
        //=============================================================
        //查询结果集
        if (totalCount == 0){
          return PageResult.empty(pageSize);
        }
//        String SQL = "SELECT * FROM tushan.xinxi WHERE QQ>0 LIMIT ?,?";
        String SQL = "SELECT * FROM tushan.xinxi WHERE number>0 LIMIT ?,?";
        List<Customer> list = getForList(SQL, (currentPage-1)*pageSize,pageSize);
        return new PageResult(list, (int) totalCount,currentPage,pageSize);
    }
}
