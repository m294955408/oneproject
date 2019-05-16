package com.shuma.oneproject.domain;

/**
 * 实体工厂
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
public interface EntityFactory<TEntity extends Entity> {

    /**
     * 创建实体
     */
    TEntity create();

}
