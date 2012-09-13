package com.thoughtworks;

public class Customer {
    private String libraryNumber = "111-1111";
    private String password;

    public Customer(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public Customer() {
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Customer)) {
            return false;
        }

        Customer customer = (Customer)obj;
        return this.getLibraryNumber().equalsIgnoreCase(customer.getLibraryNumber());
    }

    @Override
    public int hashCode() {
        return (getLibraryNumber() != null ? getLibraryNumber().hashCode() : 1) * 31
                + (getPassword() != null ? getPassword().hashCode() : 1) * 31;
    }
}
