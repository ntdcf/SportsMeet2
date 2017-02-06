package com.luohao.sportsmeet.Service;

/**
 * Created by luogkme on 2017/1/19.
 */

public class UserService {

    public String regNewUser(String usernumber, String password, int type) {
        return "";
    }

    public boolean enterPassword(String password1, String password2) {
        if (password1.equals(password2)) {
            return true;
        }
        return false;
    }
}
