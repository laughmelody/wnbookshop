package wnbook.service;

import wnbook.entity.WnBookUser;

import java.sql.SQLException;

public interface wnLoginService {

    int findUserBylogin(WnBookUser user) throws SQLException;
}
