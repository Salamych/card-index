package com.hubbersport.mokito.stubbing;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String bookId;
    private String title;
    private int price;
    private LocalDate publishedDate;

    public Book() {
    }

    public Book(String bookId, String title, int price, LocalDate publishedDate) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.publishedDate = publishedDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.title);
        hash = 19 * hash + this.price;
        hash = 19 * hash + Objects.hashCode(this.publishedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.price != other.price) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Objects.equals(this.publishedDate, other.publishedDate);
    }
    
}
