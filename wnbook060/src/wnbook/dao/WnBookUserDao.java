package wnbook.dao;

import wnbook.entity.WnBook;
import wnbook.entity.WnBookUser;
import wnbook.util.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface WnBookUserDao {
    ResultSet selectPasswordByName(Connection conn,String userName)throws SQLException;
    ResultSet selectUserByName(Connection conn,String userName)throws SQLException;
    int insertUser(Connection conn, WnBookUser user)throws SQLException;
    int[] insertMore(Connection conn, List<WnBookUser> list)throws SQLException;
    ResultSet selectAllUsers(Connection conn)throws SQLException;
    ResultSet selectUserByPage(Connection conn, Page<WnBookUser> page)throws SQLException;
    int getTotalRecord(Connection conn) throws SQLException;
    ResultSet selectUserById(Connection conn,int id)throws SQLException;
}
