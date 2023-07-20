package com.hubbersport.mockito.annotations.support;

import java.util.List;

public interface BookRepository {

    public List<Book> findNewBooks(int days);
   
    
}
