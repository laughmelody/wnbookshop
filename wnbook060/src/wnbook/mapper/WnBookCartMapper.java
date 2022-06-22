package wnbook.mapper;

import wnbook.entity.CartQueryVo;
import wnbook.entity.WnBookCart;

import java.util.List;

public interface WnBookCartMapper {
    //新增到购物车
    int insertBookCart(WnBookCart cart);
    //已经有数据，所以增加购物车中数量
    int updateCartById(WnBookCart cart);
    //添加进购物车之前的验证，验证相同数据是否存在
    String selectCartByUidAndBookId(WnBookCart cart);
    //查找当前用户下的购物车数据
    List<CartQueryVo> selectCartQueryVoByUid(int uid);

    int updateCartBuyCount(WnBookCart cart);
    //根据ids查找购物车对象
    List<CartQueryVo> selectCartByIds(String[] ids);

    //购物车角标
    int selectCartCount(int id);


    //删除购物车
    int deleteCart(int id);
}
