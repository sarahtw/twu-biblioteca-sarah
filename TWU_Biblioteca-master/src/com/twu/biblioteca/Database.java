package com.twu.biblioteca;

import java.util.ArrayList;

public class Database {
    public ArrayList<String> bookList;

    public Database() {
        this.bookList = new ArrayList<String>();
        this.bookList.add("Livro 1");
        this.bookList.add("Livro 2");
        this.bookList.add("Livro 3");
    }
}
