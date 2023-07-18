package com.hubbersport.mokito.test_double.fake;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FakeTest {

    @Test
    public void testFake() {
        BookRepository bookRepository = new FakeBookRepository();
        BookService bookService = new BookService(bookRepository);
        
        bookService.addBook(new Book("1234","Mockito in Action",250,LocalDate.now()));
        bookService.addBook(new Book("1235","JUnit 5 in Action",200,LocalDate.now()));
        
        assertEquals(2,bookService.findNumberOfBooks());
    }
}
