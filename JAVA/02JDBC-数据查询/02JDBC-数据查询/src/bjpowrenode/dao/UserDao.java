package bjpowrenode.dao;

import bjpowrenode.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: 动力节点
 * 2019/3/29
 */
public class UserDao {

    /**
     * 查询数据库 返回一条记录
     * @return
     */

    public User selectUserById(Long id){
        User user=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;//结果集合对象，用于封装数据库的查询结果的
        String sql="";
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowrnode", "root","123456");
            sql="select * from t_user where id=?";
            ps=conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs=ps.executeQuery();//执行数据库的查询语句，并返回查询结果
            while(rs.next()){//让光标向下移动一次并判断下一个元素是否有值，如果有值则返回真进入循环
                user=new User();
                user.setId(rs.getLong("id"));//将结果集中当前元素的显示列名为id的数据获取出来并设置到user的id属性上
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return user;
    }



    public List<User> selectUserAll(){
        List<User> list=new ArrayList<User>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;//结果集合对象，用于封装数据库的查询结果的
        String sql="";
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowrnode", "root","123456");
            sql="select * from t_user";
            ps=conn.prepareStatement(sql);

            rs=ps.executeQuery();//执行数据库的查询语句，并返回查询结果
            while(rs.next()){//让光标向下移动一次并判断下一个元素是否有值，如果有值则返回真进入循环
                User user=new User();
                user.setId(rs.getLong("id"));//将结果集中当前元素的显示列名为id的数据获取出来并设置到user的id属性上
                user.setName(rs.getString("name"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

        return list;
    }
}
