package com.twu.database;

import com.twu.models.Book;

import java.util.ArrayList;

public class Database {
    public ArrayList<Book> bookList;

    public Database() {
        this.bookList = this.createBookList();
    }

    public ArrayList<Book> createBookList(){
        ArrayList<Book> bookList = new ArrayList<Book>();

        Book childishBook = new Book("The Little Prince", "Antoine de Saint-Exupéry", 1943);
        Book detectiveBook = new Book("The Mysterious Affair at Styles", "Agatha Christie", 1920);

        bookList.add(childishBook);
        bookList.add(detectiveBook);

        return bookList;
    }
}
