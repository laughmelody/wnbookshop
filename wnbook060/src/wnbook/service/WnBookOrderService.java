package wnbook.service;

import wnbook.entity.CartQueryVo;
import wnbook.entity.OrderQueryVo;
import wnbook.entity.WnBookOrder;

import java.util.List;

public interface WnBookOrderService {
    int addOrder(WnBookOrder order, List<CartQueryVo> list);

    OrderQueryVo findOrderById(int id);
    //未支付订单
    List<WnBookOrder> findOrderByUserId(int id);

    //支付完成后修改订单状态
    int modifyOrderStatus(WnBookOrder order);
}
