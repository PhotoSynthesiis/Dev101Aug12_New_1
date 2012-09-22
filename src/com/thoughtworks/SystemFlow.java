package com.thoughtworks;

public class SystemFlow {

    private Messages messages = new Messages();
    private CustomerActions customerActions = new CustomerActions();
    private CustomerManager customerManager = new CustomerManager();

    protected void flowOfTheSystem() {               // 自动化脚本
        boolean successfullyLogIn = loginInToTheSystem();
        if (successfullyLogIn) {
            flowOfTheSystemWithLogin();
        } else {
            flowOfTheSystemWithoutLogin();
        }
    }

    private boolean loginInToTheSystem() {
        messages.showNotifyToInputUssnameMessage();
        String username = customerActions.getClientChosenOption();
        messages.showNotifyInputPswdMessage();
        String password = customerActions.getClientChosenOption();
        return customerManager.login(username, password);
    }

    private void flowOfTheSystemWithoutLogin() {
        messages.showUnsuccessfullyLoginMessage();
    }

    private void flowOfTheSystemWithLogin() {
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
                default:
                    messages.showWarningMessage();
            }
        }
    }
}
