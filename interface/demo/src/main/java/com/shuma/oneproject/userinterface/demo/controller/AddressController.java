package com.shuma.oneproject.userinterface.demo.controller;

import com.shuma.oneproject.application.demo.dto.AddressDTO;
import com.shuma.oneproject.domain.demo.aggregate.Address;
import com.shuma.oneproject.userinterface.controller.ApiController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 地址服务接口
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
@RestController
@RequestMapping ("/address")
public class AddressController extends ApiController<Address, AddressDTO> {
}
