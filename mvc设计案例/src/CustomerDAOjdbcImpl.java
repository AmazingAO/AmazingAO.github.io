import DAO.CustomerDAO;
import DAO.DAO;
import domain.CriteriaCustomer;
import domain.Customer;

import java.util.List;

public class CustomerDAOjdbcImpl extends DAO<Customer> implements CustomerDAO {
    @Override
    public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer criteriaCustomer) {
        String SQL = "SELECT id,name,Location,QQ,number FROM tushan.xinxi WHERE name LIKE ? AND Location LIKE ? AND QQ LIKE ?;";
        //修改了CriteriaCustomer的getter方法:使其返回的字符串中有"%%";
        //若返回值为null则返回"%%",若不为null,则返回"%"+字段本身的值+"%";
        return getForList(SQL,criteriaCustomer.getName(),criteriaCustomer.getLocation(),criteriaCustomer.getQQ());
    }

    @Override
    public List<Customer> getAll() {
        String SQL = "SELECT id,name,Location,QQ,number FROM tushan.xinxi;";
        return getForList(SQL);
    }

    @Override
    public void save(Customer customer) {
       String SQL = "INSERT INTO tushan.xinxi(name,Location,QQ,number) VALUES(?,?,?,?)";
       update(SQL,customer.getName(),customer.getLocation(),customer.getQQ(),customer.getNumber());
    }

    @Override
    public Customer get(Integer id) {
        String SQL="SELECT id,name,Location,QQ,number FROM tushan.xinxi WHERE id=?";
        return get(SQL,id);
    }

    @Override
    public void delete(Integer id) {
      String SQL = "DELETE FROM tushan.xinxi WHERE id = ?";
      update(SQL,id);
    }

    @Override
    public long getCountWithName(String name) {
        String SQL = "SELECT count(id) FROM tushan.xinxi WHERE name = ?";
        return getForValue(SQL,name);
    }

    @Override
    public void update(Customer customer) {
        String SQL = "UPDATE tushan.xinxi SET name = ?,Location = ?,QQ = ?,number = ? WHERE id = ?";
        update(SQL,customer.getName(),customer.getLocation(),customer.getQQ(),customer.getNumber(),customer.getId());
    }
}
