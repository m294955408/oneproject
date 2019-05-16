package com.shuma.oneproject.infrastructure.data;

import com.shuma.oneproject.domain.Entity;
import com.shuma.oneproject.domain.Repository;
import com.shuma.oneproject.domain.UnitOfWork;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * 仓储基类
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
public abstract class AbstractRepository<TEntity extends Entity> implements Repository<TEntity> {

    @Override
    public abstract UnitOfWork getUnitOfWork();

    @Override
    public TEntity get(Object id) {
        return (TEntity) getUnitOfWork().selectByPrimaryKey(id, getEntityClass());
    }

    @Override
    public Collection<TEntity> getAll() {
        return getUnitOfWork().selectAll(getEntityClass());
    }

    @Override
    public void insert(TEntity item) {
        getUnitOfWork().insert(item);
        getUnitOfWork().commit();
    }

    @Override
    public void insert(Collection<TEntity> items) {
        if (!CollectionUtils.isEmpty(items)) {
            items.forEach(item -> getUnitOfWork().insert(item));
            getUnitOfWork().commit();
        }
    }

    @Override
    public void delete(TEntity item) {
        getUnitOfWork().delete(item);
        getUnitOfWork().commit();
    }

    @Override
    public void delete(Collection<TEntity> items) {
        if (!CollectionUtils.isEmpty(items)) {
            items.forEach(item -> getUnitOfWork().delete(item));
            getUnitOfWork().commit();
        }
    }

    @Override
    public void update(TEntity item) {
        getUnitOfWork().update(item);
        getUnitOfWork().commit();
    }

    @Override
    public void update(Collection<TEntity> items) {
        if (!CollectionUtils.isEmpty(items)) {
            items.forEach(item -> getUnitOfWork().update(item));
            getUnitOfWork().commit();
        }
    }

    protected abstract Class<TEntity> getEntityClass();

}
