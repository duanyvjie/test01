package com.hisoft.papermanager.pojo;

import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;

/**
 * @program: MyProject
 * @description:
 * @author: dyj
 * @create: 2020-09-08 18:02:22
 **/
@Data
public class User {
    private Integer id;
    private String userCode;
    private String userName;
    private String userPassword;
    private Integer gender;
    private Date birthday;
    private String phone;
    private String address;
    private Integer userRole;
    private Integer paperNum;
    private String createdBy;
    private Date creationDate;
    private String modifyBy;
    private Date modifyDate;
}
