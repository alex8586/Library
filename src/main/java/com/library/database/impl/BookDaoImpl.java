package com.library.database.impl;

import com.library.database.BookDao;
import com.library.database.storage.BookStorage;
import com.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDaoImpl implements BookDao {

    private List<Book> bookList;

    @Autowired
    public BookDaoImpl(BookStorage bookStorage){
        this.bookList = bookStorage.loadData();
    }

    public Book create(Book book) {
        book.setId(bookList.size());
        bookList.add(book);
        return book;
    }

    public void update(Book book) {
        for(Book fromDb : bookList){
            if(fromDb.getId() == book.getId()){
                fromDb.setTitle(book.getTitle());
            }
        }
    }

    public void delete(Book book) {
        bookList.remove(book);
    }

    public Book getById(final long id) {
        for(Book book : bookList){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public List<Book> getAll() {
        List<Book> books;
        books = bookList;
        return books;
    }
}
