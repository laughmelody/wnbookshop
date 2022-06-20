package wnbook.util;

import java.util.List;

public class Page<T> {
    private int currentPage;
    private int pageSize;
    private int totalRecord;
    private List<T> list;
    public Page(int currentPage,int pageSize){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
    //总页数
    public int getTotalPage(){
        return (totalRecord + pageSize -1)/pageSize;
    }
    //上一页
    public int getPrePage(){
        if (currentPage > 1){
            return currentPage- 1;
        }
        return 1;
    }
    //下一页
    public int getNextPage(){
        if (currentPage < getTotalPage()){
            return  currentPage + 1;
        }
        return getTotalPage();
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", list=" + list +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
