package com.hubbersport.mokito.test_double.fake;

import java.util.Collection;

public interface BookRepository {
    
    void save(Book book);
    Collection<Book> findAll();
    
}
