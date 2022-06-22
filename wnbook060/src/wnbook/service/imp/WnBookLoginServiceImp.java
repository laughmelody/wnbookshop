package wnbook.service.imp;

import wnbook.dao.imp.WnBookUserDaoImp;
import wnbook.entity.WnBookUser;
import wnbook.service.WnBookLoginService;
import wnbook.util.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WnBookLoginServiceImp implements WnBookLoginService {
    private WnBookUserDaoImp wnBookUserDaoImp;

    public WnBookLoginServiceImp() {
        wnBookUserDaoImp = new WnBookUserDaoImp();
    }
    @Override
    public int findUserBylogin(WnBookUser user) {
        Connection conn = DbHelper.getConnection();
        int r = 0;
        try {
            ResultSet set = wnBookUserDaoImp.selectPasswordByName(conn, user.getUsername());
            if (set.next()) {
                String password = set.getString("password");
                if (password.equals(user.getPassword())) {
                    r = 1;
                } else {
                    r = 0;
                }
            } else {
                r = -1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            wnBookUserDaoImp.closeAll();
        }
        return r;
    }
}
