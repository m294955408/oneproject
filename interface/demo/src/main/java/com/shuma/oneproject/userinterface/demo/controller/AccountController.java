package com.shuma.oneproject.userinterface.demo.controller;

import com.shuma.oneproject.application.demo.dto.AccountDTO;
import com.shuma.oneproject.domain.demo.aggregate.Account;
import com.shuma.oneproject.userinterface.controller.ApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户服务接口
 *
 * @author 马文韬
 * @version 1.0
 * @date: 2019/2/11
 */
@RestController
@RequestMapping ("/account")
public class AccountController extends ApiController<Account, AccountDTO> {

}
