package com.hubbersport.mokito.test_double.stub;

import java.util.Collection;
import java.util.List;

public interface BookRepository {

    public List<Book> findNewBooks(int days);
   
    
}
