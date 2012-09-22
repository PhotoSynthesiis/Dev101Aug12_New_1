package com.thoughtworks;

public class Messages {
    public void showOptions() {
        System.out.println(" 1 -- > view all books in the library \n 2 -- > reserve a book \n 3 -- > check library number" +
                "\n 4 -- > view all movies in library");
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

    public void showDots() {
        System.out.println(" ......................................................");
    }

    public void showMessageBeforeClientExit() {
        System.out.println();
        System.out.println("Exit ? Y/N");
    }

    public void showMovieAlreadyExistMessage() {
        System.out.println("Movie Already Exist!");
    }

    public void showNotifyInputPswdMessage() {
        System.out.println("password" + " : ");
    }

    public void showNotifyToInputUssnameMessage() {
        System.out.println("username" + " : ");
    }

    public void showUnsuccessfullyReserveABookMessage() {
        System.out.println("Sorry we don't have that book yet");
    }

    public void showSuccessfullyReserveABookMessage() {
        System.out.println("Thank you. Enjoy the book!");
    }

    public void showUnsuccessfullyLoginMessage() {
        System.out.println("......Please talk to Librarian......");
    }
}
