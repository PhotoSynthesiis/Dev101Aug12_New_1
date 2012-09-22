package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BookManagerTest {
    BookManager bookManager;

    @Before
    public void setUp() {
        bookManager = new BookManager();
    }

    @Test
    public void shouldInitializeSuccessfully() {
        Map<Book, Integer> EachKindOfBookWithItsNumber = bookManager.getAllBooksMapper();
        int numberOfBooks = 0;
        for (Map.Entry<Book, Integer> entry : EachKindOfBookWithItsNumber.entrySet()) {
            numberOfBooks += entry.getValue();
        }
        assertThat("number of books is incorrect", numberOfBooks, is(13));
    }

    @Test
    public void shouldNotBeAbleToReserveANoneExistentBook() {
        boolean isReserved = bookManager.reserveBook(new Book("nakamura"));
        assertThat("book should be available", isReserved, is(false));
    }

    @Test
    public void shouldBeAbleTOReserveABookWhichExists() {
        boolean isReserved = bookManager.reserveBook(new Book("thinking in java"));
        assertThat("book should be available", isReserved, is(true));
    }

    @Test
    public void shouldAddBookSuccessfully() {
        Book book = new Book("Spring in Action", "Bob");
        bookManager.addBooks(book);
        boolean isAdded = bookManager.getAllBooksMapper().containsKey(book);
        assertThat("add book failed", isAdded, is(true));
    }
}
