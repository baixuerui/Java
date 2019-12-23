package bjpowrenode;

import bjpowrenode.dao.UserDao;
import bjpowrenode.model.User;

import java.util.List;

/**
 * Author: 动力节点
 * 2019/3/28
 */
public class RunMain {
    public static void main(String[] args) {
        UserDao userDao=new UserDao();
//        User user=userDao.selectUserById(2L);
//        System.out.println(user);

        List<User> list= userDao.selectUserAll();

        for(User user :list){
            System.out.println(user);
        }
    }
}
