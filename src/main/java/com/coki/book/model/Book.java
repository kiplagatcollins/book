package com.coki.book.model;

import jakarta.persistence.*;

@Entity
@Table
public class Book {

    @Id
    @Column
    @GeneratedValue
    public  int bookId;

    @Column
    public String bookName;

    @Column
    public String author;

    @Column
    public  double price;

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
