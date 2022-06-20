package wnbook.test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import wnbook.entity.WnBook;
import wnbook.entity.WnBookCategory;
import wnbook.mapper.WnBookCategoryMapper;
import wnbook.mapper.WnBookMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestCate {
    SqlSession sqlSession;
    WnBookCategoryMapper mapper;
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
            mapper = sqlSession.getMapper(WnBookCategoryMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectById(){
        int id = 1;
        WnBookCategory cate = mapper.selectAllHaveList(id);
        System.out.println(cate);
        List<WnBook> list = cate.getList();
        for (WnBook book : list){
            System.out.println(book);
        }
    }


}
