package com.example.excelupload.service;


import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    // Simulated database to store user credentials
    private final Map<String, String> users = new HashMap<>();

    public UserService() {
        // Sample users (you should replace this with actual database integration)
        users.put("user1", "password1");
        users.put("user2", "password2");
    }

    public boolean validateUser(String username, String password) {
        // Check if the username exists in the database
        if (users.containsKey(username)) {
            // Check if the password matches the stored password for the given username
            return users.get(username).equals(password);
        }
        // Return false if the username doesn't exist
        return false;
    }
    
    
    public boolean authenticateUser(String username, String password) {
        // Logic to authenticate user
        // Example: Check against database or other authentication mechanism
        return username.equals("admin") && password.equals("password");
    }
}

