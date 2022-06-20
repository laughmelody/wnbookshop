package wnbook.service;

import wnbook.entity.CartQueryVo;
import wnbook.entity.WnBookCart;

import java.util.List;

public interface WnBookCartService {
    //新增到购物车
    int addBookCart(WnBookCart cart);

    //查询当前用户的购物车
    List<CartQueryVo> findCartQueryVoByUid(int uid);
}
