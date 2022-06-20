package wnbook.service.imp;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import wnbook.entity.WnBook;
import wnbook.mapper.WnBookMapper;
import wnbook.service.WnBookService;
//import wnbook.util.Page;
import java.io.IOException;
import java.io.InputStream;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class WnBookServiceImp implements WnBookService {
    private SqlSession sqlSession;
    private WnBookMapper mapper;
    public WnBookServiceImp(){
//        PropertyConfigurator.configure("src/log4j.properties");
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(WnBookMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<WnBook> findBooksByHotSale() {
        return mapper.selectBookByGood();
    }

    @Override
    public List<WnBook> findBooksByNewDate() {
        return mapper.selectBookByNew();
    }

    @Override
    public List<WnBook> findBooksByCollection() {
        return mapper.selectBookByCollection();
    }

    @Override
    public int addBook(WnBook book) {
//        Connection conn = DbHelper.getConnection();
//        try {
//           return wnBookDaoImp.insertBook(conn,book);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            wnBookDaoImp.closeAll();
//        }

        int i = mapper.insertBook(book);
        sqlSession.commit();
        return i;
    }

    @Override
    public List<WnBook> findAllBooks() {
//        ArrayList<WnBook> list = new ArrayList<>();
//        Connection conn = DbHelper.getConnection();
//        try {
//            ResultSet set=wnBookDaoImp.selectAllBook(conn);
//            while (set.next()){
//                int id = set.getInt("id");
//                String bookName = set.getString("book_name");
//                String bookImage = set.getString("book_image");
//                String bookAuthor = set.getString("book_author");
//                String bookPublish = set.getString("book_publish");
//                Timestamp bookPublishDate = set.getTimestamp("book_publish_date");
//                double bookPrice = set.getDouble("book_price");
//                String bookIntroduce = set.getString("book_introduce");
//                int bookStoreCount = set.getInt("book_store_count");
//                int bookSaleCount = set.getInt("book_sale_count");
//                int bookCollectionCount = set.getInt("book_collection_count");
//                int bookStatus = set.getInt("book_status");
//                Timestamp gmtCreate = set.getTimestamp("gmt_create");
//                Timestamp gmtModified = set.getTimestamp("gmt_modified");
//                boolean isDelete = set.getInt("is_delete")>0?true:false;
//                int bookTypeId = set.getInt("book_type_id");
//                String typeName = set.getString("type_name");
//                list.add(new WnBook(id,bookName,bookImage,bookAuthor,bookPublish,bookPublishDate,
//                        bookPrice,new WnBookCategory(bookTypeId,typeName),bookIntroduce,bookStoreCount,
//                        bookSaleCount,bookCollectionCount, bookStatus,gmtCreate,gmtModified,isDelete));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            wnBookDaoImp.closeAll();
//        }
//        return list;
      return mapper.selectAllBook();
    }


//    public Page<WnBook> findBookByPage(Page<WnBook> page) {
//        ArrayList<WnBook> list = new ArrayList<>();
//        Connection conn = DbHelper.getConnection();
//        try {
       //     int totalRecord = wnBookDaoImp.getTotalRecord(conn);
//            ResultSet set=wnBookDaoImp.selectBookByPage(conn,page);
//            while (set.next()){
//                int id = set.getInt("id");
//                String bookName = set.getString("book_name");
//                String bookImage = set.getString("book_image");
//                String bookAuthor = set.getString("book_author");
//                String bookPublish = set.getString("book_publish");
//                Timestamp bookPublishDate = set.getTimestamp("book_publish_date");
//                double bookPrice = set.getDouble("book_price");
//                String bookIntroduce = set.getString("book_introduce");
//                int bookStoreCount = set.getInt("book_store_count");
//                int bookSaleCount = set.getInt("book_sale_count");
//                int bookCollectionCount = set.getInt("book_collection_count");
//                int bookStatus = set.getInt("book_status");
//                Timestamp gmtCreate = set.getTimestamp("gmt_create");
//                Timestamp gmtModified = set.getTimestamp("gmt_modified");
//                boolean isDelete = set.getInt("is_delete")>0?true:false;
//                int bookTypeId = set.getInt("book_type_id");
//                String typeName = set.getString("type_name");
//                list.add(new WnBook(id,bookName,bookImage,bookAuthor,bookPublish,bookPublishDate,
//                        bookPrice,new WnBookCategory(bookTypeId,typeName),bookIntroduce,bookStoreCount,
//                        bookSaleCount,bookCollectionCount, bookStatus,gmtCreate,gmtModified,isDelete));
//            }
//            page.setList(list);
//            page.setTotalRecord(totalRecord);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            wnBookDaoImp.closeAll();
//        }
//        return page;
//
//        return mapper.selectBookByPage();
//    }
    @Override
    public Page<WnBook> findBookByCondition(WnBook book, int offset, int limit){
        Page<WnBook> page = PageHelper.offsetPage(offset,limit);
        mapper.selectBookByCondition(book);
        return page;
    }
    @Override
    public int removeBookById(int id) {
//        Connection conn = DbHelper.getConnection();
//        try {
//            return wnBookDaoImp.deleteById(conn, id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        int i = mapper.deleteBook(id);
        sqlSession.commit();
        return  i;
    }
    @Override
    public WnBook findBookById(int outId) {
//        ArrayList<WnBook> list = new ArrayList<>();
//        Connection conn = DbHelper.getConnection();
//        try {
//            ResultSet set=wnBookDaoImp.selectBookById(conn,outId);
//            if (set.next()){
//                int id = set.getInt("id");
//                String bookName = set.getString("book_name");
//                String bookImage = set.getString("book_image");
//                String bookAuthor = set.getString("book_author");
//                String bookPublish = set.getString("book_publish");
//                Timestamp bookPublishDate = set.getTimestamp("book_publish_date");
//                double bookPrice = set.getDouble("book_price");
//                String bookIntroduce = set.getString("book_introduce");
//                int bookStoreCount = set.getInt("book_store_count");
//                int bookSaleCount = set.getInt("book_sale_count");
//                int bookCollectionCount = set.getInt("book_collection_count");
//                int bookStatus = set.getInt("book_status");
//                Timestamp gmtCreate = set.getTimestamp("gmt_create");
//                Timestamp gmtModified = set.getTimestamp("gmt_modified");
//                boolean isDelete = set.getInt("is_delete")>0?true:false;
//                int bookTypeId = set.getInt("book_type_id");
//
//                return (new WnBook(id,bookName,bookImage,bookAuthor,bookPublish,bookPublishDate,
//                        bookPrice,new WnBookCategory(bookTypeId),bookIntroduce,bookStoreCount,
//                        bookSaleCount,bookCollectionCount, bookStatus,gmtCreate,gmtModified,isDelete));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            wnBookDaoImp.closeAll();
//        }
       return  mapper.selectBookById(outId);

    }

    @Override
    public int modifyBook(WnBook book) {
//        Connection conn = DbHelper.getConnection();
//        try {
//            return wnBookDaoImp.updateBookById(conn,book);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            wnBookDaoImp.closeAll();
//        }
        int i = mapper.updateBook(book);
        sqlSession.commit();
        return i;
    }

    @Override
    public wnbook.util.Page<WnBook> findBooksByName(int currentPage, int pageSize, String name) {
        return null;
    }
}
