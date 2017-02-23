package com.library.businesslogic;

import java.util.Map;

public interface UserService {

    Map<String, Object> getUser(long id);

    void updateUserDetails(long id, String name, int age);

    void deleteUser(long id);

}
