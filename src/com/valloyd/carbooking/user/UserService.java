package com.valloyd.carbooking.user;

import java.util.UUID;

public final class UserService {

    UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public User[] getUsers() {
        var userAmount = 0;

        for (int i = 0; i < userDAO.getUsers().length; i++) {
            if (!(userDAO.getUsers()[i] == null)) {
                userAmount++;
            }
        }

        if (userAmount > 0) {
            User[] users = new User[userAmount];
            var index = 0;

            for (int i = 0; i < userDAO.getUsers().length; i++) {
                if (!(userDAO.getUsers()[i] == null)) {
                    users[index++] = userDAO.getUsers()[i];
                }
            }
            return users;
        } else {
            System.out.println("🚫 No users...");
            return null;
        }
    }

    public User getUserByID(UUID userID) {
        if (!(getUsers() == null)) {
            for (var i = 0; i < getUsers().length; i++) {
                if (getUsers()[i].getId().equals(userID)) {
                    return getUsers()[i];
                }
            }
        }
        System.out.println("🚫 No user by given ID...");
        return null;
    }
}
