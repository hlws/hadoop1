package com.netdisk.dao;

import com.netdisk.model.DiskException;
import com.netdisk.model.User;
import com.netdisk.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Classname UserDao
 * @Description TODO
 * @Date 2020-3-23 14:50
 * @Created by lishaoteng
 */
public class UserDao implements IUserDao{
    @Override
    public void add(User user) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql=null;
        try {
            con= DBUtil.getCon();
            sql="select count(*) from t_user where username=?";
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            rs=ps.executeQuery();
            while (rs.next()){
                if (rs.getInt(1)>0) throw new DiskException("用户已存在，不能继续添加");
            }
            sql="insert into t_user values (null,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getNickname());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User load(int id) {
        return null;
    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }
}
