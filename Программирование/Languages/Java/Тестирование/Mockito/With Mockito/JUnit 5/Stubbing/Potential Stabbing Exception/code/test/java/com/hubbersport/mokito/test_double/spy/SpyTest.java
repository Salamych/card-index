package com.hubbersport.mokito.test_double.spy;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void demoSpy() {
        BookRepositorySpy bookRepositorySpy = new BookRepositorySpy();
        BookService bookService = new BookService(bookRepositorySpy);

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 in Action", 400, LocalDate.now());
        
        bookService.addBook(book1);
        assertEquals(0,bookRepositorySpy.timesCalled());
        
        bookService.addBook(book2);
        assertEquals(1,bookRepositorySpy.timesCalled());
        
//        assertTrue(bookRepositorySpy.calledWith(book2));
    }
    
    @Test
    public void demoSpyWithMockito() {
        BookRepository bookRepositorySpy = spy(BookRepository.class);
        BookService bookService = new BookService(bookRepositorySpy);

        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 in Action", 400, LocalDate.now());
        
        bookService.addBook(book1); // return
        bookService.addBook(book2); // save will be called
        
        verify(bookRepositorySpy, times(1)).save(book2);
        verify(bookRepositorySpy, times(0)).save(book1);
    }

}
