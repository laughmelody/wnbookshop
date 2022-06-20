package wnbook.dao;

import wnbook.entity.WnBookAdmin;
import wnbook.util.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface WnBookAdminDao {
    ResultSet selectPasswordByName(Connection conn, String adminName)throws SQLException;
    ResultSet selectAdminByName(Connection conn,String adminName)throws SQLException;

}
