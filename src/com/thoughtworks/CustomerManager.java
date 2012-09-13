package com.thoughtworks;

import java.util.ArrayList;

public class CustomerManager {
    private ArrayList<Customer> customerList = new ArrayList<Customer>();

    public CustomerManager() {
        initializeCustomers();
    }

    private void initializeCustomers() {
        Customer[] customer = {new Customer("111-1112", "123"), new Customer("111-1113", "123"), new Customer("111-1114", "123"),
                new Customer("111-1115", "123"), new Customer("111-1116", "123"), new Customer("111-1117", "123"),
                new Customer("111-1118", "123"), new Customer("111-1119", "123"), new Customer("111-1120", "123")};
        for (int i = 0; i < customer.length; i++) {
            addCustomer(customer[i]);
        }
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public boolean login(Customer customer) {
        if (customerList.contains(customer)) {
            return true;
        }
        return false;
    }
}
