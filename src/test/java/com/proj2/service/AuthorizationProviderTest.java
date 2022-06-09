package com.proj2.service;

import com.proj2.model.abstraction.AbstractPerson;
import com.proj2.model.person.Admin;
import com.proj2.model.person.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationProviderTest {

    @Test
    @DisplayName("Login test")
    void login() {
        // Login with a non-existing user. Returns null
        Assertions.assertNull(AuthorizationProvider.login("foo@bar.com", "password"));

        // Seeding user to organisation
        AbstractPerson user = new User("Foo Bar", "foo@bar.com", "password");
        Logic.get_organization().addUser(user);

        // Test wrong email. Returns null
        Assertions.assertNull(AuthorizationProvider.login("test@bar.com", "password"));

        // Test email with uppercase letters. Returns user
        Assertions.assertEquals(user, AuthorizationProvider.login("FOO@BAR.COM", "password"));

        // Test wrong password. Returns null
        Assertions.assertNull(AuthorizationProvider.login("foo@bar.com", "Password"));

        // Test right login. Returns user
        Assertions.assertEquals(user, AuthorizationProvider.login("foo@bar.com", "password"));
    }

    @Test
    @DisplayName("Register test")
    void register() {
        // Test with non existing logged in user. Returns False
        Assertions.assertFalse(AuthorizationProvider.register(
                new Admin("Foo Bar", "admin@foo.bar", "password", Logic.get_organization()),
                "Foo Bar", "user@foo.bar", "password"));

        // Seeding fake admin to organisation
        AbstractPerson user = new User("Foo Bar", "fakeadmin@foo.bar", "password");
        Logic.get_organization().addUser(user);

        // Test with not permitted user. Returns False
        Assertions.assertFalse(AuthorizationProvider.register(user, "Foo Bar", "user@foo.bar", "password"));

        // Seeding admin to organisation
        AbstractPerson admin = new Admin("Foo Bar", "admin@foo.bar", "password", Logic.get_organization());
        Logic.get_organization().addUser(admin);

        // Test successfully adding a user. Returns True
        Assertions.assertTrue(AuthorizationProvider.register(admin, "Foo Bar", "user@foo.bar", "password"));

        // Test double user. Returns False
        Assertions.assertFalse(AuthorizationProvider.register(admin, "Foo Bar", "user@foo.bar", "password"));

        // Test double user with uppercase email. Returns False
        Assertions.assertFalse(AuthorizationProvider.register(admin, "Foo Bar", "USER@FOO.BAR", "password"));

        // Test double user but different email. Returns True
        Assertions.assertTrue(AuthorizationProvider.register(admin, "Foo Bar", "user2@foo.bar", "password"));
    }
}