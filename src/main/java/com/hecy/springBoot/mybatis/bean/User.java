package com.hecy.springBoot.mybatis.bean;

import lombok.Data;

/**
 * @Author: hecy
 * @Date: 2018/11/21 14:08
 * @Version 1.0
 */
@Data
public class User {


    private Integer id;

    private String user_name;

    private String password;

    @ValueAnnotation(10)
    private Integer age;

}
