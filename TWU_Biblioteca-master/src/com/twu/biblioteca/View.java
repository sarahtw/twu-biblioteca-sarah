package com.twu.biblioteca;

import com.twu.database.Database;
import com.twu.models.Book;

import java.util.ArrayList;

public class View {

    private Database database = new Database();

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String showBooklist() {
        ArrayList<Book> bookList = database.bookList;

        String message = "";

        for (Book book: bookList) {
            message += book.getName() + "\n";
        }

        return message;
    }

    public String showBooklistWithDetails() {
        ArrayList<Book> bookList = database.bookList;

        String message = "";

        for (Book book: bookList) {
            message += book.getName() + " - ";
            message += book.getAuthor() + " - ";
            message += book.getYear() + "\n";
        }

        return message;
    }

}
