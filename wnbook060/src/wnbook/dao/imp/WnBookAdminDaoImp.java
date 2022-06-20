package wnbook.dao.imp;

import wnbook.dao.BaseDao;
import wnbook.dao.WnBookAdminDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WnBookAdminDaoImp extends BaseDao implements WnBookAdminDao {
    @Override
    public ResultSet selectPasswordByName(Connection conn, String adminName) throws SQLException {
        String sql = "select password from wn_book_admin where username=?";
        return super.selectData(conn,sql,adminName);
    }

    @Override
    public ResultSet selectAdminByName(Connection conn, String adminName) throws SQLException {
        String sql = "select * from wn_book_admin where username=?";
        return super.selectData(conn,sql,adminName);
    }
}
