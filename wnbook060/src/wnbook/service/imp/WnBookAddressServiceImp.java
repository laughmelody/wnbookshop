package wnbook.service.imp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import wnbook.entity.WnBookAddress;
import wnbook.mapper.WnBookAddressMapper;
import wnbook.mapper.WnBookMapper;
import wnbook.service.WnBookAddressService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class WnBookAddressServiceImp implements WnBookAddressService {
    private SqlSession sqlSession;
    private WnBookAddressMapper mapper;
    public WnBookAddressServiceImp(){
        PropertyConfigurator.configure("src/log4j.properties");
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(WnBookAddressMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<WnBookAddress> findAddressByUserId(int id) {
        return mapper.selectAddressByUserId(id);
    }

    @Override
    public int addAddress(WnBookAddress address) {
        int i = mapper.insertAdd(address);
        if (i>0){
            sqlSession.commit();
        }
        return i;
    }

    @Override
    public int findDefaultByUid(int uid) {
        return mapper.selectDefaultByUid(uid);
    }

    @Override
    public int modifyAddById(WnBookAddress address) {
        int i =  mapper.updateAddById(address);
        if (i>0){
            sqlSession.commit();
        }
        return i;
    }

    @Override
    public int removeAddById(int id) {
       int i =  mapper.deleteAddById(id);
       if (i>0){
           sqlSession.commit();
       }
       return i;
    }
}
