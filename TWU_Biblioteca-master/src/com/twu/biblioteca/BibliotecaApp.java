package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        View view = new View();
        String welcomeMessage = view.showWelcomeMessage();
        System.out.println(welcomeMessage);
    }
}
