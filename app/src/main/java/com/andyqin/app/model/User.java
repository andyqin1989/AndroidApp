package com.andyqin.app.model;

import java.util.List;

/**
 * Created by qinbaoyuan on 2017/8/29.
 */

public class User {
    public String name;
    public String address;
    public int age;
    public String mobile;

    public static class AllUser{
        public List<User> allUser;
    }
}
