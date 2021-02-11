package com.twu.models;

public class Book {
    public String name;
    public String author;
    public Integer year;

    public Book(String name, String author, Integer year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAuthor(String author) {
        this.name = name;
    }

    public String getAuthor() {
        return this.name;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getYear() {
        return this.year;
    }
}
