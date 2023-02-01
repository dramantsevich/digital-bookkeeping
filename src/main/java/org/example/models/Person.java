package org.example.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Full name should be between 2 and 100 characters")
    @Pattern(regexp = "[А-Я]\\p{L}+ [А-Я]\\p{L}+ [А-Я]\\p{L}+", message = "Your address should be in this format: Иванов Иван Иванович")
    private String fullname;
    @Min(value = 1900, message = "Birthday should be grater than 1900")
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