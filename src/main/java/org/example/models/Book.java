package org.example.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Title should be between 2 and 100 characters")
    private String title;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 100, message = "Author name should be between 2 and 100 characters")
    @Pattern(regexp = "[А-Я]\\p{L}+ [А-Я]\\p{L}+", message = "Author should be in this format: Иванов Иван")
    private String author;
    @Min(value = 1900, message = "Year should be grater than 1900")
    private int year;

    public Book() {}

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
