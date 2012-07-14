package com.thoughtworks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/13/12
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class BookManager {
    private LinkedList<Book> bookList = new LinkedList<Book>();

    private Map<Book, Integer> bookAndItsNumber = new HashMap<Book, Integer>();
    public int libraryNumber = 100;

    public BookManager() {
        initializeBooks();
    }

    public LinkedList getAllBooks() {
        return bookList;
    }

    private void initializeBooks() {
        Book books[] = {new Book("gone with the wind", "Margaret Mitchell"), new Book("thinking in java", "Bruce Eckel"),
                new Book("thinking in java", "Bruce Eckel"), new Book("thinking in java", "Bruce Eckel"),
                new Book("java concurrency programming", "Brian Goetz"),
                new Book("regular expressions", "Jeffery Fridl"), new Book("steve jobs", "Walter Issacson"),
                new Book("SQL in 10 minuts", "Ben Forta"), new Book("clean code", "Robert Martin"),
                new Book("refactory", "Martin Fowler"), new Book("dead first java", "Bert Bates"),
                new Book("design patterns", "Gamma"), new Book("java concurrency programming", "Brian Goetz")};

        for (int i = 0; i < books.length; i++) {
            addBooks(books[i]);
            booksAndTheirNumbers(books[i]);
        }
    }

    private void addBooks(Book book) {
        bookList.add(book);
    }

    private void booksAndTheirNumbers(Book book) {
        if (bookAndItsNumber.containsKey(book)) {
            bookAndItsNumber.put(book, bookAndItsNumber.get(book) + 1);
        } else {
            bookAndItsNumber.put(book, 1);
        }
    }

    public boolean reserveBook(Book bookPara) {
        String regExp = bookPara.getBookName().toLowerCase();
        for (Book book : bookList) {
            if (Pattern.compile(regExp).matcher(book.getBookName().toLowerCase()).find()) {
                if (bookAndItsNumber.get(book) == 0) {
                    return false;
                } else {
                    bookAndItsNumber.put(book, bookAndItsNumber.get(book) - 1);
                    return true;
                }
            }
        }
        return false;
    }

    public int getLibraryNumber() {
        return libraryNumber;
    }
}
