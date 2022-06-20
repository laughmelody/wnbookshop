package wnbook.dao;

import wnbook.entity.WnBook;
import wnbook.util.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface WnBookDao {

    int insertBook(Connection conn, WnBook user)throws SQLException;
    int deleteById(Connection conn,int id) throws SQLException;
    ResultSet selectAllBook(Connection conn)throws SQLException;
    ResultSet selectBookByPage(Connection conn, Page<WnBook> page)throws SQLException;
    int getTotalRecord(Connection conn) throws SQLException;
    ResultSet selectBookById(Connection conn,int id)throws SQLException;
    //改
    int updateBookById(Connection conn,WnBook wnBook)throws SQLException;
}
