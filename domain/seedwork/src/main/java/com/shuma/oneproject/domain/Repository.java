package com.shuma.oneproject.domain;

import java.util.Collection;

/**
 * 仓储接口
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/1/31
 */
public interface Repository<E extends Entity> {

    UnitOfWork getUnitOfWork();

    E get(Object id);

    Collection<E> getAll();

    void insert(E item);

    void insert(Collection<E> items);

    void delete(E item);

    void delete(Collection<E> items);

    void update(E item);

    void update(Collection<E> items);

}
