package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
    public void shouldShowWelcomeMessage() {
        String message = view.showWelcomeMessage();
        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", message);
    }

    @Test
    public void shouldShowBookList() {
        List<String> list = view.showBooklist();
        ArrayList<String> booklist = database.bookList;

        assertEquals(booklist,
                list);

    }
}
