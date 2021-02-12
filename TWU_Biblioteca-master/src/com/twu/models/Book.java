package com.twu.models;

public class Book {
    public Integer id;
    public String name;
    public String author;
    public Integer year;
    public Boolean available;

    public Book(Integer id, String name, String author, Integer year, Boolean available) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public Integer getId() {
        return id;
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

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public String getBookDetails() {
        return this.getId() + " - "+ this.getName() + " - " + this.getAuthor() + " - " + this.getYear().toString() + "\n";
    }
}
