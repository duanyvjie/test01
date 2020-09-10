package com.hisoft.papermanager.service.paper;

import com.hisoft.papermanager.dao.paper.PaperMapper;
import com.hisoft.papermanager.pojo.Code;
import com.hisoft.papermanager.pojo.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: MyProject
 * @description:
 * @author: dyj
 * @create: 2020-09-09 10:42:59
 **/
@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public List<Paper> getPaperList(String title, Integer type, Integer from, Integer pageSize) {
        List<Paper> paperList = null;
        try {
            paperList = paperMapper.getPaperList(title, type, (from - 1) * pageSize, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return paperList;
    }

    @Override
    public Integer getPaperCount(String title, Integer type) {
        int count = 0;
        try {
            count = paperMapper.getPaperCount(title, type);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return count;
    }

    @Override
    public List<Code> getCodeList() {
        List<Code> coderList = null;
        try {
            coderList = paperMapper.getCodeList();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return coderList;
    }

    @Override
    public boolean add(Paper paper) {
        boolean flag = false;
        try {
            int result = paperMapper.add(paper);
            if (result > 0) {
                flag = true;
                System.out.println("add success!");
            } else {
                System.out.println("add failed!");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("rollback==================");
            throw e;
        }
        return flag;
    }

    @Override
    public Paper getPaperById(Integer id) {
        Paper paper = null;

        try {
            paper = paperMapper.getPaperById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return paper;
    }

    @Override
    public boolean modify(Paper paper) {
        boolean flag = false;
        try {
            if (paperMapper.modify(paper) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return flag;
    }

    @Override
    public boolean delelte(Integer id) {
        boolean flag = false;
        try {
            if (paperMapper.delelte(id) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return flag;
    }

    @Override
    public Paper getPaperByTitle(String title) {
        Paper paper = null;
        try {
            paper = paperMapper.getPaperByTitle(title);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return paper;
    }


}
