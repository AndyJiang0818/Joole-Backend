package com.bezkoder.springjwt;

import java.sql.Timestamp;

import com.bezkoder.springjwt.entity.*;
import com.bezkoder.springjwt.services.impl.UserServiceImp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImpTest {

    @Autowired
    private UserServiceImp userService;

    @Test
    void createUser() {

        boolean actual = userService.createUser("username", "password", "email");
        Assert.assertTrue(actual);
    }

    @Test
    void delete() {

        boolean expected = true;

        boolean actual = userService.delete("password", 1);

        Assert.assertEquals(expected, actual);

    }

    // pass
    @Test
    void findUserById() {

        User res = userService.findUserById(1);
        Assert.assertTrue(res != null);
    }

    @Test
    void userLogin() {

        boolean expected = true;

        boolean actual = userService.userLogin("username", "password");

        Assert.assertEquals(expected, actual);

    }

    @Test
    void userLogout() {

        boolean expected = true;

        boolean actual = userService.userLogout();

        Assert.assertEquals(expected, actual);

    }
}