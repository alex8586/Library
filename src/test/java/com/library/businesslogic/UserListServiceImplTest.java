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

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class UserListServiceImplTest {

    @Autowired
    private UserListServiceImpl userListService;

    @Autowired
    private UserDao userDao;

    @Test
    public void getUserListTest(){
        fillUserDatabase();
        int pageNumber = 0;
        Map<String, Object> map = userListService.getUserList(pageNumber);
        List<User> userList = (List<User>) map.get("userList");
        assertTrue(10 == userList.size());
    }

    private void fillUserDatabase(){
        for(int i = 0; i < 15; i++){
            User user = new User();
            user.setName("name " + i);
            user.setAge(20 + i);
            userDao.create(user);
        }
    }
}
