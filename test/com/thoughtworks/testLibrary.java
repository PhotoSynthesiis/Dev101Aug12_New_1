package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/13/12
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class testLibrary {
    BookManager bookManager;

    @Before
    public void setUp() {
        bookManager = new BookManager();
    }

    @Test
    public void shouldReturnTheNumberOfBooksCorrectly() {
        LinkedList bookList = bookManager.getAllBooks();

        assertThat("number of books is incorrect", bookList.size(), is(13));
    }

    @Test
    public void shouldNotBeAbleToReserveANoneExistentBook() {
        boolean b2 = bookManager.reserveBook(new Book("nakamura"));
        assertThat("book should be available", b2, is(false));
    }

    @Test
    public void shouldBeAbleTOReserveABookWhichExists() {
        boolean b = bookManager.reserveBook(new Book("thinking in java"));
        assertThat("book should be available", b, is(true));
    }

}
