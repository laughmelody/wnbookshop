package wnbook.service.imp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.PropertyConfigurator;
import wnbook.entity.*;
import wnbook.mapper.WnBookCartMapper;
import wnbook.mapper.WnBookOrderDetailMapper;
import wnbook.mapper.WnBookOrderMapper;
import wnbook.service.WnBookOrderService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WnBookOrderServiceImp implements WnBookOrderService {
    private SqlSession sqlSession;
    private WnBookOrderMapper mapper;
    private WnBookOrderDetailMapper wnBookOrderDetailMapper;
    private WnBookCartMapper wnBookCartMapper;
    public WnBookOrderServiceImp(){
        PropertyConfigurator.configure("src/log4j.properties");
        String resource = "mybatis.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
            sqlSession = sqlSessionFactory.openSession();
            mapper = sqlSession.getMapper(WnBookOrderMapper.class);
            wnBookOrderDetailMapper = sqlSession.getMapper(WnBookOrderDetailMapper.class);
            wnBookCartMapper = sqlSession.getMapper(WnBookCartMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public int addOrder(WnBookOrder order, List<CartQueryVo> list) {
        ArrayList<WnBookOrderDetail> orderDetailList = new ArrayList<>();
        //先把订单新增进数据库，成功后，再增加订单详情
        int i = mapper.insertBookOrder(order);
        if (i>0){
          //  List<CartQueryVo> list = wnBookCartMapper.selectCartByIds(ids);
            for (CartQueryVo car :list){
                orderDetailList.add(new WnBookOrderDetail(car.getBookId(),car.getBookPrice(),order.getId(),
                        car.getBuyCount(), car.getBookPrice()* car.getBuyCount(),new Date(),new Date(),0));
            }
            int ii = wnBookOrderDetailMapper.insertOrderDetail(orderDetailList);
            System.out.println("订单详情写入到数据库:"+ii);
            sqlSession.commit();
            return ii;
        }else {
            sqlSession.rollback();
        }
        return 0;
    }

    @Override
    public OrderQueryVo findOrderById(int id) {
        return mapper.selectOrderById(id);
    }

    @Override
    public List<WnBookOrder> findOrderByUserId(int id) {
        return mapper.selectOrderByUserId(id);
    }

    @Override
    public int modifyOrderStatus(WnBookOrder order) {
        int i  = mapper.updateOrderStatus(order);
        if (i>0){
            sqlSession.commit();
        }
        return i;
    }
}
