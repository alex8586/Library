package com.library.database.impl;

import com.library.config.Application;
import com.library.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class BookDaoImplTest {

    @Autowired
    private BookDaoImpl bookDao;

    @Test
    public void createBookTest(){
        int listSize = bookDao.getAll().size();

        Book book = new Book();
        book.setTitle("new book");

        Book fromDao = bookDao.create(book);
        assertTrue(listSize < bookDao.getAll().size());
        assertEquals(book.getTitle(),fromDao.getTitle());
        assertNotNull(fromDao.getId());
    }

    @Test
    public void updateBookTest(){
        Book book = createBookInDao();
        long bookId = book.getId();
        book.setTitle("This is new book");

        bookDao.update(book);
        Book fromDao = bookDao.getById(bookId);
        assertTrue(bookId == fromDao.getId());
        assertEquals("This is new book", fromDao.getTitle());
        assertTrue(bookId == fromDao.getId());
    }

    @Test
    public void deleteBookTest(){
        Book book = createBookInDao();
        long bookId = book.getId();
        bookDao.delete(book);

        assertNull(null, bookDao.getById(bookId));
    }

    @Test
    public void getByIdTest(){
        Book book = createBookInDao();
        long bookId = book.getId();

        Book fromDao = bookDao.getById(bookId);
        assertTrue(bookId == fromDao.getId());
        assertEquals(book.getTitle(), fromDao.getTitle());
    }

    @Test
    public void get20BooksTest(){
        fillBookList();
        List<Book> bookList = bookDao.get20Books();
        assertTrue(20 == bookList.size());
    }

    private void fillBookList(){
        for(int i = 0; i < 25; i++){
            Book book = new Book();
            book.setTitle("book name " + i);
            bookDao.create(book);
        }
    }

    private Book createBookInDao(){
        Book book = new Book();
        book.setTitle("War and Peace");
        return bookDao.create(book);
    }

}
