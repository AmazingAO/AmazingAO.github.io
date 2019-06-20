package DAO;

import domain.admin;
import java.util.List;

public interface adminsDAO {
    /**
     * 管理员登陆
     * @return
     */
    public long get(admin admin);

    /**
     * 用户名修改密码
     * @param admin
     */
    public void update(admin admin);
}
