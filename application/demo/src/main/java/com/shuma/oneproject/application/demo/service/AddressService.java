package com.shuma.oneproject.application.demo.service;

import com.shuma.oneproject.application.Service;
import com.shuma.oneproject.application.demo.dto.AddressDTO;
import com.shuma.oneproject.domain.demo.aggregate.Address;

/**
 * 地址服务接口
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
public interface AddressService extends Service<Address, AddressDTO> {

}
