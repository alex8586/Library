package com.library.database.impl;

import com.library.database.UserDao;
import com.library.database.storage.UserStorage;
import com.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private List<User> userList;

    @Autowired
    public UserDaoImpl(UserStorage userStorage){
        this.userList = userStorage.loadData();
    }

    public User create(User user) {
        if(userList.size() == 0){
            user.setId(0);
            userList.add(user);
        }else if(userList.size() != 0) {
            user.setId(userList.get(userList.size() - 1).getId() + 1);
            userList.add(user);
        }
        return user;
    }

    public void update(User user) {
        for(User fromDb : userList){
            if(fromDb.getId() == user.getId()){
                fromDb.setName(user.getName());
                fromDb.setAge(user.getAge());
                fromDb.setBookList(user.getBookList());
            }
        }
    }

    public void delete(User user) {
        userList.remove(user);
    }

    public User getById(long id) {
        for(User user : userList){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }

    public List<User> getAll() {
        List<User> users;
        users = userList;
        return users;
    }
}
