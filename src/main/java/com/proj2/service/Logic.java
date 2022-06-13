package com.proj2.service;

import com.proj2.model.Organization;
import com.proj2.model.person.Admin;
import com.proj2.model.person.User;

import java.util.ArrayList;
import java.util.Comparator;

public class Logic {
    private static final Organization _organization = new Organization();

    public static ArrayList<User> sortUsersByPoints(ArrayList<User> users, boolean ascending) {
        if (ascending) users.sort(new AscendingComparator());
        else users.sort(new DescendingComparator());
        return users;
    }

    public static Organization get_organization() { return _organization; }

    public static void seedOrganisation() {
        try {
            _organization.addUser(new Admin("Luca Don", "20096550@student.hhs.nl", PasswordHash.createHash("FooBar231!")));
            _organization.addUser(new Admin("Lance van den Boogaart", "18009395@student.hhs.nl", PasswordHash.createHash("FooBar231!")));
            _organization.addUser(new Admin("Peter Jansen", "123", PasswordHash.createHash("123")));
            User peter = new User("Peter Jansen", "peter", PasswordHash.createHash("123"));
            peter.setPoints(69);
            _organization.addUser(peter);
            _organization.addUser(new User("Daner Elias", "21143900@student.hhs.nl", PasswordHash.createHash("321")));
            _organization.addUser(new User("Dwayne Balentien", "17124298@student.hhs.nl", PasswordHash.createHash("potvis")));
            _organization.addUser(new User("Bilal Massoudi", "20214995@student.hhs.nl", PasswordHash.createHash("123")));
            _organization.addUser(new User("User", "user@foo.bar", PasswordHash.createHash("123")));
        } catch (Exception ignored) {}
    }
}

class AscendingComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user1.getPoints().compareTo(user2.getPoints());
    }
}

class DescendingComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        return user2.getPoints().compareTo(user1.getPoints());
    }
}