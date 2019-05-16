package com.shuma.oneproject.domain;

import java.time.LocalDateTime;

/**
 * 可审计实体
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/1/31
 */
public interface AuditableEntity {

    /**
     * 获取创建用户
     */
    String getCreatedUser();

    /**
     * 获取创建时间
     */
    LocalDateTime getCreatedTime();

    /**
     * 获取最近一次修改用户
     */
    String getLastModifiedUser();

    /**
     * 获取最近一次修改时间
     */
    LocalDateTime getLastModifiedTime();

}
