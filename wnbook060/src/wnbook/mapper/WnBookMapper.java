package wnbook.mapper;

import wnbook.entity.WnBook;
import wnbook.entity.WnBookAdmin;
import wnbook.util.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface WnBookMapper {

    int insertBook( WnBook user);

    List<WnBook> selectAllBook();
    WnBook selectBookById(int id);
    List<WnBook> selectBookByIds(int[] ids);
    int getTotalRecord(Connection conn);
    List<WnBook> selectBookByCondition(WnBook book);
    Integer updateBook(WnBook book);
    List<WnBook> selectBookByList(List<Integer> ids);
    int deleteBook(int id);
    //好书热卖，新书推荐，收藏最多
    List<WnBook> selectBookByGood();
    List<WnBook> selectBookByNew();
    List<WnBook> selectBookByCollection();
    //前台搜索也用 bycondition
}
