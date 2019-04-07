package org.launchcode.models;

/**
 * Created by Hackman
 */
public class User {

    private String username;
    private String email;
    private String password;

    private int userId;
    private static int nextId = 1;

    private String verifyPassword;

    public User(String username, String email, String password, int userId, String verifyPassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.userId = userId;
        this.verifyPassword = verifyPassword;
    }

    public User() {
        userId = nextId;
        nextId++;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        User.nextId = nextId;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
