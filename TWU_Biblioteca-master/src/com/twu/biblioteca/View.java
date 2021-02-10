package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class View {

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public List<String> showBooklist() {
        List<String> bookList = new ArrayList<String>();
        bookList.add("Livro 1");
        bookList.add("Livro 2");
        bookList.add("Livro 3");

        return bookList;
    }

}
