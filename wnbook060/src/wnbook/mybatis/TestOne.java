package wnbook.mybatis;

import wnbook.entity.WnBookAdmin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import wnbook.entity.WnBookAdmin;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestOne {
    SqlSession sqlSession;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelect(){
        List<WnBookAdmin> list = sqlSession.selectList("wnbook.dao.AdminDao.selectAllAdmin");
        for (WnBookAdmin admin : list) {
            System.out.println(admin);
        }
    }
    @Test
    public void testSelectByKeyWord(){
        List<WnBookAdmin> list = sqlSession.selectList("wnbook.dao.AdminDao.selectAdminByKeyWord","e");
        for (WnBookAdmin admin : list) {
            System.out.println(admin);
        }
    }
    @Test
    public void testAdd(){
        WnBookAdmin admin = new WnBookAdmin("jack","1234","13322334788");
        int i = sqlSession.insert("wnbook.dao.AdminDao.insertAdmin", admin);
        System.out.println(i);
        sqlSession.commit();

    }
    @Test
    public void testModify(){
        WnBookAdmin admin = new WnBookAdmin(3,"jack","lover rose","13322334455");
        int i = sqlSession.update("com.wnbook.dao.AdminDao.updateAdmin", admin);
        System.out.println(i);
        sqlSession.commit();

    }
    @Test
    public void testRemove(){
        int i = sqlSession.delete("wnbook.dao.AdminDao.deleteAdminById", 3);
        System.out.println(i);
        sqlSession.commit();
    }

}
