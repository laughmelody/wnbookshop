package wnbook.service.imp;

import wnbook.dao.imp.WnBookAdminDaoImp;
import wnbook.entity.WnBookAdmin;
import wnbook.service.WnBookAdminService;
import wnbook.util.DbHelper;
import wnbook.util.Page;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class WnBookAdminServiceImp implements WnBookAdminService {
    private WnBookAdminDaoImp wnBookAdminDaoImp;
    public WnBookAdminServiceImp(){
        wnBookAdminDaoImp = new WnBookAdminDaoImp();
    }

    @Override
    public String findPasswordByName(String adminName) {

        return null;
    }

    @Override
    public WnBookAdmin findAdminByName(String adminName) {
        Connection conn = DbHelper.getConnection();
        ResultSet set = null;
        try {
            set = wnBookAdminDaoImp.selectAdminByName(conn,adminName);
            if (set.next()){
                int id = set.getInt("id");
                String username = set.getString("username");
                String password = set.getString("password");
                String tel = set.getString("tel");
                return new WnBookAdmin(id,username,password,tel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            wnBookAdminDaoImp.closeAll();
        }

        return null;
    }

    @Override
    public int addAdmin(WnBookAdmin admin) {
        return 0;
    }

    @Override
    public int[] insertMore(List<WnBookAdmin> list) {
        return new int[0];
    }

    @Override
    public List<WnBookAdmin> findAllAdmins() {
        return null;
    }

    @Override
    public Page<WnBookAdmin> findAdminsByPage(Page<WnBookAdmin> page) {
        return null;
    }

    @Override
    public WnBookAdmin findAdminById(int id) {
        return null;
    }
}
