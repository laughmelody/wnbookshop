package wnbook.dao;

import wnbook.entity.WnBookCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface WnBookCategoryDao {
    ResultSet selectCategoryByName(Connection conn, String name)throws SQLException;
    ResultSet insertCategory(Connection conn, WnBookCategory cate)throws SQLException;
    ResultSet selectAllCategory(Connection conn)throws SQLException;
    ResultSet selectCategoryById(Connection conn,int id)throws  SQLException;

}
