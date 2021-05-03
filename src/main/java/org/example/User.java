package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private int userid;
    private String email;
    private String password;
    private static final AtomicInteger count = new AtomicInteger(0);

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
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

    public User() {
        userid = 0;
        email = " ";
        password = " ";
    }

    public User (int userid) {
        this.userid = userid;
    }

    public int generateUserID() {
        userid = count.incrementAndGet();
        return userid;
    }
}
