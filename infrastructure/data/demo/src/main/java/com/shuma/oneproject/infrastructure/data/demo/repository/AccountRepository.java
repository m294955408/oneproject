package com.shuma.oneproject.infrastructure.data.demo.repository;

import com.shuma.oneproject.domain.UnitOfWork;
import com.shuma.oneproject.domain.demo.aggregate.Account;
import com.shuma.oneproject.infrastructure.data.AbstractRepository;
import org.springframework.stereotype.Repository;

/**
 * 账户仓储
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
@Repository
public class AccountRepository extends AbstractRepository<Account> {

    @Override
    public UnitOfWork getUnitOfWork() {
        return null;
    }

    @Override
    protected Class<Account> getEntityClass() {
        return null;
    }
}
