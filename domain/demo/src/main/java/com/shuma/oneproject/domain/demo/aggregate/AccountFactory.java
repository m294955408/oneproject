package com.shuma.oneproject.domain.demo.aggregate;

import com.shuma.oneproject.domain.EntityFactory;
import org.springframework.stereotype.Component;

/**
 * 账户聚合根工厂
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
@Component
public class AccountFactory implements EntityFactory<Account> {

    @Override
    public Account create() {
        return new Account();
    }

}
