package pl.coderslab.dao;

import pl.coderslab.entity.User;

public class MainDao {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        // test metody creat
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


        // test metody read
        User userFromData = userDao.read(2);
        if (userFromData == null){
            System.out.println("User not exist");
        }
        System.out.println(userFromData);


        // test metody update
        User userToUpdate = userDao.read(2);
        userToUpdate.setUserName("Marek");
        userToUpdate.setEmail("marek@wp.pl");
        userToUpdate.setPassword("marek526");
        userDao.update(userToUpdate);


        // test metody findAll
        User[] allUsers = userDao.findAll();
        for (User user : allUsers) {
            System.out.println(user.toString());
        }

        // test metody delete
        userDao.delete(1);

    }
}
