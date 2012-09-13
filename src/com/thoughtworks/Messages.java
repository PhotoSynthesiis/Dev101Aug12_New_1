package com.thoughtworks;

import java.util.Map;

public class Messages {
    public void showOptions() {
        System.out.println(" 1 -- > view all books in the library \n 2 -- > reserve a book \n 3 -- > check library number" +
                "\n 4 -- > view all movies in library" + "\n 5 -- > log in");
    }

    public void showWelcomeMessage() {
        System.out.println();
        System.out.println("-------  Welcome to Bangalore Public Library  --------");
    }

    public void headerMessageWhenReserveABook() {
        System.out.println();
        System.out.println("  --- please input the name of the book you want to reserve ---");
    }

    public void showWarningMessage() {
        System.out.println("Select a valid option!");
    }

    public void showLibraryNumber() {
        System.out.println("The library number is: " + new Customer().getLibraryNumber() + "\nPlease talk to Librarian. Thank you.");
    }

    public void messageWhenReserveABook(boolean reserveStatus) {
        if (reserveStatus) {
            System.out.println("Thank you. Enjoy the book!");
        } else {
            System.out.println("Sorry we don't have that book yet");
        }
    }

    public void messageWhenLogin(CustomerManager customerManager, String username, String password) {
        if (customerManager.login(new Customer(username, password))) {
            System.out.println("Welcome to the lib");
        } else {
            System.out.println("invalid username or password");
        }
    }

    public void showDots() {
        System.out.println(" ......................................................");
    }

    public void showLoginMessage(String str) {
        System.out.println(str + " : ");
    }

    public void showMessageBeforeClientExit() {
        System.out.println();
        System.out.println("Exit ? Y/N");
    }

    public void showBookName(Map.Entry<Book, Integer> entry) {
        System.out.println("  " + entry.getKey().getBookName());
    }
}
