package com.library.businesslogic;

import com.library.config.Application;
import com.library.database.UserDao;
import com.library.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class UserServiceImplTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void getUserTest(){
        User user = createUserInDatabase();
        Map<String, Object> map = userService.getUser(user.getId());
        User fromMap = (User) map.get("user");
        compareUsers(user, fromMap);
    }

    @Test
    public void createUserTest(){
        List<User>userList = userDao.getAll();
        int beforeSize = userList.size();

        User user = new User();
        user.setName("new user");
        user.setAge(33);
        User fromDao = userDao.create(user);

        List<User> afterCreating = userDao.getAll();
        int afterSize = afterCreating.size();
        assertEquals(user.getName(), fromDao.getName());
        assertTrue(user.getAge() == fromDao.getAge());
        assertTrue(beforeSize < afterSize);
    }

    @Test
    public void updateUserDetailsTest(){
        User user = createUserInDatabase();
        user.setName("new name");
        user.setAge(100);
        userDao.update(user);

        User updated = userDao.getById(user.getId());
        compareUsers(user, updated);
    }

    @Test
    public void deleteUserTest(){
        User user = createUserInDatabase();
        long userId = user.getId();
        assertNotNull(user);

        userDao.delete(user);
        User fromDb = userDao.getById(userId);
        assertNull(fromDb);
    }

    private void compareUsers(User created, User fromDb){
        assertTrue(created.getId() == fromDb.getId());
        assertEquals(created.getName(), fromDb.getName());
        assertTrue(created.getAge() == fromDb.getAge());
    }

    private User createUserInDatabase(){
        User user = new User();
        user.setName("Anton");
        user.setAge(23);
        return userDao.create(user);
    }
}
