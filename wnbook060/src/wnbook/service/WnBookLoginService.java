package wnbook.service;

import wnbook.entity.WnBookUser;

public interface WnBookLoginService {
    int findUserBylogin(WnBookUser user);
}
