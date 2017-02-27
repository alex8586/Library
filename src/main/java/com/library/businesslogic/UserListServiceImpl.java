package com.library.businesslogic;

import com.library.database.UserDao;
import com.library.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserListServiceImpl implements UserListService {

    private final static int USERS_ON_PAGE = 10;

    @Autowired
    private UserDao userDao;

    public Map<String, Object> getUserList(int pageNumber){
        List<User> userList = userDao.getAll();
        PagedListHolder<User> pagedListHolder = new PagedListHolder<User>(userList);
        Map<String, Object> result = new HashMap<String, Object>();

        if(pageNumber > userList.size()/USERS_ON_PAGE){
            pagedListHolder.setPageSize(USERS_ON_PAGE);
            pagedListHolder.setPage(0);
            result.put("userList", pagedListHolder.getPageList());
            result.put("currentPage", 0);
            result.put("maxPage", pagedListHolder.getPageCount());
        }else {
            pagedListHolder.setPageSize(USERS_ON_PAGE);
            pagedListHolder.setPage(pageNumber);
            result.put("userList", pagedListHolder.getPageList());
            result.put("currentPage", pageNumber);
            result.put("maxPage", pagedListHolder.getPageCount());
        }
        return result;
    }
}
