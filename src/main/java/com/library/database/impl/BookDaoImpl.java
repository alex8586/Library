package com.library.database.impl;

import com.library.database.BookDao;
import com.library.database.storage.BookStorage;
import com.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookDaoImpl implements BookDao {

    private List<Book> bookList;

    @Autowired
    public BookDaoImpl(BookStorage bookStorage) {
        this.bookList = bookStorage.loadData();
    }

    public Book create(Book book) {
        if (bookList.size() == 0) {
            book.setId(0);
            bookList.add(book);
        } else if (bookList.size() != 0) {
            book.setId(bookList.get(bookList.size() - 1).getId() + 1);
            bookList.add(book);
        }
        return book;
    }

    public void update(Book book) {
        for (Book fromDb : bookList) {
            if (fromDb.getId() == book.getId()) {
                fromDb.setTitle(book.getTitle());
                break;
            }
        }
    }

    public void delete(Book book) {
        bookList.remove(book);
    }

    public Book getById(long id) {
        for (Book book : bookList) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getAll() {
        return bookList.subList(0, bookList.size());
    }

    public List<Book> get20Books() {
        Set<Book> bookSet = new TreeSet<Book>();

        for (Book book : bookList) {
            bookSet.add(book);
            if (bookSet.size() == 20)
                break;
        }

        return new ArrayList<Book>(bookSet);
    }
}
