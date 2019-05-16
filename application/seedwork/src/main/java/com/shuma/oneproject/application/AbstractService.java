package com.shuma.oneproject.application;

import com.shuma.oneproject.domain.Entity;
import com.shuma.oneproject.domain.Repository;
import com.shuma.oneproject.infrastructure.exception.NotImplementedException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Service 基类
 *
 * @author 马文韬
 * @version 1.0
 * @date: 2018/11/15
 */
@org.springframework.stereotype.Service
public abstract class AbstractService<TEntity extends Entity, TEntityDTO> implements Service<TEntity, TEntityDTO> {

    @Autowired
    private Repository<TEntity> repository;

    public TEntity addByEntity(TEntity item) {
        if (item != null) {
            repository.insert(item);
            repository.getUnitOfWork().commit();
        }

        return item;
    }

    public TEntityDTO addByEntityDTO(TEntityDTO item) {
        if (item != null) {
            TEntity entity = createEntity();
            BeanUtils.copyProperties(item, entity);
            repository.insert(entity);
            repository.getUnitOfWork().commit();
            BeanUtils.copyProperties(entity, item);
        }

        return item;
    }

    public Collection<TEntity> addByEntity(Collection<TEntity> items) {
        if (!CollectionUtils.isEmpty(items)) {
            repository.insert(items);
            repository.getUnitOfWork().commit();
        }

        return items;
    }

    public List<TEntityDTO> addByEntityDTO(List<TEntityDTO> items) {
        if (!CollectionUtils.isEmpty(items)) {
            List<TEntity> entities = new ArrayList<>();
            items.forEach(item -> {
                TEntity entity = createEntity();
                BeanUtils.copyProperties(item, entity);
                entities.add(entity);
            });
            repository.insert(entities);
            repository.getUnitOfWork().commit();
            for (int i = 0; i < entities.size(); i++) {
                TEntity entity = entities.get(i);
                TEntityDTO item = items.get(i);
                BeanUtils.copyProperties(entity, item);
            }
        }

        return items;
    }

    public void removeByEntity(TEntity item) {
        if (item != null) {
            repository.delete(item);
            repository.getUnitOfWork().commit();
        }
    }

    public void removeByEntityDTO(TEntityDTO item) {
        if (item != null) {
            TEntity entity = createEntity();
            BeanUtils.copyProperties(item, entity);
            repository.delete(entity);
            repository.getUnitOfWork().commit();
        }
    }

    public void removeById(Object id) {
        if (id != null) {
            TEntity entity = repository.get(id);
            if (entity != null) {
                repository.delete(entity);
                repository.getUnitOfWork().commit();
            }
        }
    }

    public void removeByEntity(Collection<TEntity> items) {
        if (items != null && items.size() > 0) {
            repository.delete(items);
            repository.getUnitOfWork().commit();
        }
    }

    public void removeByEntityDTO(List<TEntityDTO> items) {
        if (!CollectionUtils.isEmpty(items)) {
            Collection<TEntity> entities = new ArrayList<>();
            items.forEach(item -> {
                TEntity entity = createEntity();
                BeanUtils.copyProperties(item, entity);
                entities.add(entity);
            });
            repository.delete(entities);
            repository.getUnitOfWork().commit();
        }
    }

    public void removeByIds(Collection<Object> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            ids.forEach(this::removeById);
        }
    }

    public TEntity modifyByEntity(TEntity item) {
        if (item != null) {
            repository.update(item);
            repository.getUnitOfWork().commit();
        }
        return item;
    }

    @Override
    public TEntity modifyByEntity(Object id, TEntity item) {
        if (item == null) {
            item = createEntity();
        }
        item.setId(id);
        repository.update(item);
        repository.getUnitOfWork().commit();
        return item;
    }

    public TEntityDTO modifyByEntityDTO(TEntityDTO item) {
        if (item != null) {
            TEntity entity = createEntity();
            BeanUtils.copyProperties(item, entity);
            repository.update(entity);
            repository.getUnitOfWork().commit();
        }
        return item;
    }

    @Override
    public TEntityDTO modifyByEntityDTO(Object id, TEntityDTO item) {
        TEntity entity = createEntity();
        if (item != null) {
            BeanUtils.copyProperties(item, entity);
            entity.setId(id);
            repository.update(entity);
            repository.getUnitOfWork().commit();
            BeanUtils.copyProperties(entity, item);
        }
        return item;
    }

    public Collection<TEntity> modifyByEntity(Collection<TEntity> items) {
        if (!CollectionUtils.isEmpty(items)) {
            repository.update(items);
            repository.getUnitOfWork().commit();
        }
        return items;
    }

    public List<TEntityDTO> modifyByEntityDTO(List<TEntityDTO> items) {
        if (!CollectionUtils.isEmpty(items)) {
            Collection<TEntity> entities = new ArrayList<>();
            items.forEach(item -> {
                TEntity entity = createEntity();
                BeanUtils.copyProperties(item, entity);
                entities.add(entity);
            });
            repository.update(entities);
            repository.getUnitOfWork().commit();
        }
        return items;
    }

    @Override
    public TEntity get(Object id) {
        return repository.get(id);
    }

    @Override
    public TEntityDTO getDTO(Object id) {
        TEntityDTO entityDTO = createEntityDTO();
        TEntity entity = repository.get(id);
        if (entity != null) {
            BeanUtils.copyProperties(entity, entityDTO);
        }
        return entityDTO;
    }

    @Override
    public Collection<TEntity> getAll() {
        return repository.getAll();
    }

    @Override
    public List<TEntityDTO> getAllDTO() {
        List<TEntityDTO> entityDTOS = new ArrayList<>();
        Collection<TEntity> entities = repository.getAll();
        if (!CollectionUtils.isEmpty(entities)) {
            entities.forEach(entity -> {
                TEntityDTO entityDTO = createEntityDTO();
                BeanUtils.copyProperties(entity, entityDTO);
                entityDTOS.add(entityDTO);
            });
        }
        return entityDTOS;
    }

    /**
     * 创建实体
     */
    protected abstract TEntity createEntity();

    /**
     * 创建实体对应的数据传输对象
     */
    protected abstract TEntityDTO createEntityDTO();

}
