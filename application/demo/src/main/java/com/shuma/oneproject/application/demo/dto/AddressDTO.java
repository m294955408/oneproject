package com.shuma.oneproject.application.demo.dto;

import lombok.Data;

/**
 * 地址数据传输对象
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
@Data
public class AddressDTO {

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
