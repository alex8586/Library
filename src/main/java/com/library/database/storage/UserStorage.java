package com.library.database.storage;

import com.library.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserStorage {

    List<User> userList;

    private UserStorage() {
        this.userList = new ArrayList<User>();
    }

    public List<User> loadData(){
        User user = new User();
        user.setId(0);
        user.setName("Mihail");
        user.setAge(23);

        userList.add(user);
        return userList;
    }
}
