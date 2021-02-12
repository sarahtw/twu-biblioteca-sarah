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
    public ArrayList<Book> books;

    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        view = new View();
        books = new BookManagement().books;
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
    public void shouldReturnOnlyAvailableBooks(){
        view.chooseMenuOption("1");
        assertFalse(outputContent.toString().contains("Chromatica"));
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

    @Test
    public void shouldReturnUnsuccessfulCheckoutMessage(){
        view.chooseBook("Amor I love you");

        assertThat(outputContent.toString(), containsString("Sorry, that book is not available"));
    }

    @Test
    public void shouldNotifiedSuccessfulReturnMessage(){
        view.returnBook("Chromatica");

        assertThat(outputContent.toString(), containsString("Thank you for returning the book"));
    }

}
