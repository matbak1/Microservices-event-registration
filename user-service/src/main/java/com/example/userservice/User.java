package com.example.userservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Mateusz on 2017-08-25.
 */
@Entity
public class User {

    @Id
    @GeneratedValue
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

    public User(String userName, String password, long userId) {
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
