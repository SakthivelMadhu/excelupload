package com.example.excelupload.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testValidateUser() {
        String validUsername = "user1";
        String validPassword = "password1";
        assertTrue(userService.validateUser(validUsername, validPassword), "Valid username and password should return true");

        String invalidUsername = "invalidUser";
        String invalidPassword = "invalidPassword";
        assertFalse(userService.validateUser(invalidUsername, invalidPassword), "Invalid username and password should return false");
    }
}

