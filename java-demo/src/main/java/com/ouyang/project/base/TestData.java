package com.ouyang.project.base;

import java.util.Date;

/**
 * Created by ouyang on 2017/5/17.
 */
public class TestData {
    private String id;
    private String name;
    private int age;
    private Date birthday;
    private String parentId;
    private Integer tempInt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getTempInt() {
        return tempInt;
    }

    public void setTempInt(Integer tempInt) {
        this.tempInt = tempInt;
    }
}
