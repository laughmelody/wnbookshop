package wnbook.dao.imp;

import wnbook.dao.BaseDao;
import wnbook.dao.WnBookDao;
import wnbook.entity.WnBook;
import wnbook.util.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WnBookDaoImp extends BaseDao implements WnBookDao {
    @Override
    public int insertBook(Connection conn, WnBook wnBook) throws SQLException {
        String sql = "insert into wn_book(book_name,book_price,book_image,book_author,book_publish,book_publish_date,book_type_id) values (?,?,?,?,?,?,?)";
        Object[] objs = {wnBook.getBookName(),wnBook.getBookPrice(),wnBook.getBookImage(),wnBook.getBookAuthor(),wnBook.getBookPublish(),wnBook.getBookPublishDate(),wnBook.getCate().getId()};
        return super.updateData(conn,sql,objs);
    }

    @Override
    public int deleteById(Connection conn, int id) throws SQLException {
        String sql ="delete from wn_book where id = ?";
        return super.updateData(conn,sql,id);
    }

    @Override
    public ResultSet selectAllBook(Connection conn) throws SQLException {
        String sql = "SELECT book.*,cate.type_name FROM wn_book book,wn_book_category cate WHERE book.book_type_id = cate.id";
        return  super.selectData(conn,sql);
    }

    @Override
    public ResultSet selectBookByPage(Connection conn, Page<WnBook> page) throws SQLException {
        String sql = "SELECT book.*,cate.type_name FROM wn_book book,wn_book_category cate WHERE book.book_type_id = cate.id order by id limit ?,?";
        return super.selectData(conn,sql,(page.getCurrentPage()-1)*page.getPageSize(),page.getPageSize());
    }

    @Override
    public int getTotalRecord(Connection conn) throws SQLException {
        String sql = "select count(id) from wn_book";
        ResultSet set = super.selectData(conn,sql);
        if (set.next()){
            return  set.getInt(1);
        }
        return 0;
    }

    @Override
    public ResultSet selectBookById(Connection conn, int id) throws SQLException {
        String sql ="select * from wn_book where id =?";
        return super.selectData(conn,sql,id);
    }

    @Override
    public int updateBookById(Connection conn, WnBook wnBook) throws SQLException {
        String sql = "update wn_book set book_name=?,book_price=?,book_author=?,book_image=?,book_publish=?,book_publish_date=?,book_store_count=?,book_type_id=? where id = ?";
        Object[] objs = {wnBook.getBookName(),wnBook.getBookPrice(),wnBook.getBookAuthor(),wnBook.getBookImage(),
        wnBook.getBookPublish(),wnBook.getBookPublishDate(),wnBook.getBookStoreCount(),wnBook.getCate().getId(),wnBook.getId()};
        return super.updateData(conn,sql,objs);
    }


}
