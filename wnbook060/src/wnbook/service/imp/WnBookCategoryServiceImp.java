package wnbook.service.imp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import wnbook.entity.WnBookCategory;
import wnbook.mapper.WnBookCategoryMapper;
import wnbook.service.WnBookCategoryService;
import com.github.pagehelper.Page;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class WnBookCategoryServiceImp implements WnBookCategoryService {
    private SqlSession sqlSession;
    private WnBookCategoryMapper mapper;
    public WnBookCategoryServiceImp(){
//        PropertyConfigurator.configure("src/log4j.properties");
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
    @Override
    public WnBookCategory findCategoryByName(String name) {
        return null;
    }

    @Override
    public int addCategory(WnBookCategory cate) {
        int i = mapper.insertCategory(cate);
        if (i>0){
            sqlSession.commit();
        }
        return i;
    }

    @Override
    public int modifyCategory(WnBookCategory category) {
        int i = mapper.updateCategory(category);
        if (i>0){
            sqlSession.commit();
        }
        return i;
    }

    @Override
    public int removeWnBookCategoryById(int id) {
        int i = mapper.deleteCategoryById(id);
        if (i>0){
            sqlSession.commit();
        }
        return i;
    }

    @Override
    public Page<WnBookCategory> findAllCategory(int offset, int limit) {

        return mapper.selectAllCategory();
    }

    @Override
    public List<WnBookCategory> selectAll() {
        return mapper.showAll();
    }

    @Override
    public WnBookCategory findCategoryById(int id) {
        return mapper.selectCategoryById(id);
    }
}
