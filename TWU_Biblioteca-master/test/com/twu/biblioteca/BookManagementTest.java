package com.twu.biblioteca;

import com.twu.models.Book;
import com.twu.services.BookManagement;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class BookManagementTest {

    private BookManagement bookManagement;
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> rentedBooks;


    @Before
    public void setUp() throws Exception {
        bookManagement = new BookManagement();
        availableBooks = bookManagement.availableBooks;
        rentedBooks = bookManagement.rentedBooks;
    }


    @Test
    public void shouldCheckoutABook(){

        String expectedAvailableBooks = String.valueOf(availableBooks.size() - 1);
        String expectedRentedBooks = String.valueOf(rentedBooks.size() + 1);

        bookManagement.checkoutBook("The Little Prince");

        String actualAvailableBooks = String.valueOf(availableBooks.size());
        String actualRentedBooks = String.valueOf(rentedBooks.size());

        assertThat(actualAvailableBooks, containsString(expectedAvailableBooks));
        assertThat(actualRentedBooks, containsString(expectedRentedBooks));
    }
}
