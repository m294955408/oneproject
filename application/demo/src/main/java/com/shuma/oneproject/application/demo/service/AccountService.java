package com.shuma.oneproject.application.demo.service;

import com.shuma.oneproject.application.Service;
import com.shuma.oneproject.application.demo.dto.AccountDTO;
import com.shuma.oneproject.domain.demo.aggregate.Account;

/**
 * 账户服务接口
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
public interface AccountService extends Service<Account, AccountDTO> {

}
