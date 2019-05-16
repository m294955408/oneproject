package com.shuma.oneproject.userinterface.common.authority;

import com.shuma.oneproject.userinterface.common.HttpSessionKeyConstant;
import org.springframework.util.Assert;

import javax.servlet.http.HttpSession;

/**
 * 权限工具类
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/5/14
 */
public final class AuthorityUtils {

    /**
     * 用户登录
     *
     * @param session SESSION
     * @param loginUser 登录用户信息
     */
    public static void login (HttpSession session, String loginUser) {
        Assert.notNull(session, "session is null!");
        Assert.notNull(loginUser, "login user is null!");

        session.setAttribute(HttpSessionKeyConstant.LOGIN_USER, loginUser);
    }

}
