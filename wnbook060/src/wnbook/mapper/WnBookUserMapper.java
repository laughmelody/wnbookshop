package wnbook.mapper;

import wnbook.entity.WnBookUser;

import java.util.List;

public interface WnBookUserMapper {
    WnBookUser selectUserByName(String username);

    List<WnBookUser> selectAllUser();

    List<WnBookUser> selectUserByKeyWord(String userName);

    WnBookUser selectUserById(int id);

    int insertUser(WnBookUser admin);

    int registUser(WnBookUser user);

    int updateUser(WnBookUser user);

    int updateCenter(WnBookUser user);

    int updateUserImg(WnBookUser user);

    int deleteUserById(int id);

    int insertmore(WnBookUser admin);

    int updateMore(List<WnBookUser> list);

    //登录方法
    WnBookUser selectPasswordByName(WnBookUser user);
}
