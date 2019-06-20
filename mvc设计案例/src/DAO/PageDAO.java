package DAO;
import domain.borr;

import java.util.List;

public interface PageDAO {
    public void borrow(int id,String name,String phone,String img,String action);
    public void returnB(int id);
    public List<borr> select(String phone);
}
