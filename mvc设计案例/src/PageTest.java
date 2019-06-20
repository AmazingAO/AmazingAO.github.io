import DAO.DAO;
import domain.Customer;
import domain.PageResult;
import org.junit.Test;

import java.util.List;

public class PageTest   extends DAO<Customer> {
    @Test
    public void test1()  throws Exception{
        //用户传入
        Integer currentPage  = 1;//当前第几页
        Integer pageSize = 2;//每页最多多少条数据

        //查询结果总数
        String sql = "SELECT count(*) FROM tushan.xinxi";
        long totalCount = (long)getForValue(sql);
        System.out.println(totalCount);
        //==========================================================
//        //查询结果集
//        String SQL = "SELECT * FROM tushan.xinxi LIMIT ?,?";
//        List<Customer> list = getForList(SQL,(currentPage-1),pageSize);
//      System.out.println(list);
        userDAOjdbcimpl userDAOjdbcimpl = new userDAOjdbcimpl();
        PageResult pageResult = userDAOjdbcimpl.query(currentPage,pageSize);
        for (Customer o: pageResult.getListData()){
            System.out.println(o);
        }
    }
}
