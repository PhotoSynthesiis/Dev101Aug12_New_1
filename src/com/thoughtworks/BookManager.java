package com.thoughtworks;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookManager {

    private Map<Book, Integer> bookAndItsNumber = new HashMap<Book, Integer>();

    public BookManager() {
        initializeBooks();
    }

    public Map<Book, Integer> getAllBooks() {
        return bookAndItsNumber;
    }

    private void initializeBooks() {
        Book books[] = {
                new Book("gone with the wind", "Margaret Mitchell"), new Book("thinking in java", "Bruce Eckel"),
                new Book("thinking in java", "Bruce Eckel"), new Book("thinking in java", "Bruce Eckel"),
                new Book("java concurrency programming", "Brian Goetz"),
                new Book("regular expressions", "Jeffery Fridl"), new Book("steve jobs", "Walter Issacson"),
                new Book("SQL in 10 minuts", "Ben Forta"), new Book("clean code", "Robert Martin"),
                new Book("refactory", "Martin Fowler"), new Book("dead first java", "Bert Bates"),
                new Book("design patterns", "Gamma"), new Book("java concurrency programming", "Brian Goetz")};

        for (int i = 0; i < books.length; i++) {
            addBooks(books[i]);
        }
    }

    public void addBooks(Book book) {
        if (bookAndItsNumber.containsKey(book)) {
            putBooksIntoLibrary(book, bookAndItsNumber.get(book) + 1);
        } else {
            putBooksIntoLibrary(book, 1);
        }
    }

    private void putBooksIntoLibrary(Book book, int numberOfBooksToBePut) {
        bookAndItsNumber.put(book, numberOfBooksToBePut);
    }

    public boolean reserveBook(Book bookBeingReserved) {
        String regExp = bookBeingReserved.getBookName().toLowerCase();
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher;
        Book book;

        for (Map.Entry<Book, Integer> entry : bookAndItsNumber.entrySet()) {
            book = entry.getKey();
            matcher = pattern.matcher(book.getBookName().toLowerCase());

            if (matcher.find() && !numberOfBooksIsZero(book)) {
                putBooksIntoLibrary(book, bookAndItsNumber.get(entry.getKey()) - 1);
                return true;
            }
        }
    return false;
}

    private boolean numberOfBooksIsZero(Book book) {
        return bookAndItsNumber.get(book) == 0;
    }
}
