package practice2.repository.impl;

import org.springframework.stereotype.Repository;
import practice2.model.Login;
import practice2.model.User;
import practice2.repository.IRepoUser;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository implements IRepoUser {
    private static List<User> users = new ArrayList<>();

    static {
        User user1 = new User();
        user1.setAccount("tobi123");
        user1.setAge(10);
        user1.setName("John");
        user1.setEmail("thesonpham120499@gmail.com");
        user1.setPassword("123456");
        users.add(user1);

        User user2 = new User();
        user2.setAccount("bi123");
        user2.setAge(18);
        user2.setName("Hải ngu");
        user2.setEmail("thesonpham120499@gmail.com");
        user2.setPassword("123456");
        users.add(user2);
    }

    @Override
    public User checkLogin(Login login) {
        for (User user : users) {
            if (user.getAccount().equals(login.getAccount()) && user.getPassword().equals(login.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
