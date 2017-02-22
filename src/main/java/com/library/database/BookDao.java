package com.library.database;

import com.library.domain.Book;

import java.util.List;

public interface BookDao {

    Book create(Book book);

    void update(Book book);

    void delete(Book book);

    Book getById(long id);

    List<Book> getAll();
}
