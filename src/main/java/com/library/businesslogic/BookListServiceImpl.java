package com.library.businesslogic;

import com.library.database.BookDao;
import com.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookListServiceImpl implements BookListService {

    @Autowired
    private BookDao bookDao;

    public Map<String, Object> getBookList() {
        Map<String, Object> result = new HashMap<String, Object>();

        List<Book> bookList = bookDao.get20Books();
        Collections.sort(bookList);
        result.put("bookList", bookList);

        return result;
    }
}
