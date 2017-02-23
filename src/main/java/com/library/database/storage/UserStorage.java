package com.library.database.storage;

import com.library.domain.Book;
import com.library.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {

    private List<User> userList;

    private UserStorage() {
        this.userList = new ArrayList<User>();
    }

    public List<User> loadData(){
        User user = new User();
        user.setId(0);
        user.setName("Mihail");
        user.setAge(23);
        List<Book> bookList = new ArrayList<Book>();
        Book book = new Book();
        book.setTitle("When Breath Becomes Air");
        bookList.add(book);
        Book book1 = new Book();
        book1.setTitle("Truly Madly Guilty");
        bookList.add(book1);
        user.setBookList(bookList);
        userList.add(user);

        User user1 = new User();
        user1.setId(1);
        user1.setName("Vladimir");
        user1.setAge(45);
        userList.add(user1);

        User user2 = new User();
        user2.setId(2);
        user2.setName("John");
        user2.setAge(16);
        userList.add(user2);

        User user3 = new User();
        user3.setId(3);
        user3.setName("Janis");
        user3.setAge(37);
        userList.add(user3);

        return userList;
    }
}
