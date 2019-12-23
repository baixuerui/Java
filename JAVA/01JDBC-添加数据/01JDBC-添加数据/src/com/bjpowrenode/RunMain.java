package com.bjpowrenode;

import com.bjpowrenode.dao.UserDao;
import com.bjpowrenode.model.User;

/**
 * Author: 动力节点
 * 2019/3/28
 */
public class RunMain {
    public static void main(String[] args) {
        UserDao userDao=new UserDao();
        User user=new User();
        user.setName("李四");
        user.setPassword("654321");
        user.setUsername("lisi");
        user.setId(1L);
        userDao.deleteUseById(2L);
//        userDao.updateUser(user);
//        userDao.insertUser(user);
    }
}
