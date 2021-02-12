package com.twu.services;

import com.twu.models.Book;

import java.util.ArrayList;

public class BookManagement {

    public static ArrayList<Book> availableBooks;
    public static ArrayList<Book> rentedBooks;

    public BookManagement() {
        availableBooks = this.createBookList();
        rentedBooks = new ArrayList<Book>();
    }

    public ArrayList<Book> createBookList(){
        ArrayList<Book>books = new ArrayList<Book>();

        Book childishBook = new Book(1, "The Little Prince", "Antoine de Saint-Exupéry", 1943);
        Book detectiveBook = new Book(2, "The Mysterious Affair at Styles", "Agatha Christie", 1920);

        books.add(childishBook);
        books.add(detectiveBook);

        return books;
    }

    public static void checkoutBook(Integer book_id) {
        ArrayList<Book> bookListAux = availableBooks;
        for (Book book: availableBooks) {
            if (book.getId().equals(book_id)) {
                rentedBooks.add(book);
                bookListAux.remove(book);
            }
        }
        availableBooks = bookListAux;
    }

}
