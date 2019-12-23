package com.bjpowrenode.dao;

import com.bjpowrenode.model.User;

import java.sql.*;


/**
 * Author: 动力节点
 * 2019/3/28
 */
public class UserDao {
    /**
     * 完成用户添加的数据库持久化方法
     * @param user 需要被添加到数据中的用户对象
     */

    public void insertUser(User user){
        //1.加载驱动，通知JDBC我们即将连接什么数据库
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        Connection conn=null;
        PreparedStatement ps=null;
        try {
            //2.获取连接对象，连接到数据库
            /**
             * 参数1 数据库的的连接路径
             *  jdbc:mysq:// 协议名称
             *  localhost为需要连接的数据库的所在ip地址localhost表示本机
             *  3306 为数据库的端口号
             *  bjpowernode 是所需要连接的具体的数据库的库名
             * 参数2 连接数据库时的用户名
             * 参数3 连接数据库时用户名所对应的密码
             */
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowrnode", "root", "123456");
            String sql="insert into t_user(username,password,name)values(?,?,?)";//定义SQL语句 ?是占位符需要后期动态为?赋值
            //3.定义SQL容器 ，并装在我们的SQL语句
            ps=conn.prepareStatement(sql);
            //4.为语句中的?赋值 可选操作步骤 如果语句中没有?则不需要赋值
            /**
             * set数据类型() 我们要根据数据库中的字段的具体类型调用对应的方法，varchar 对应setString 、 int 对应 setInt、 bigint 对应setLong
             * 参数1 为?的需要 1表示要为第一个?赋值
             * 参数2 这个?的具体数据内容数据来自当前方法的参数
             * 注意：有几个?就需要有几行赋值并且序号要与?一一对应
             */
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            //5.执行SQL语句
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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


    public void updateUser(User user){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowrnode", "root", "123456");
            String sql="update t_user set username=? , name=? ,password =? where id=?";//定义SQL语句 ?是占位符需要后期动态为?赋值
            ps=conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(2, user.getName());
            ps.setLong(4, user.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

    public void deleteUseById(Long id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowrnode", "root", "123456");
            String sql="delete from t_user where id=?";//定义SQL语句 ?是占位符需要后期动态为?赋值
            ps=conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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
}
