package com.shuma.oneproject.domain;

import java.util.UUID;

/**
 * 标识为UUID的抽象实体
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/1/31
 */
public abstract class AbstractEntityUUID extends AbstractEntity implements Entity<UUID> {

    private UUID id;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj instanceof AbstractEntityUUID) {
            AbstractEntityUUID other = (AbstractEntityUUID)obj;
            return other.id.equals(this.id);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.id.hashCode() ^ 31;
    }
}
