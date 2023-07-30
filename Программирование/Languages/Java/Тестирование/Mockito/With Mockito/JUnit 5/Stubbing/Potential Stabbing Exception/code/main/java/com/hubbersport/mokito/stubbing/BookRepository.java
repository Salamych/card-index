package com.hubbersport.mokito.stubbing;

import java.util.List;

public interface BookRepository {

    public List<Book> findNewBooks(int days);

    public Book findBookByBookId(String bookId);

    public void save(Book book);
 
}
