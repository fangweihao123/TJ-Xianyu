package com.example.po.tj_xianyu.service.verifyservice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 13701 on 2017/12/28.
 */

public class VerifyService {
    public boolean isPhoneValid(String userName) {
        Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(userName);
        return m.matches() && userName.length() >= 7 && userName.length() <= 12;
    }

    public boolean isEmailValid(String userName) {
        return userName.contains("@");
    }

    public boolean isPasswordValid(String password) {
        return password.length() >= 4 && password.length() <= 20;
    }

}
