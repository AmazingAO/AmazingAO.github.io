package DAO;

import domain.CriteriaCustomer;
import domain.Customer;

import java.util.List;

public interface CustomerDAO {
    public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer criteriaCustomer);
    /**
     * 查询方法
     * @return
     */
    public List<Customer>getAll();

    /**
     * 添加方法
     * @param customer
     */
    public void save(Customer customer);

    /**
     * 更新操作
     * @param id
     * @return
     */
    public Customer get(Integer id);

    /**
     * 删除操作
     * @param id
     */
    public void delete(Integer id);

    /**
     * 返回和name相等的记录数
     * @param name
     * @return
     */

    public long getCountWithName(String name);
    public void update(Customer customer);
}
