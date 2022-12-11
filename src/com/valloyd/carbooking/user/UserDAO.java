package com.valloyd.carbooking.user;

import java.util.UUID;

final class UserDAO {

    static User[] users;
    private static int capacity = 100;

    static {
        users = new User[capacity];
        users[0] = new User(UUID.randomUUID(), "Sir");
        users[1] = new User(UUID.randomUUID(), "Pom");
        users[2] = new User(UUID.randomUUID(), "Wam");
        users[3] = new User(UUID.randomUUID(), "Tam");
    }

    /*public void setUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (!(users[i] == null)) {
                continue;
            }
            users[i] = user;
        }
    }*/

    public User[] getUsers() {
        return users;
    }
}
