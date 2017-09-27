package com.example.webapigateway.users;

/**
 * Created by Mateusz on 2017-08-25.
 */
public class User {
    long id;
    String userName;
    String password;


    public User() {
    }

    public User(long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
