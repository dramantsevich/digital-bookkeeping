package org.example.models;

public class Person {
    private int id;
    private String fullname;
    private int birthday;

    public Person() {}

    public Person(int id, String fullname, int birthday) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }
}