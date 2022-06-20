package wnbook.service.imp;

import wnbook.dao.imp.WnBookUserDaoImp;
import wnbook.entity.WnBookUser;
import wnbook.service.wnLoginService;
import wnbook.util.DbHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class wnLoginServiceImp implements wnLoginService {
    private static WnBookUserDaoImp wnBookUserDaoImp;

    public wnLoginServiceImp() {
        wnBookUserDaoImp = new WnBookUserDaoImp();
    }
    @Override
    public static int findUserBylogin(WnBookUser user) throws SQLException {

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

