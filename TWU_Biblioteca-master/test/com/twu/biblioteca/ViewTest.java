package com.twu.biblioteca;

import com.twu.database.Database;
import com.twu.models.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class ViewTest {

    private View view;
    private Database database;

    @Before
    public void setUp() throws Exception {
        view = new View();
        database = new Database();
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
    public void shouldReturnBooklistWithDetails(){
        String list = view.showBooklistWithDetails();
        ArrayList<Book> booklist = database.bookList;

        String childishBookName = booklist.get(0).getName();
        String childishBookAuthor = booklist.get(0).getAuthor();
        String childishBookYear = booklist.get(0).getYear().toString();

        assertTrue(list.contains(childishBookName) &&
                list.contains(childishBookAuthor) &&
                list.contains(childishBookYear));
    }

    @Test
    public void shouldReturnMenuOption(){
        String terminalMessage = view.showMenuOptions();

        assertThat(terminalMessage,
                containsString("-----MENU-----\n" +
                        "Choose an option\n\n" +
                        "1 - List of books"));
    }
}
