package com.twu.services;

import com.twu.models.Book;

import java.util.ArrayList;

public class BookManagement {

    public static ArrayList<Book> books;

    public BookManagement() {
        books = this.createBookList();
    }

    public ArrayList<Book> createBookList(){
        ArrayList<Book>books = new ArrayList<Book>();

        Book childishBook = new Book(1, "The Little Prince", "Antoine de Saint-Exupéry", 1943, true);
        Book detectiveBook = new Book(2, "The Mysterious Affair at Styles", "Agatha Christie", 1920, true);
        Book musicBook = new Book(3, "Chromatica", "Lady Gaga", 2020, false);

        books.add(childishBook);
        books.add(detectiveBook);
        books.add(musicBook);

        return books;
    }

    public Book getBookByName(String bookName) {
        for (Book book : books) {
            if (book.getName().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public Boolean isBookAvailableToCheckout(String bookName){
        Book book = this.getBookByName(bookName);
        return book != null && book.isAvailable();
    }

    public Boolean isBookAvailableToReturn(String bookName){
        Book book = this.getBookByName(bookName);
        return book != null && !book.isAvailable();
    }

    public void changeBookStatusToRented(String bookName) {
        Book book = this.getBookByName(bookName);
        int index = books.indexOf(book);
        books.get(index).setAvailable(false);
    }

    public void changeBookStatusToAvailable(String bookName) {
        Book book = this.getBookByName(bookName);
        int index = books.indexOf(book);
        books.get(index).setAvailable(true);
    }
}
