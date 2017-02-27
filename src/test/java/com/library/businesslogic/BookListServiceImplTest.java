package com.library.businesslogic;

import com.library.config.Application;
import com.library.database.BookDao;
import com.library.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class BookListServiceImplTest {

    @Autowired
    private BookListService bookListService;

    @Autowired
    private BookDao bookDao;

    @Test
    public void getBookListTest(){
        fillBookList();
        Map<String, Object> map = bookListService.getBookList();
        List<Book> list = (List<Book>) map.get("bookList");
        assertTrue(20 == list.size());
    }

    private void fillBookList(){
        for(int i = 0; i < 25; i++){
            Book book = new Book();
            book.setTitle("book name " + i);
            bookDao.create(book);
        }
    }
}
