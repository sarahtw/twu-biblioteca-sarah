package com.twu.biblioteca;

//import com.twu.database.Database;
import com.twu.models.Book;
import com.twu.services.BookManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private final ArrayList<Book> availableBooks;

    public View() {
        this.availableBooks = new BookManagement().availableBooks;
    }

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void openMenu(){
        this.showMenuOptions();
        var quitApplication = false;

        while (!quitApplication) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();

            quitApplication = this.chooseMenuOption(input);
        }
    }

    public void showMenuOptions() {
        System.out.println("""
            -----MENU-----
            Choose an option

            1 - List of books
            0 - Quit the application""");
    }

    public String showBooklist() {

        StringBuilder message = new StringBuilder();

        for (Book book: availableBooks) {
            message.append(book.getName()).append("\n");
        }

        return message.toString();
    }

    public String showBooklistWithDetails() {

        StringBuilder message = new StringBuilder();

        for (Book book: availableBooks) {
            message.append(book.getBookDetails());
        }

        return message.toString();
    }

    public boolean chooseMenuOption(String selected_menu_option) {
        switch (selected_menu_option) {
            case "0" -> {
                System.out.println(this.showQuitTheApplicationMessage());
                return true;
            }
            case "1" -> {
                System.out.println(this.showBooklistWithDetails());
                this.showBooklist();
                this.showMenuOptions();
                return false;
            }
            default -> {
                System.out.println("Please select a valid option!");
                return false;
            }
        }
    }

    private String showQuitTheApplicationMessage() {
        return "See ya!";
    }


}
