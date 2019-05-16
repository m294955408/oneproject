package com.shuma.oneproject.application.demo.service.impl;

import com.shuma.oneproject.application.AbstractService;
import com.shuma.oneproject.application.demo.dto.AccountDTO;
import com.shuma.oneproject.application.demo.service.AccountService;
import com.shuma.oneproject.domain.demo.aggregate.Account;
import org.springframework.stereotype.Service;

/**
 * 账户服务接口实现
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
@Service
public class AccountServiceImpl extends AbstractService<Account, AccountDTO> implements AccountService {


    @Override
    protected Account createEntity() {
        return new Account();
    }

    @Override
    protected AccountDTO createEntityDTO() {
        return new AccountDTO();
    }
}
