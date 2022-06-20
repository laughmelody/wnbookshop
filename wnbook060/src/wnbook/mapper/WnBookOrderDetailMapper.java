package wnbook.mapper;

import wnbook.entity.WnBookOrderDetail;

import java.util.List;

public interface WnBookOrderDetailMapper {
    int insertOrderDetail(List<WnBookOrderDetail> list);
}
