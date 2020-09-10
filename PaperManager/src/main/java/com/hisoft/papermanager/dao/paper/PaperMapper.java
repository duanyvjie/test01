package com.hisoft.papermanager.dao.paper;

import com.hisoft.papermanager.pojo.Code;
import com.hisoft.papermanager.pojo.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperMapper {

    List<Paper> getPaperList(@Param("title") String title,
                             @Param("type") Integer type,
                             @Param("from") Integer from,
                             @Param("pageSize") Integer pageSize);

    Integer getPaperCount(@Param("title") String title,
                          @Param("type") Integer type);

    List<Code> getCodeList ();
    Integer add(Paper paper);
    Paper getPaperById(Integer id);
    Integer modify(Paper paper);
    Integer delelte(Integer id);
    Paper getPaperByTitle(String title);
}
