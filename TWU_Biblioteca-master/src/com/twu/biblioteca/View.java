package com.twu.biblioteca;

import com.twu.models.Book;
import com.twu.services.BookManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private final ArrayList<Book> availableBooks;
    public BookManagement bookManagement = new BookManagement();

    public View() {
        this.availableBooks = bookManagement.books;
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
            2 - Checkout book
            3 - Return book
            0 - Quit the application""");
    }

    public String showBooklistWithDetails() {

        StringBuilder message = new StringBuilder();
        message.append("""
                -----BOOKLIST-----
                """);

        for (Book book: availableBooks) {
            if (book.isAvailable()) {
                message.append(book.getBookDetails());
            }
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
                this.showBooklistWithDetails();
                this.showMenuOptions();
                return false;
            }
            case "2" -> {
                System.out.println("What's the name of the book you want to checkout?");
                Scanner sc = new Scanner(System.in);
                String input_book_name = sc.nextLine();
                this.chooseBook(input_book_name);
                this.showMenuOptions();
                return false;
            }
            case "3" -> {
                System.out.println("What's the name of the book you want to return?");
                Scanner sc = new Scanner(System.in);
                String input_book_name = sc.nextLine();
                this.returnBook(input_book_name);
                this.showMenuOptions();
                return false;
            }
            default -> {
                System.out.println("Please select a valid option!");
                this.showMenuOptions();
                return false;
            }
        }
    }

    public void chooseBook(String book_name) {
        if (bookManagement.isBookAvailableToCheckout(book_name)) {
            bookManagement.changeBookStatus(book_name, false);
            System.out.println("Thank you! Enjoy the book.");
        } else {
            System.out.println("Sorry, that book is not available.");
        }
    }

    private String showQuitTheApplicationMessage() {
        return "See ya!";
    }

    public void returnBook(String book_name) {
        if (bookManagement.isBookAvailableToReturn(book_name)) {
            System.out.println("Thank you for returning the book");
            bookManagement.changeBookStatus(book_name, true);
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }
}
