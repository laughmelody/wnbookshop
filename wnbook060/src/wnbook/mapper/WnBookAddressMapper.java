package wnbook.mapper;

import wnbook.entity.WnBookAddress;

import java.util.List;

public interface WnBookAddressMapper {
    List<WnBookAddress> selectAllAddress();
    List<WnBookAddress> selectAddressByUserId(int userid);
    int selectDefaultByUid(int uid);
    int insertAdd(WnBookAddress address);
    int updateAddById(WnBookAddress admin);
    int deleteAddById(int id);

}
