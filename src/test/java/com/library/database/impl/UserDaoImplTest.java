package com.library.database.impl;

import com.library.config.Application;
import com.library.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class UserDaoImplTest {

    @Autowired
    private UserDaoImpl userDao;

    @Test
    public void createUserTest(){
        int listSize = userDao.getAll().size();

        User user = new User();
        user.setName("user");
        user.setAge(23);

        User fromDao = userDao.create(user);
        assertTrue(listSize < userDao.getAll().size());
        assertEquals(user.getName(),fromDao.getName());
        assertTrue(user.getAge() == fromDao.getAge());
        assertNotNull(fromDao.getId());
    }

    @Test
    public void updateUserTest(){
        User user = createUserInDao();
        long userId = user.getId();
        user.setName("other name");
        user.setAge(1);

        userDao.update(user);
        User fromDao = userDao.getById(userId);
        assertTrue(userId == fromDao.getId());
        assertEquals("other name", fromDao.getName());
        assertTrue(1 == fromDao.getAge());
    }

    @Test
    public void deleteUserTest(){
        User user = createUserInDao();
        long userId = user.getId();
        userDao.delete(user);

        assertNull(null, userDao.getById(userId));
    }

    @Test
    public void getByIdTest(){
        User user = createUserInDao();
        long userId = user.getId();

        User fromDao = userDao.getById(userId);
        assertTrue(userId == fromDao.getId());
        assertEquals(user.getName(), fromDao.getName());
        assertTrue(user.getAge() == fromDao.getAge());
    }

    private User createUserInDao(){
        User user = new User();
        user.setName("Artem");
        user.setAge(45);
        return userDao.create(user);
    }

}
