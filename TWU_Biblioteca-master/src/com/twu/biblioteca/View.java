package com.twu.biblioteca;

import com.twu.database.Database;
import com.twu.models.Book;

import java.util.ArrayList;

public class View {
    private final ArrayList<Book> books;
    
    public View() {
        this.books = new Database().bookList;
        
    }

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String showBooklist() {

        StringBuilder message = new StringBuilder();

        for (Book book: books) {
            message.append(book.getName()).append("\n");
        }

        return message.toString();
    }

    public String showBooklistWithDetails() {

        StringBuilder message = new StringBuilder();

        for (Book book: books) {
            message.append(book.getBookDetails());
        }

        return message.toString();
    }

    public String showMenuOptions() {
        return "-----MENU-----\n" +
                "Choose an option\n\n" +
                "1 - List of books";
    }

    public String chooseMenuOption(String selected_menu_option) {
        if (selected_menu_option.equals("1")) {
            return this.showBooklistWithDetails();
        } else {
            return "Please select a valid option!";
        }
    }
}
