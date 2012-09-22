package com.thoughtworks;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CustomerActions {
    private Scanner scan = new Scanner(System.in);
    private BookManager bookManager = new BookManager();
    private Messages messages = new Messages();

    public boolean exitTheSystem() {
        messages.showMessageBeforeClientExit();

        while (true) {
            String clientOption = getClientChosenOption();
            if (clientOption.equalsIgnoreCase("y")) {
                return true;
            } else if (clientOption.equalsIgnoreCase("n")) {
                return false;
            } else {
                messages.showWarningMessage();
            }
        }
    }

    public void viewAllTheBooks() {
        Map<Book, Integer> bookAndItsNumbers = bookManager.getAllBooksMapper();
        String lastBookName = "";

        messages.showDots();
        for (Map.Entry<Book, Integer> entry : bookAndItsNumbers.entrySet()) {
            if (!lastBookName.equals(entry.getKey().getBookName())) {
                System.out.println("  " + entry.getKey().getBookName());
            }
            lastBookName = entry.getKey().getBookName();
        }
        messages.showDots();
    }

    public void reserveBook() {
        messages.headerMessageWhenReserveABook();
        if (bookManager.reserveBook(new Book(getClientChosenOption()))) {
            messages.showSuccessfullyReserveABookMessage();
        } else {
            messages.showUnsuccessfullyReserveABookMessage();
        }
    }

    public String getClientChosenOption() {
        return scan.nextLine();
    }

    public void viewMovieList() {
        ArrayList<Movie> movieArrayList = new MovieManager().getMovieList();
        for (Movie aMovieArrayList : movieArrayList) {
            System.out.println(aMovieArrayList);
        }
    }
}
