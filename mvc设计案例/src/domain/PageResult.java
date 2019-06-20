package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//分页的结果对象
public class PageResult {
    private List<Customer> listData;//结果集数据.SQL查询
    private Integer totalCount;//结果总条数。SQK查询

    private Integer currentPage;//当前页，用户传入;
    private Integer pageSize;//每页条数，用户传入;

    private Integer beginPage=1;//首页
    private Integer prevPage;//上页；计算
    private Integer nextPage;//下页; 计算
    private Integer totalPage;//末页/总页数；计算

    public PageResult(int i, Integer pageSize, ArrayList arrayList, int size) {
    }

    public PageResult() {
    }

    public static PageResult empty(Integer pageSize){
        return new PageResult(1,pageSize, (ArrayList) Collections.EMPTY_LIST,0);
    }
    public PageResult(List<Customer> listData, Integer totalCount, Integer currentPage, Integer pageSize) {
        this.listData = listData;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalCount % pageSize == 0 ? totalCount/pageSize : totalCount/pageSize + 1;
        this.prevPage = currentPage - 1>= 1 ? currentPage-1 : 1;
        if (currentPage + 1<=totalPage){
            this.nextPage =currentPage + 1;
        }else {
            this.nextPage =totalPage;
        }
    }

    public List<Customer> getListData() {
        return listData;
    }

    public void setListData(List<Customer> listData) {
        this.listData = listData;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBeginPage() {
        return beginPage;
    }

    public Integer getPrevPage() {
        return prevPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "listData=" + listData +
                ", totalCount=" + totalCount +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", beginPage=" + beginPage +
                ", prevPage=" + prevPage +
                ", nextPage=" + nextPage +
                ", totalPage=" + totalPage +
                '}';
    }
}
