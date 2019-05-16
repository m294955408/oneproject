package com.shuma.oneproject.domain;

/**
 * 实体标识为Long类型的抽象实体
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/1/31
 */
public abstract class AbstractEntityLong extends AbstractEntity implements Entity<Long> {

    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj instanceof AbstractEntityLong) {
            return equals((AbstractEntityLong)obj);
        } else {
            return false;
        }
    }

    private boolean equals(AbstractEntityLong other) {
        if (this == other) {
            return true;
        }

        if (other == null) {
            return false;
        }

        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
