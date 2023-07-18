package com.hubbersport.mokito.test_double.mock;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MockTest {

    @Test
    public void demoMock() {
        BookRepositoryMock bookRepositoryMock = new BookRepositoryMock();
        BookService bookService = new BookService(bookRepositoryMock);

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 in Action", 400, LocalDate.now());
        
        bookService.addBook(book1);
        bookService.addBook(book2);
        
        bookRepositoryMock.verify(book2, 1);
    }

}
