package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomerManagerTest {
    CustomerManager customerManager;
    boolean flag = false;

    @Before
    public void setUp() {
        customerManager = new CustomerManager();
    }

    @Test
    public void shouldLoginSuccessfullyGivenCorrectLibNumberAndPassword() {
        flag = customerManager.login(new Customer("111-1112", "123"));
        assertThat("login failed", flag, is(true));
    }

    @Test
    public void shouldLoginUnsuccessfullyGivenWrongLibNumberAndPassword() {
        flag = customerManager.login(new Customer("111-1110", "123"));
        assertThat("login failed", flag, is(false));
    }

    @Test
    public void shouldAddCustomerCorrectly() {
        Customer customer = new Customer("111-1109", "123");
        customerManager.getCustomerList().add(customer);
        assertThat("add customer failed", customerManager.getCustomerList().contains(customer), is(true));
    }

    @Test
    public void shouldInitializeCustomerCorrectly() {
        ArrayList<Customer> customerArrayList = customerManager.getCustomerList();
        assertThat("initialization failed", customerArrayList.size(), is(9));
    }
}
