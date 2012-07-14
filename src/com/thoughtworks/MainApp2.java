package com.thoughtworks;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/14/12
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainApp2 {
    private Scanner scan = new Scanner(System.in);

    private BookManager bookManager = new BookManager();

    private String clientOption;

    public static void main(String[] args) {
        MainApp2 mainApp2 = new MainApp2();

        while (true) {
            mainApp2.showWelcomeMessage();
            mainApp2.showOptions();
            mainApp2.operationsBasedOnClientChoice();

            if (mainApp2.clientExitTheSystem()) {
                break;
            } else {
                continue;
            }
        }
    }

    private boolean clientExitTheSystem() {
        System.out.println();
        System.out.println("Exit ? Y/N");

        while (true) {
            clientOption = getClientChosenOption();
            if (clientOption.equalsIgnoreCase("y")) {
                return true;
            } else if (clientOption.equalsIgnoreCase("n")) {
                return false;
            } else {
                showWarningMessage();
            }
        }
    }

    private void operationsBasedOnClientChoice() {
        while (true) {
            String option = getClientChosenOption();
            if (option.equals("1")) {
                viewAllTheBooks();
                break;
            } else if (option.equals("2")) {
                reserveBook();
                break;
            } else if (option.equals("3")) {
                showLibraryNumber();
                break;
            } else {
                showWarningMessage();
            }
        }
    }

    private void showWarningMessage() {
        System.out.println("Select a valid option!");
    }

    private void showLibraryNumber() {
        System.out.println("The library number is: " + bookManager.getLibraryNumber() + "\nPlease talk to Librarian. Thank you.");
    }

    private void reserveBook() {
        System.out.println();
        System.out.println("  --- please input the name of the book you want to reserve ---");

        String bookNameWantToReserve = getClientChosenOption();
        boolean reserve = bookManager.reserveBook(new Book(bookNameWantToReserve));
        if (reserve) {
            System.out.println("Thank you. Enjoy the book!");
        } else {
            System.out.println("Sorry we don't have that book yet");
        }
    }

    private void viewAllTheBooks() {
        LinkedList<Book> bookList;
        String lastBookName = "";
        bookList = bookManager.getAllBooks();

        System.out.println(" ......................................................");
        for (int i = 0; i < bookList.size(); i++) {
            if (!lastBookName.equals(bookList.get(i).getBookName())) {
                System.out.println("  " + bookList.get(i));
            }
            lastBookName = bookList.get(i).getBookName();
        }
        System.out.println(" ......................................................");
    }

    private String getClientChosenOption() {
        String option = scan.nextLine();
        return option;
    }

    private void showOptions() {
        System.out.println(" 1 -- > view all books in the library \n 2 -- > reserve a book \n 3 -- > check library number");
    }

    private void showWelcomeMessage() {
        System.out.println();
        System.out.println("-------  Welcome to Bangalore Public Library  --------");
    }
}

