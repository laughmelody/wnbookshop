package wnbook.test;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import wnbook.entity.WnBook;
import wnbook.entity.WnBookCategory;
import wnbook.mapper.WnBookMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestBook {
    SqlSession sqlSession;
    WnBookMapper mapper;
    SqlSession sqlSession2;
    WnBookMapper mapper2;
    @Before
    public void before() {
        // 加载配置文件
        PropertyConfigurator.configure("src/log4j.properties");
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(WnBookMapper.class);
            sqlSession2 = sqlSessionFactory.openSession();
            mapper2 = sqlSession2.getMapper(WnBookMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelect(){

        List<WnBook> list = mapper.selectAllBook();
        System.out.println(list.size()+"---------------");
        List<WnBook> list2 = mapper2.selectAllBook();
        System.out.println(list2.size()+"--------------");
        for (WnBook book : list) {
            System.out.println(book);
        }
    }


    @Test
    public void testSelectCondition(){
        WnBook book = new WnBook();
//        book.setBookName("技");
//        book.setBookPrice(3000.00);
//        book.setCate(new WnBookCategory(3));
        List<WnBook> list = mapper.selectBookByCondition(book);
        for (WnBook book2 : list){
            System.out.println(book2);
            System.out.println("-----------------------");
        }
    }
    @Test
    public void testPage(){
//        Page<WnBook> page = PageHelper.startPage(1,5);
        //使用bootstrap传过来的分页数据 offset limit
        int offset = 10;
        int limit = 5;
        Page<WnBook> page =PageHelper.offsetPage(offset,limit);
        mapper.selectAllBook();
        int totalPage = page.getPages();
        System.out.println("总"+totalPage+"页");

        int pageSize = page.getPageSize();
        System.out.println("页大小是"+pageSize);

        int pageNum = page.getPageNum();
        System.out.println("当前是第"+pageNum+"页");

        long totalRecord = page.getTotal();
        System.out.println("总记录数是:"+totalRecord);
        List<WnBook> list = page.getResult();
        for (WnBook book: list){
            System.out.println(book.getId()+"----->"+book.getBookName()+"----->"+book.getBookPrice());
        }
    }

//    @Test
//    public void testSelectByIds(){
//        int[] ids = {1,3,5,7,9};
//        List<WnBook> list = mapper.selectBookByIds(ids);

//
//        ArrayList<Integer> list = new ArrayList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        List<WnBook> list2 = mapper.selectBookByList(list);
//        for (WnBook book2 : list2){
//            System.out.println(book2);
//            System.out.println("-----------------------");
//        }
//    }
//    @Test
//    public void testSelectByKeyWord(){
//        List<WnBookAdmin> list = mapper.selectAdminByKeyWord("a");
//        for (WnBookAdmin admin : list) {
//            System.out.println(admin);
//        }
//    }
//    @Test
//    public void testAdd(){
//        WnBookAdmin admin = new WnBookAdmin("jack","1234","13322334788");
//        System.out.println(admin);
//        int i = mapper.insertAdmin(admin);
//        System.out.println(i);
//        sqlSession.commit();
//
//    }
//    @Test
//    public void testModify(){
//        WnBookAdmin admin = new WnBookAdmin(3,"jack","lover rose","13322334455");
//        int i = mapper.updateAdmin(admin);
//        System.out.println(i);
//        sqlSession.commit();
//
//    }
//    @Test
//    public void testRemove(){
//        int i = mapper.deleteAdminById(10);
//        System.out.println(i);
//        sqlSession.commit();
//    }

}
