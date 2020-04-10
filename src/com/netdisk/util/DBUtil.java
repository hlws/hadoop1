package com.netdisk.util;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * @Classname DBUtil
 * @Description TODO
 * @Date 2020-3-23 15:02
 * @Created by lishaoteng
 */
public class DBUtil {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String username="root";
    private static String password="root";
    private static String url="jdbc:mysql://localhost:3306/itat_test?serverTimezone=GMT%2B8";
    private static Connection con=null;
    public static Connection getCon(){
        try {
            Class.forName(driver);
            try {
                con= DriverManager.getConnection(url,username,password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;

    }
    public static void close(Connection con){
        try {
            if (con!=null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(PreparedStatement ps){
        try {
            if (ps!=null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void close(ResultSet rs){
        try {
            if (rs!=null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
