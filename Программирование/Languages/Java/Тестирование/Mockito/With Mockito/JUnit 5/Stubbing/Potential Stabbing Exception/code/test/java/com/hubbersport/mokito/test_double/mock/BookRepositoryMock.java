package com.hubbersport.mokito.test_double.mock;

import static org.junit.jupiter.api.Assertions.*;


public class BookRepositoryMock implements BookRepository {

    int saveCalled = 0;
    Book lastAddedBook = null;

    @Override
    public void save(Book book) {
        saveCalled++;
        lastAddedBook = book;
    }
    
    public void verify(Book book, int times){
        assertEquals(times,saveCalled);
        assertEquals(book,lastAddedBook);
    }
}
