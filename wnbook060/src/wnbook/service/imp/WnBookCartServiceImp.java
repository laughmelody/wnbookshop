package wnbook.service.imp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import wnbook.entity.CartQueryVo;
import wnbook.entity.WnBookCart;
import wnbook.mapper.WnBookCartMapper;
import wnbook.mapper.WnBookMapper;
import wnbook.service.WnBookCartService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class WnBookCartServiceImp implements WnBookCartService {
    private SqlSession sqlSession;
    private WnBookCartMapper mapper;

    public WnBookCartServiceImp(){
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(WnBookCartMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int addBookCart(WnBookCart cart) {
        //新增之前应该判断一下，用户id，书籍id
        String id = mapper.selectCartByUidAndBookId(cart);
        int i = 0;
        if (id==null){
            i = mapper.insertBookCart(cart);
        }else {
            cart.setId(Integer.parseInt(id));
            i = mapper.updateCartById(cart);
        }
        sqlSession.commit();
        return i;
    }

    @Override
    public List<CartQueryVo> findCartQueryVoByUid(int uid) {
        return mapper.selectCartQueryVoByUid(uid);
    }


}
