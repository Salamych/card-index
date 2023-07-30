package com.hubbersport.mokito.stubbing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    
    @InjectMocks
    private BookService bookService;
    
    @Mock
    private BookRepository bookRepository;
    
    @Test
    public void testCalculateTotalCostOfBooks(){
        List<String> bookIds = new ArrayList<>();
        bookIds.add("1234");
        bookIds.add("1235");
        
        Book book1 = new Book("1234", "Mockito in Action", 500, LocalDate.now());
        Book book2 = new Book("1235", "JUnit 5 in Action", 400, LocalDate.now());

//        when(bookRepository.findBookByBookId("1234")).thenReturn(book1);
//        when(bookRepository.findBookByBookId("1235")).thenReturn(book2);
        
        doReturn(book1).when(bookRepository).findBookByBookId("1234");
        doReturn(book2).when(bookRepository).findBookByBookId("1235");
        
        int actualCost = bookService.calculateTotalCost(bookIds);
        assertEquals(900, actualCost);
    }
    
    @Test
    public void testSaveBook(){
     Book book1 = new Book(null, "Mockito in Action", 500, LocalDate.now());   
     doNothing().when(bookRepository).save(book1);
     bookService.addBook(book1);
    }
    
    @Test
    public void testSaveBookWithBookRequest(){
     BookRequest bookRequest = new BookRequest( "Mockito in Action", 500, LocalDate.now());   
      Book book = new Book(null, "Mockito in Action", 500, LocalDate.now());   
     doNothing().when(bookRepository).save(book);
     bookService.addBook(bookRequest);
    }
}
