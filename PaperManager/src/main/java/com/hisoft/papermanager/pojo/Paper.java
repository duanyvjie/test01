package com.hisoft.papermanager.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @program: MyProject
 * @description:
 * @author: dyj
 * @create: 2020-09-08 18:49:31
 **/
@Data
public class Paper {
    private Integer id;
    @NotEmpty(message = "论文题目不能为空")
    private String title;
    private  Integer type;
    @NotEmpty(message = "论文摘要不能为空")
    private  String paperSummary;
    private  String paperPath;
    private  String createdBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date creationDate;
    private String modifyBy;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date modifyDate;
    private String fileName;

    private String author;
}
