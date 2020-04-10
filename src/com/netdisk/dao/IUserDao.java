package com.netdisk.dao;

import com.netdisk.model.User;

import java.util.List;

/**
 * @Classname IUserDao
 * @Description TODO
 * @Date 2020-3-23 14:31
 * @Created by lishaoteng
 */
public interface IUserDao {
    public void add(User user);
    public void delete(int id);
    public void update(User user);
    public User load(int id);
    public List<User> list();
    public User login(String username,String password);
}
