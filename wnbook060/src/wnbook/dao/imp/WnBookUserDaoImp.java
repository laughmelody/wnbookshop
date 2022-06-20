package wnbook.dao.imp;

import wnbook.dao.BaseDao;
import wnbook.dao.WnBookUserDao;
import wnbook.entity.WnBookUser;
import wnbook.util.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WnBookUserDaoImp extends BaseDao implements WnBookUserDao {
    @Override
    public ResultSet selectPasswordByName(Connection conn, String userName) throws SQLException {
        return null;
    }

    @Override
    public ResultSet selectUserByName(Connection conn, String userName) throws SQLException {
        String sql = "select * from wn_book_user where username=?";
        return super.selectData(conn,sql,userName);

    }

    @Override
    public int insertUser(Connection conn, WnBookUser user) throws SQLException {
        String sql = "insert into wn_book_user(username,password) values(?,?)";
        return super.updateData(conn,sql,user.getUsername(),user.getPassword());
    }

    @Override
    public int[] insertMore(Connection conn, List<WnBookUser> list) throws SQLException {
        return new int[0];
    }

    @Override
    public ResultSet selectAllUsers(Connection conn) throws SQLException {
        String sql = "select * from wn_book_user";
        return super.selectData(conn,sql);
    }

    @Override
    public ResultSet selectUserByPage(Connection conn, Page<WnBookUser> page) throws SQLException {
        String sql = "select * from wn_book_user limit ?,?";
        Object[] objs = {(page.getCurrentPage()-1) * page.getPageSize(),page.getPageSize()};
        return super.selectData(conn,sql,objs);
    }

    @Override
    public int getTotalRecord(Connection conn) throws SQLException {
        String sql = "select count(id) from wn_book_user";
        ResultSet set  = super.selectData(conn,sql);
        if (set.next()){
            return  set.getInt(1);
        }
        return 0;
    }

    @Override
    public ResultSet selectUserById(Connection conn, int id) throws SQLException {
        return null;
    }
}
