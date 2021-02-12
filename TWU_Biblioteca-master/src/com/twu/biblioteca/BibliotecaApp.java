package com.twu.biblioteca;

import java.io.InputStream;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        View view = new View();

        System.out.println(view.showWelcomeMessage());

        view.openMenu();
    }
}
