package com.shuma.oneproject.infrastructure.data.mybaits;

import com.shuma.oneproject.domain.Entity;
import com.shuma.oneproject.domain.UnitOfWork;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Mybatis 工作单元基类
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/5/9
 */
@Slf4j
public abstract class AbstractMybatisUnitOfWork<E extends Entity, D> implements UnitOfWork<E> {

    @Autowired
    SqlSession sqlSession;

    @Override
    public E selectByPrimaryKey(Object id, Class<E> clazz) {
        String statement = getMapperName() + ".selectByPrimaryKey";
        E entity = createEntity();
        D obj = sqlSession.selectOne(statement, id);
        if (null != obj) {
            convertEntity(obj, entity);
        }
        return entity;
    }

    @Override
    public Collection<E> selectAll(Class<E> clazz) {
        String statement = getMapperName() + ".selectByExample";
        Collection<E> entities = new ArrayList<>();
        Collection<D> objs = sqlSession.selectList(statement, null);
        if (!CollectionUtils.isEmpty(objs)) {
            objs.forEach(obj -> {
                E entity = createEntity();
                convertEntity(obj, entity);
                entities.add(entity);
            });
        }
        return entities;
    }

    @Override
    public void insert(E entity) {
        String statement = getMapperName() + ".insertSelective";
        if (null != entity) {
            D entityDO = createDO();
            convertDO(entity, entityDO);
            sqlSession.insert(statement, entityDO);
            convertEntity(entityDO, entity);
        }
    }

    @Override
    public void delete(E entity) {
        String statement = getMapperName() + ".deleteByPrimaryKey";
        sqlSession.delete(statement, entity.getId());
    }

    @Override
    public void update(E entity) {
        String statement = getMapperName() + ".updateByPrimaryKeySelective";
        if (null != entity) {
            D entityDO = createDO();
            convertDO(entity, entityDO);
            Method setGmtModifiedMethod = BeanUtils.findMethod(entityDO.getClass(), "setGmtModified", Date.class);
            if (null != setGmtModifiedMethod) {
                try {
                    setGmtModifiedMethod.invoke(entityDO, new Date());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    log.warn("设置更新日期出错：{}", e.getMessage(), e);
                }
            }
            sqlSession.update(statement, entityDO);
        }
    }

    @Override
    public void commit() {
        // Mybatis 自动提交，无需控制
    }

    @Override
    public void rollback() {
        sqlSession.rollback();
    }

    private String getMapperName() {
        return getMapper().getName();
    }

    protected void convertEntity(D dataObject, E targetEntity) {
        BeanUtils.copyProperties(dataObject, targetEntity);
    }

    protected void convertDO(E entity, D targetDO) {
        BeanUtils.copyProperties(entity, targetDO);
    }

    protected abstract Class<?> getMapper();

    protected abstract D createDO();

    protected abstract E createEntity();

    protected E getEntityFromDOS(List<D> dataObjects) {
        if (!CollectionUtils.isEmpty(dataObjects)) {
            if (dataObjects.size() > 1) {
                log.warn ("数据库中存在多个：{}", dataObjects);
            }
            E entity = createEntity();
            convertEntity(dataObjects.get(0), entity);
            return entity;
        }
        return  null;
    }

}
