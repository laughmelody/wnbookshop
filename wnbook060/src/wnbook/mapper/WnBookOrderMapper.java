package wnbook.mapper;

import wnbook.entity.OrderQueryVo;
import wnbook.entity.WnBookOrder;

import java.util.List;

public interface WnBookOrderMapper {
    int insertBookOrder(WnBookOrder order);

    //未支付订单
    List<WnBookOrder> selectOrderByUserId(int id);
    int selectStatusByUid(int uid);

    OrderQueryVo selectOrderById(int id);

    int  updateOrderStatus(WnBookOrder order);
}
