package pl.coderslab.dao;

import pl.coderslab.entity.User;

public class MainDao {
    public static void main(String[] args) {

        // test metody creat
        UserDao userDao = new UserDao();

        User user1 = new User();
        user1.setUserName("Anna");
        user1.setEmail("anka@onet.pl");
        user1.setPassword("ankaK123");

        User user2 = new User();
        user2.setUserName("Karol");
        user2.setEmail("koral@wp.pl");
        user2.setPassword("7842ako");

        User user3 = new User();
        user3.setUserName("Marcin");
        user3.setEmail("marcin@gmail.com");
        user3.setPassword("goral456J");

        userDao.create(user1);
        userDao.create(user2);
        userDao.create(user3);
    }
}
