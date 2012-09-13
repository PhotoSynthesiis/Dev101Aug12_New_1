package com.thoughtworks;

public class LibraryController {
    Messages messages = new Messages();
    CustomerActions customerActions = new CustomerActions();

    public static void main(String[] args) {
        new LibraryController().flowOfTheSystem();
    }

    private void flowOfTheSystem() {
        while (true) {
            messages.showWelcomeMessage();
            messages.showOptions();
            operationsBasedOnClientChoice();
            if (customerActions.exitTheSystem()) {
                break;
            }
        }
    }

    private void operationsBasedOnClientChoice() {
        while (true) {
            String option = customerActions.getClientChosenOption();
            switch (Integer.parseInt(option)) {
                case 1:
                    customerActions.viewAllTheBooks();
                    return;
                case 2:
                    customerActions.reserveBook();
                    return;
                case 3:
                    messages.showLibraryNumber();
                    return;
                case 4:
                    customerActions.viewMovieList();
                    return;
                case 5:
                    customerActions.login();
                    return;
                default:
                    messages.showWarningMessage();
            }
        }
    }
}