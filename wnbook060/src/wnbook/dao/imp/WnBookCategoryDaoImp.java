package wnbook.dao.imp;

import wnbook.dao.BaseDao;
import wnbook.dao.WnBookAdminDao;
import wnbook.dao.WnBookCategoryDao;
import wnbook.entity.WnBookCategory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WnBookCategoryDaoImp extends BaseDao implements WnBookCategoryDao {

    @Override
    public ResultSet selectCategoryByName(Connection conn, String name) throws SQLException {
        return null;
    }

    @Override
    public ResultSet insertCategory(Connection conn, WnBookCategory cate) throws SQLException {
        return null;
    }

    @Override
    public ResultSet selectAllCategory(Connection conn) throws SQLException {
        String sql = "select * from wn_book_category";
        return super.selectData(conn,sql);
    }

    @Override
    public ResultSet selectCategoryById(Connection conn, int id) throws SQLException {
        return null;
    }
}
