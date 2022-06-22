package wnbook.service.imp;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import wnbook.entity.WnBookUser;
import wnbook.mapper.WnBookUserMapper;
import wnbook.service.WnBookUserService;



import java.io.IOException;
import java.io.InputStream;


public class WnBookUserServiceImp implements WnBookUserService {
    private  SqlSession sqlSession;
    private  WnBookUserMapper mapper;
    public WnBookUserServiceImp(){
//        PropertyConfigurator.configure("src/log4j.properties");
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(WnBookUserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public WnBookUser findWnBookUserById(int id) {
        return mapper.selectUserById(id);
    }

    @Override
    public Page<WnBookUser> findAllUser(int offset, int limit) {
        Page<WnBookUser> page = PageHelper.offsetPage(offset,limit);
        mapper.selectAllUser();
        return page;
    }

    @Override
    public WnBookUser findUserByName(String userName) {
        return mapper.selectUserByName(userName);
    }

    @Override
    public int addUser(WnBookUser user) {
        int i = mapper.registUser(user);

        sqlSession.commit();

        return i;
    }

    @Override
    public int modifyUser(WnBookUser user) {
        int  i = mapper.updateUser(user);
        if (i>0){
            sqlSession.commit();
        }
        return i;
    }

    @Override
    public int modifyCenter(WnBookUser user) {
        int i = mapper.updateCenter(user);
        if (i>0){
            sqlSession.commit();
        }
        return i;
    }

    @Override
    public int modifyWnBookUserImg(WnBookUser user) {
        int i = mapper.updateUserImg(user);
        if (i>0){
            sqlSession.commit();
        }
        return i;
    }



    @Override
    public int removeWnBookUserById(int id) {
        int i = mapper.deleteUserById(id);
        if (i>0){
            sqlSession.commit();
        }
        return i;
    }
}
