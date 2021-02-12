package com.twu.biblioteca;

import com.twu.database.Database;
import com.twu.models.Book;
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
    private Database database;

    private final ByteArrayOutputStream outputContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() throws Exception {
        view = new View();
        database = new Database();
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
        ArrayList<Book> booklist = database.bookList;

        String childishBookName = booklist.get(0).getName();
        String detectiveBookName = booklist.get(1).getName();

        assertTrue(list.contains(childishBookName) &&
                list.contains(detectiveBookName));
    }

    @Test
    public void shouldReturnBookListWithDetails(){
        String list = view.showBooklistWithDetails();
        ArrayList<Book> bookList = database.bookList;

        String childishBookName = bookList.get(0).getName();
        String childishBookAuthor = bookList.get(0).getAuthor();
        String childishBookYear = bookList.get(0).getYear().toString();

        assertTrue(list.contains(childishBookName) &&
                list.contains(childishBookAuthor) &&
                list.contains(childishBookYear));
    }

    @Test
    public void shouldReturnMenuOption(){
        view.showMenuOptions();

        assertThat(outputContent.toString(),
                containsString("-----MENU-----\nChoose an option\n\n1 - List of books"));
    }

    @Test
    public void shouldSayIsAnInvalidOption(){
        view.chooseMenuOption("view books");

        assertThat(outputContent.toString(), containsString("Please select a valid option!"));
    }

    @Test
    public void shouldQuitTheApplication(){
        view.chooseMenuOption("2");

        assertThat(outputContent.toString(), containsString("See ya!"));
    }

}
