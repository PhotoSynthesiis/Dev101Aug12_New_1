package com.thoughtworks;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/13/12
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class Book {
    private String bookName;
    private String author;

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || !(obj instanceof Book)) {
            return false;
        }
        Book bookObj = (Book) obj;
        return (getBookName()).equalsIgnoreCase(bookObj.getBookName());
    }

    @Override
    public int hashCode() {
        return (getBookName() != null ? getBookName().hashCode() : 1) * 31 + (getAuthor() != null ? getAuthor().hashCode() : 1) * 31;
    }

    @Override
    public String toString() {
        return getBookName() + " ----- " + getAuthor();
    }

}
