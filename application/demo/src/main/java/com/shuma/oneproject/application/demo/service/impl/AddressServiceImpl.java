package com.shuma.oneproject.application.demo.service.impl;

import com.shuma.oneproject.application.AbstractService;
import com.shuma.oneproject.application.demo.dto.AddressDTO;
import com.shuma.oneproject.application.demo.service.AddressService;
import com.shuma.oneproject.domain.demo.aggregate.Address;
import org.springframework.stereotype.Service;

/**
 * 地址服务接口实现
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
@Service
public class AddressServiceImpl extends AbstractService<Address, AddressDTO> implements AddressService {


    @Override
    protected Address createEntity() {
        return null;
    }

    @Override
    protected AddressDTO createEntityDTO() {
        return null;
    }
}
