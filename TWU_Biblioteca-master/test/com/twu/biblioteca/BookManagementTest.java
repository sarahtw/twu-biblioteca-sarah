package com.twu.biblioteca;

import com.twu.models.Book;
import com.twu.services.BookManagement;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookManagementTest {

    private BookManagement bookManagement;
    private ArrayList<Book> availableBooks;

    @Before
    public void setUp() throws Exception {
        bookManagement = new BookManagement();
        availableBooks = bookManagement.books;
    }


    @Test
    public void shouldCheckoutABook(){
        bookManagement.checkoutBook("The Little Prince");

        Boolean actual = availableBooks.get(0).isAvailable();
        assertThat(actual, is(false));
    }

    @Test
    public void shouldReturnIfBookIsAvailable(){
        assertThat(bookManagement.isBookAvailabe("Amor I love you"), is(false));
        assertThat(bookManagement.isBookAvailabe("The Little Prince"), is(true));
    }
}
