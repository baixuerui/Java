package com.bjpowernode.util;

import java.sql.*;

/**
 * Author: 动力节点
 * 2019/3/29
 */
public class DBUtil {
private static final String URL="jdbc:mysql://localhost:3306/bjpowrnode";
private static final String USERNAME="root";
private static final String PASSWORD="123456";
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
         Connection conn=null;

        try {
            conn= DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //设置MySQL数据库的事务为手动提交
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(PreparedStatement ps,Connection conn){
            close(null, ps, conn);
    }
    public static void close(ResultSet rs,PreparedStatement ps, Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
