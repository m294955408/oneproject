package com.shuma.oneproject.domain.demo.aggregate;

import com.shuma.oneproject.domain.AbstractEntityLong;
import lombok.Data;

/**
 * 账户聚合根
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
@Data
public class Account extends AbstractEntityLong {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
