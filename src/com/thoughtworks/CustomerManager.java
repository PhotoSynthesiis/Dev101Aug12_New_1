package com.thoughtworks;

import java.util.ArrayList;
import java.util.Collections;

public class CustomerManager {
    private ArrayList<Customer> customerList = new ArrayList<Customer>();

    public CustomerManager() {
        initializeCustomers(getCustomerInfo());
    }

    private void initializeCustomers(Customer[] customer) {
        Collections.addAll(customerList, customer);
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public boolean login(String username, String password) {
        return login(new Customer(username, password));
    }

    public boolean login(Customer customer) {
        return customerList.contains(customer);
    }

    private Customer[] getCustomerInfo() {
        return new Customer[]{new Customer("111-1112", "123"), new Customer("111-1113", "123"), new Customer("111-1114", "123"),
                new Customer("111-1115", "123"), new Customer("111-1116", "123"), new Customer("111-1117", "123"),
                new Customer("111-1118", "123"), new Customer("111-1119", "123"), new Customer("111-1120", "123")};
    }
}
