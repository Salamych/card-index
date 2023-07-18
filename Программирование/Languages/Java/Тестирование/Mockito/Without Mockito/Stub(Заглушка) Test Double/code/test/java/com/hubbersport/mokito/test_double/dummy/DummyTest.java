package com.hubbersport.mokito.test_double.dummy;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class DummyTest {
    
    @Test
    public void demoDummy(){
        BookRepository bookRepository = new FakeBookRepository();
        EmailService emailService = new DummyEmailService();
        BookService bookService = new BookService(bookRepository,emailService);
        
        bookService.addBook(new Book("1234","Mockito in Action",250,LocalDate.now()));
        bookService.addBook(new Book("1235","JUnit 5 in Action",200,LocalDate.now()));
        
        assertEquals(2,bookService.findNumberOfBooks());
    }
    
}
