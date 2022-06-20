package wnbook.service;

import wnbook.entity.OrderQueryVo;
import wnbook.entity.WnBookOrder;
import wnbook.entity.WnBookOrderDetail;

import java.util.List;

public interface WnBookOrderService {
    int addOrder(WnBookOrder order, String[] ids);

    OrderQueryVo findOrderById(int id);

    WnBookOrder findOrderByUserId(int id);
}
