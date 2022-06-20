package wnbook.service;

import wnbook.entity.WnBookUser;
import wnbook.util.Page;

import java.util.List;

public interface WnBookUserService副本 {


    String findPasswordByName(String userName);
    WnBookUser findUserByName(String userName);
    int addUser( WnBookUser user);
    int[] insertMore( List<WnBookUser> list);
    List<WnBookUser> findAllUsers();
    Page<WnBookUser> findUsersByPage(Page<WnBookUser> page);

    WnBookUser findUserById(int id);
}
