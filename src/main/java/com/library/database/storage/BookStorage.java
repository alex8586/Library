package com.library.database.storage;

import com.library.domain.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookStorage {

    private List<Book> bookList;

    private BookStorage() {
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

        Book book6 = new Book();
        book6.setId(6);
        book6.setTitle("Salt to the Sea");
        bookList.add(book6);

        Book book7 = new Book();
        book7.setId(7);
        book7.setTitle("Heartless");
        bookList.add(book7);

        Book book8 = new Book();
        book8.setId(8);
        book8.setTitle("All the Ugly and Wonderful Things");
        bookList.add(book8);

        Book book9 = new Book();
        book9.setId(9);
        book9.setTitle("Commonwealth");
        bookList.add(book9);

        Book book10 = new Book();
        book10.setId(10);
        book10.setTitle("The Couple Next Door");
        bookList.add(book10);

        return bookList;
    }
}
