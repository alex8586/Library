package com.library.businesslogic;

import com.library.database.UserDao;
import com.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserListServiceImpl implements UserListService {

    @Autowired
    private UserDao userDao;

    public Map<String, Object> getUserList(){
        Map<String, Object> result = new HashMap<String, Object>();

        List<User> userList = userDao.getAll();
        result.put("userlist", userList);

        return result;
    }
}
