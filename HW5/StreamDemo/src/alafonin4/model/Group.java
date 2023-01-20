package alafonin4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Group {
    private final List<User> Users;
    private final Random random;
    public Group(int numberOfUsers, Random random) {
        this.random = random;
        Users = generateList(numberOfUsers);
    }

    private List<User> generateList(int numberOfUsers) {
        List<User> users = new ArrayList<User>(numberOfUsers);
        for (int i = 0; i < numberOfUsers; i++) {
            users.add(User.generateRandomUser(random, numberOfUsers));
        }
        return users;
    }

    public List<User> getUsers() {
        return Users;
    }
}
