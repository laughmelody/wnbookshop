package wnbook.service;

import wnbook.entity.WnBook;
import wnbook.util.Page;

import java.util.List;

public interface WnBookService {
    int addBook(WnBook book);
    List<WnBook> findAllBooks();
    //多条件查询
//    Page<WnBook> findBookByPage(Page<WnBook> page);
    com.github.pagehelper.Page<WnBook> findBookByCondition(WnBook book, int offset, int limit);
    int removeBookById( int id) ;

    WnBook findBookById(int id);
    List<WnBook> findBooksByHotSale();
    List<WnBook> findBooksByNewDate();
    List<WnBook> findBooksByCollection();

    Page<WnBook> findBooksByName(int currentPage,int pageSize,String name);
    int modifyBook(WnBook book);
}
