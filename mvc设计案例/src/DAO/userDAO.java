package DAO;
import domain.PageResult;
import domain.user;
import domain.userpassword;
public interface  userDAO {
    /**
     * 用户登陆
     * @param
     * @return
     */
    public long get(user user);
    public long get1(user user);

    /**
     * 用户修改密码
     * @param
     */
    public void update(user user);
    public void registered(user user);
    public PageResult query(Integer currentPage,Integer pageSize);
}
