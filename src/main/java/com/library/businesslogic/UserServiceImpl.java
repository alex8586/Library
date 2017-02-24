package com.library.businesslogic;

import com.library.database.UserDao;
import com.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public Map<String, Object> getUser(long id) {
        Map<String, Object> result = new HashMap<String, Object>();
        User user = userDao.getById(id);
        result.put("user", user);
        return result;
    }

    public void createUser(User user){
        userDao.create(user);
    }

    public void updateUserDetails(long id, String name, int age){
        User forUpdate = userDao.getById(id);
        forUpdate.setName(name);
        forUpdate.setAge(age);
        userDao.update(forUpdate);
    }

    public void deleteUser(long id) {
        User user = userDao.getById(id);
        userDao.delete(user);
    }
}
