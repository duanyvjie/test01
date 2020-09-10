package com.hisoft.papermanager.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @program: MyProject
 * @description:
 * @author: dyj
 * @create: 2020-09-08 18:52:26
 **/
@Data
public class Code {
    private Integer id;
    private String code;
    private String codeName;
    private String codeTypeName;
    private String parCode;
    private Integer sequenceNum;
    private String createdBy;
    private Date creationDate;
    private String modifyBy;
    private Date modifyDate;
}
