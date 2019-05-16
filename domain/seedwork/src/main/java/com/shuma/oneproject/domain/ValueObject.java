package com.shuma.oneproject.domain;

import java.lang.reflect.Field;
import java.util.stream.Stream;

/**
 * 值对象
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/1/31
 */
public class ValueObject<T extends ValueObject<T>> {

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ValueObject)) {
            return false;
        }
        else {
            return equals((ValueObject)obj);
        }
    }

    public boolean equals(ValueObject other) {
        if (other == this) {
            return true;
        }

        if (other == null) {
            return false;
        }

        Field[] publicFileds = this.getClass().getDeclaredFields();
        Stream<Field> publicFieldsStream = Stream.of(publicFileds);
        return publicFieldsStream.allMatch(field -> {
            field.setAccessible(true);
            Object left = null;
            Object right = null;
            try {
                left = field.get(this);
                right = field.get(other);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            if (left == null && right == null) {
                return true;
            } else if(left == null || right == null) {
                return false;
            } else {
                return left.equals(right);
            }
        });
    }

    @Override
    public int hashCode() {
        int hashCode = 31;
        boolean changeMultiplier = false;
        int index = 1;

        Field[] publicFileds = this.getClass().getFields();
        for (Field field:
                publicFileds) {
            Object value = null;
            field.setAccessible(true);
            try {
                value = field.get(this);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if(value != null) {
                hashCode = hashCode * ((changeMultiplier) ? 59 : 114) + value.hashCode();

                changeMultiplier = !changeMultiplier;
            }
            else {
                hashCode = hashCode ^ (index * 13);
            }
        }

        return hashCode;
    }
}
