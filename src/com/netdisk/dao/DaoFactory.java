package com.netdisk.dao;

/**
 * @Classname DaoFactory
 * @Description TODO
 * @Date 2020-3-23 14:49
 * @Created by lishaoteng
 */
public class DaoFactory {
    public static IUserDao getUserDao(){
        return new UserDao();
    }
}
