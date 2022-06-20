package wnbook.service;

import com.github.pagehelper.Page;
import wnbook.entity.WnBookUser;

import java.sql.SQLException;

public interface WnBookUserService {
    //查
    WnBookUser findWnBookUserById(int id);
    Page<WnBookUser> findAllUser(int offset, int limit);
    WnBookUser findUserByName(String userName);
    //增
    int addUser( WnBookUser user);
    //改
    int modifyUser(WnBookUser user);
    int modifyCenter(WnBookUser user);
    //删
    int removeWnBookUserById(int id);

    int modifyWnBookUserImg(WnBookUser user);





}
