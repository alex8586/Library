package com.library.database.storage;

import com.library.domain.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookStorage {

    private List<Book> bookList;

    private BookStorage() {
        System.out.println("in bookStorage");
        this.bookList = new ArrayList<Book>();
    }

    public List<Book> loadData(){
        Book book = new Book();
        book.setId(0);
        book.setTitle("When Breath Becomes Air");
        bookList.add(book);

        Book book1 = new Book();
        book1.setId(1);
        book1.setTitle("Truly Madly Guilty");
        bookList.add(book1);

        Book book2 = new Book();
        book2.setId(2);
        book2.setTitle("The Underground Railroad");
        bookList.add(book2);

        Book book3 = new Book();
        book3.setId(3);
        book3.setTitle("Behind Closed Doors");
        bookList.add(book3);

        Book book4 = new Book();
        book4.setId(4);
        book4.setTitle("Small Great Things");
        bookList.add(book4);

        Book book5 = new Book();
        book5.setId(5);
        book5.setTitle("Dark Matter");
        bookList.add(book5);

        return bookList;
    }
}
