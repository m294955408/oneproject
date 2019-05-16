package com.shuma.oneproject.domain.demo.aggregate;

import com.shuma.oneproject.domain.AbstractEntityLong;
import lombok.Data;

/**
 * 地址聚合根
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
@Data
public class Address extends AbstractEntityLong {

    /**
     * 国家
     */
    private String country;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

}
