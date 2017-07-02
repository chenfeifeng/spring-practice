package com.cff.spring.entity;

/**
 * @author cff
 * @version 1.0
 * @description @TODO
 * @date 2017/7/2 下午8:58
 */
public class User {
    private String name;

    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }


    public User() {

    }
}
