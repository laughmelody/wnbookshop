package wnbook.mapper;

import wnbook.entity.OrderQueryVo;
import wnbook.entity.WnBookOrder;
import wnbook.entity.WnBookUser;

public interface WnBookOrderMapper {
    int insertBookOrder(WnBookOrder order);

    //未支付订单
    WnBookOrder selectOrderByUserId(int id);
    int selectStatusByUid(int uid);

    OrderQueryVo selectOrderById(int id);
}
