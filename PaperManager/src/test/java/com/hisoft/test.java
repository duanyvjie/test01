package com.hisoft;

import com.hisoft.papermanager.dao.paper.PaperMapper;
import com.hisoft.papermanager.pojo.Paper;
import com.hisoft.papermanager.service.paper.PaperService;
import com.hisoft.papermanager.service.paper.PaperServiceImpl;
import com.hisoft.papermanager.service.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: MyProject
 * @description:
 * @author: dyj
 * @create: 2020-09-09 10:45:20
 **/
public class test {
    PaperService paperService = new PaperServiceImpl();
    @Autowired
    private UserService userService;

    @Test
    public void test01(){
        System.out.println(paperService);
        List<Paper> paperList = paperService.getPaperList("", 1, 0, 3);
        /*List<Paper> paperList = paperMapper.getPaperList("", 1, 0, 3);*/
        System.out.println(paperList);
    }
}
