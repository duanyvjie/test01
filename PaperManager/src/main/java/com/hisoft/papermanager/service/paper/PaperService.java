package com.hisoft.papermanager.service.paper;

import com.hisoft.papermanager.pojo.Code;
import com.hisoft.papermanager.pojo.Paper;

import java.util.List;

/**
 * @program: MyProject
 * @description:
 * @author: dyj
 * @create: 2020-09-09 10:41:37
 **/
public interface PaperService {

    public List<Paper> getPaperList(String title, Integer type, Integer from, Integer pageSize);

    public Integer getPaperCount(String title, Integer type);

    List<Code> getCodeList();

    public boolean add(Paper paper);

    Paper getPaperById(Integer id);

    boolean modify(Paper paper);

    boolean delelte(Integer id);

    Paper getPaperByTitle(String title);
}
