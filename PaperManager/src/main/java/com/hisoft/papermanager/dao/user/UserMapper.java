package com.hisoft.papermanager.dao.user;

import com.hisoft.papermanager.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * @program: MyProject
 * @description:
 * @author: dyj
 * @create: 2020-09-08 19:18:30
 **/
public interface UserMapper {
    User login(@Param("userName") String userName);
}
