import DAO.*;
import domain.borr;

import java.util.List;

public class PageDAOjdbcimpl extends DAO<borr> implements PageDAO {
    @Override
    public void borrow(int  id,String name,String phone,String img,String action) {
        String SQL = "INSERT INTO tushan.borr(book,bookid,phone,img,action) VALUES(?,?,?,?,?)";
        update(SQL,name,id,phone,img,action);
    }
    public void returnB(int id){
       String SQL = "DELETE FROM tushan.borr WHERE id = ?";
       update(SQL,id);
    }

    @Override
    public List<borr> select(String phone) {
        String SQL = "SELECT id,book,bookid,phone,img,action FROM tushan.borr WHERE phone=?;";
        return getForList(SQL,phone);
    }
}
