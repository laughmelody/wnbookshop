package wnbook.service;

import wnbook.entity.WnBookAdmin;
import wnbook.util.Page;

import java.util.List;

public interface WnBookAdminService副本 {
    String findPasswordByName(String adminName);
    WnBookAdmin findAdminByName(String adminName);
    int addAdmin( WnBookAdmin admin);
    int[] insertMore( List<WnBookAdmin> list);
    List<WnBookAdmin> findAllAdmins();
    Page<WnBookAdmin> findAdminsByPage(Page<WnBookAdmin> page);

    WnBookAdmin findAdminById(int id);
}
