package com.thoughtworks;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CustomerActions {
    private Scanner scan = new Scanner(System.in);
    private BookManager bookManager = new BookManager();
    Messages messages = new Messages();

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
        Map<Book, Integer> bookAndItsNumbers = bookManager.getAllBooks();
        String lastBookName = "";

        messages.showDots();
        for (Map.Entry<Book, Integer> entry : bookAndItsNumbers.entrySet()) {
            if (!lastBookName.equals(entry.getKey().getBookName())) {
                messages.showBookName(entry);
            }
            lastBookName = entry.getKey().getBookName();
        }
        messages.showDots();
    }

    public void login() {
        CustomerManager customerManager = new CustomerManager();
        messages.showLoginMessage("username");
        String username = getClientChosenOption();
        messages.showLoginMessage("password");
        String password = getClientChosenOption();
        messages.messageWhenLogin(customerManager, username, password);
    }

    public void reserveBook() {
        messages.headerMessageWhenReserveABook();
        messages.messageWhenReserveABook(bookManager.reserveBook(new Book(getClientChosenOption())));
    }

    public String getClientChosenOption() {
        return scan.nextLine();
    }

    public void viewMovieList() {
        ArrayList<Movie> movieArrayList = new MovieManager().getMovieList();
        for (int i = 0; i < movieArrayList.size(); i++) {
            System.out.println(movieArrayList.get(i));
        }
    }
}
