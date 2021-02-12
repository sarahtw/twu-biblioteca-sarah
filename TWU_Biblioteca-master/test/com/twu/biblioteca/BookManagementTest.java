package com.twu.biblioteca;

import com.twu.models.Book;
import com.twu.services.BookManagement;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BookManagementTest {

    private BookManagement bookManagement;
    private ArrayList<Book> availableBooks;

    @Before
    public void setUp() {
        bookManagement = new BookManagement();
        availableBooks = bookManagement.books;
    }

    @Test
    public void shouldCheckoutBook(){
        bookManagement.changeBookStatusToRented("The Little Prince");

        Boolean actual = availableBooks.get(0).isAvailable();
        assertThat(actual, is(false));
    }
    @Test
    public void shouldReturnBook(){
        bookManagement.changeBookStatusToAvailable("Chromatica");

        Boolean actual = availableBooks.get(0).isAvailable();
        assertThat(actual, is(true));
    }

    @Test
    public void shouldReturnIfBookIsAvailable(){
        assertThat(bookManagement.isBookAvailableToCheckout("Amor I love you"), is(false));
        assertThat(bookManagement.isBookAvailableToCheckout("The Little Prince"), is(true));
    }

    @Test
    public void shouldReturnIfBookIsRented(){
        assertThat(bookManagement.isBookAvailableToReturn("Amor I love you"), is(false));
        assertThat(bookManagement.isBookAvailableToReturn("The Little Prince"), is(false));
        assertThat(bookManagement.isBookAvailableToReturn("Chromatica"), is(true));
    }

    @Test
    public void shouldReturnBookByName(){
        assertNull(bookManagement.getBookByName("Amor I love you"));
        assertNotNull(bookManagement.getBookByName("The Little Prince"));
    }
}
