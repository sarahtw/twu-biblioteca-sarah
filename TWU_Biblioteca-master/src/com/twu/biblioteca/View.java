package com.twu.biblioteca;

import com.twu.models.Book;
import com.twu.services.BookManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private final ArrayList<Book> books;
    public BookManagement bookManagement = new BookManagement();

    public View() {
        this.books = bookManagement.books;
    }

    public void openApp() {
        System.out.println(showWelcomeMessage());
        openMenu();
    }

    public String showWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void openMenu(){
        var quitApplication = false;

        while (!quitApplication) {
            this.showMenuOptions();

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

    public String showBookListWithDetails() {

        StringBuilder message = new StringBuilder();
        message.append("""
                -----BOOKLIST-----
                """);

        for (Book book: books) {
            if (book.isAvailable()) {
                message.append(book.getBookDetails());
            }
        }

        return message.toString();
    }

    public boolean chooseMenuOption(String selectedMenuOption) {
        switch (selectedMenuOption) {
            case "0" -> {
                System.out.println(this.showQuitTheApplicationMessage());
                return true;
            }
            case "1" -> {
                System.out.println(this.showBookListWithDetails());
                this.showBookListWithDetails();
                return false;
            }
            case "2" -> {
                System.out.println("What's the name of the book you want to checkout?");
                Scanner sc = new Scanner(System.in);
                String inputBookName = sc.nextLine();
                this.chooseBook(inputBookName);
                return false;
            }
            case "3" -> {
                System.out.println("What's the name of the book you want to return?");
                Scanner sc = new Scanner(System.in);
                String input_book_name = sc.nextLine();
                this.returnBook(input_book_name);
                return false;
            }
            default -> {
                System.out.println("Please select a valid option!");
                return false;
            }
        }
    }

    public void chooseBook(String bookName) {
        if (bookManagement.isBookAvailableToCheckout(bookName)) {
            bookManagement.changeBookStatusToRented(bookName);
            System.out.println("Thank you! Enjoy the book.");
        } else {
            System.out.println("Sorry, that book is not available.");
        }
    }

    private String showQuitTheApplicationMessage() {
        return "See ya!";
    }

    public void returnBook(String bookName) {
        if (bookManagement.isBookAvailableToReturn(bookName)) {
            bookManagement.changeBookStatusToAvailable(bookName);
            System.out.println("Thank you for returning the book");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

}
