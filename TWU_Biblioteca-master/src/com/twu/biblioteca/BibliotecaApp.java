package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        View view = new View();

        System.out.println(view.showWelcomeMessage());

        view.openMenu();
    }
}
