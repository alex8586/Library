package com.library.database;

import com.library.domain.User;

import java.util.List;

public interface UserDao {

    User create(User user);

    void update(User user);

    void delete(User user);

    User getById(long id);

    List<User> getAll();
}
