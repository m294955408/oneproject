package com.shuma.oneproject.application;

import com.shuma.oneproject.domain.Entity;

import java.util.Collection;
import java.util.List;

/**
 *
 *
 * @author 马文韬
 * @version 1.0
 * @date: 2018/9/21
 */
public interface Service<TEntity extends Entity, TEntityDTO> {

    TEntity addByEntity(TEntity item);
    TEntityDTO addByEntityDTO(TEntityDTO item);

    Collection<TEntity> addByEntity(Collection<TEntity> items);
    List<TEntityDTO> addByEntityDTO(List<TEntityDTO> items);

    void removeByEntity(TEntity item);
    void removeByEntityDTO(TEntityDTO item);
    void removeById(Object id);

    void removeByEntity(Collection<TEntity> items);
    void removeByEntityDTO(List<TEntityDTO> items);
    void removeByIds(Collection<Object> ids);

    TEntity modifyByEntity(TEntity item);
    TEntity modifyByEntity(Object id, TEntity item);
    TEntityDTO modifyByEntityDTO(TEntityDTO item);
    TEntityDTO modifyByEntityDTO(Object id, TEntityDTO item);

    Collection<TEntity> modifyByEntity(Collection<TEntity> items);
    List<TEntityDTO> modifyByEntityDTO(List<TEntityDTO> items);

    TEntity get(Object id);
    TEntityDTO getDTO(Object id);

    Collection<TEntity> getAll();
    List<TEntityDTO> getAllDTO();

}
