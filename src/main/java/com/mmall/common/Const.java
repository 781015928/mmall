package com.mmall.common;

/**
 * Created by aimld on 2017/9/22.
 */
public class Const {
    public static final String CURRENT_USER = "currect_user";

    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface Role{
        int ROLE_CUSTOMER = 0;//普通用户
        int ROLE_ADMIN = 1;//管理员
    }
}