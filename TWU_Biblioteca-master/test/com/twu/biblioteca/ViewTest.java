package com.twu.biblioteca;

import com.twu.models.Book;
import com.twu.services.BookManagement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class ViewTest {

    private View view;
    private ArrayList<Book> books;

    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        view = new View();
        books = new BookManagement().availableBooks;
        System.setOut(new PrintStream(outputContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void shouldReturnWelcomeMessage() {
        String message = view.showWelcomeMessage();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", message);
    }

    @Test
    public void shouldReturnBooklist() {

        String list = view.showBooklist();

        String childishBookName = books.get(0).getName();
        String detectiveBookName = books.get(0).getName();

        assertTrue(list.contains(childishBookName) &&
                list.contains(detectiveBookName));
    }

    @Test
    public void shouldReturnMenuOption(){
        view.showMenuOptions();

        assertThat(outputContent.toString(),
                containsString("-----MENU-----\nChoose an option\n\n1 - List of books"));
    }

    @Test
    public void shouldQuitTheApplication(){
        view.chooseMenuOption("0");

        assertThat(outputContent.toString(), containsString("See ya!"));
    }

    @Test
    public void shouldReturnBookListWithDetails(){
        view.chooseMenuOption("1");

        assertThat(outputContent.toString(),
                containsString("The Little Prince - The Little Prince - 1943"));
    }

    @Test
    public void shouldSayIsAnInvalidOption(){
        view.chooseMenuOption("view books");

        assertThat(outputContent.toString(), containsString("Please select a valid option!"));
    }

    @Test
    public void shouldReturnCheckoutSuccessMessage(){
        view.chooseBook("The Little Prince");

        assertThat(outputContent.toString(), containsString("Thank you! Enjoy the book"));
    }

}
