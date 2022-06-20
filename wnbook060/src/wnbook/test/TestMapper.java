package wnbook.test;

import org.junit.Before;
import org.junit.Test;
import wnbook.entity.WnBookAdmin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import wnbook.mapper.WnBookAdminMapper;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMapper {

    SqlSession sqlSession;
    WnBookAdminMapper mapper;

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
            mapper = sqlSession.getMapper(WnBookAdminMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelect(){
        List<WnBookAdmin> list = mapper.selectAllAdmin();
        for (WnBookAdmin admin : list) {
            System.out.println(admin);
        }
    }

    @Test
    public void testSelectByKeyWord(){
        List<WnBookAdmin> list = mapper.selectAdminByKeyWord("a");
        for (WnBookAdmin admin : list) {
            System.out.println(admin);
        }
    }
    @Test
    public void testAdminById() {
        WnBookAdmin admin = mapper.selectAdminById(5);
        System.out.println(admin);
    }
    @Test
    public void testAdd(){
        ArrayList<WnBookAdmin> list = new ArrayList<>();
        list.add(new WnBookAdmin("AAA","1234","321876321"));
        WnBookAdmin admin = new WnBookAdmin("jack","1234","13322334788");
        System.out.println(admin);
        int i = mapper.insertAdmin(admin);
        sqlSession.commit();
        System.out.println(i);

    }
//    public void testAddMore(){
//        ArrayList<WnBookAdmin> list = new ArrayList<>();
//        list.add(new WnBookAdmin())
//
//
//        int i = mapper.insertAdmin(list);
//        sqlSession.commit();
//        System.out.println(i);
//
//    }
    @Test
    public void testModify(){
        WnBookAdmin admin = new WnBookAdmin(3,"jack","lover rose","13322334455");
        int i = mapper.updateAdmin(admin);
        System.out.println(i);
        sqlSession.commit();

    }
    @Test
    public void testRemove(){
        int i = mapper.deleteAdminById(10);
        System.out.println(i);
        sqlSession.commit();
    }

    public void testModifyMore(){
        ArrayList<WnBookAdmin> list = new ArrayList<>();
        list.add(new WnBookAdmin(24,"xxx","1234","123123213"));
        list.add(new WnBookAdmin(23,"yyy","1234","123123213"));
        list.add(new WnBookAdmin(22,"zzz","1234","123123213"));


        int i = mapper.updateMore(list);
        sqlSession.commit();
        System.out.println(i);

    }
}
