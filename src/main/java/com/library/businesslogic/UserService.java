package com.library.businesslogic;

import com.library.domain.User;

import java.util.Map;

public interface UserService {

    Map<String, Object> getUser(long id);

    void createUser(User user);

    void updateUserDetails(long id, String name, int age);

    void deleteUser(long id);

}
