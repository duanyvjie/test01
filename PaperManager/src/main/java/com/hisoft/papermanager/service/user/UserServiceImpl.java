package com.hisoft.papermanager.service.user;

import com.hisoft.papermanager.dao.user.UserMapper;
import com.hisoft.papermanager.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: MyProject
 * @description:
 * @author: dyj
 * @create: 2020-09-08 20:10:59
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional(readOnly = true ,propagation = Propagation.SUPPORTS)
    public User getLoginUser(String userName) {
        User user = null;
        try {
            user = userMapper.login(userName);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }
        return user;
    }
}
