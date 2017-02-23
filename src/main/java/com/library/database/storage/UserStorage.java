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

        User user4 = new User();
        user4.setId(4);
        user4.setName("Viktor");
        user4.setAge(26);
        userList.add(user4);

        User user5 = new User();
        user5.setId(5);
        user5.setName("Steve");
        user5.setAge(56);
        userList.add(user5);

        User user6 = new User();
        user6.setId(6);
        user6.setName("Brian");
        user6.setAge(38);
        userList.add(user6);

        User user7 = new User();
        user7.setId(7);
        user7.setName("Eduard");
        user7.setAge(41);
        userList.add(user7);

        User user8 = new User();
        user8.setId(8);
        user8.setName("Martins");
        user8.setAge(31);
        userList.add(user8);

        User user9 = new User();
        user9.setId(9);
        user9.setName("Ivan");
        user9.setAge(36);
        userList.add(user9);

        User user10 = new User();
        user10.setId(10);
        user10.setName("Rihards");
        user10.setAge(47);
        userList.add(user10);

        return userList;
    }
}
