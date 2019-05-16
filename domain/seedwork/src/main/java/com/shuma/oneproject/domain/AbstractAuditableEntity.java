package com.shuma.oneproject.domain;

import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 抽象可审计实体
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/1/31
 */
public abstract class AbstractAuditableEntity extends AbstractEntity implements AuditableEntity {

    @Setter
    private String createUser;

    @Setter
    private LocalDateTime createdTime;

    @Setter
    private String lastModifiedUser;

    @Setter
    private LocalDateTime lastModifiedTime;

    @Override
    public String getCreatedUser() {
        return this.createUser;
    }

    @Override
    public LocalDateTime getCreatedTime() {
        return this.createdTime;
    }

    @Override
    public String getLastModifiedUser() {
        return this.lastModifiedUser;
    }

    @Override
    public LocalDateTime getLastModifiedTime() {
        return this.lastModifiedTime;
    }
}
