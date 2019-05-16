package com.shuma.oneproject.application.demo.dto;

import lombok.Data;

/**
 * 账户数据传输对象
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
@Data
public class AccountDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
