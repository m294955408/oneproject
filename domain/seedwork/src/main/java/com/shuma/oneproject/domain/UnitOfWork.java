package com.shuma.oneproject.domain;

import java.util.Collection;

/**
 * 工作单元
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/1/31
 */
public interface UnitOfWork<E> {

    E selectByPrimaryKey(Object id, Class<E> clazz);

    Collection<E> selectAll(Class<E> clazz);

    void insert(E entity);

    void delete(E entity);

    void update(E entity);

    /**
     * 提交所有变更
     */
    void commit();

    /**
     * 回滚所有变更
     */
    void rollback();

}
