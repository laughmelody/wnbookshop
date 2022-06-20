package wnbook.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;
import wnbook.entity.WnBookAdmin;
import wnbook.mapper.WnBookAdminMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatisMapper {
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
}
