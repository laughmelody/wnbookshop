package wnbook.service;

import wnbook.entity.WnBookAddress;
import wnbook.util.Page;

import java.util.List;

public interface WnBookAddressService {

    List<WnBookAddress> findAddressByUserId(int id);

    int addAddress(WnBookAddress address);

    int findDefaultByUid(int uid);

    int modifyAddById(WnBookAddress address);

    int removeAddById(int id);
}
