package com.shuma.oneproject.domain;

/**
 * 实体
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/1/31
 */
public interface Entity<T> {

    /**
     * 获取标识
     */
    T getId();

    /**
     * 设置标识
     */
    void setId(T id);

}
