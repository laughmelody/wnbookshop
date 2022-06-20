package wnbook.mapper;

import wnbook.entity.WnBookAdmin;

import java.util.List;

public interface WnBookAdminMapper {
    List<WnBookAdmin> selectAllAdmin();
    List<WnBookAdmin> selectAdminByKeyWord(String userName);
    WnBookAdmin selectAdminById(int id);
    int insertAdmin(WnBookAdmin admin);
    int updateAdmin(WnBookAdmin admin);
    int deleteAdminById(int id);
    int insemore(WnBookAdmin admin);
    int updateMore(List<WnBookAdmin> list);
}
