package com.shuma.oneproject.domain.demo.aggregate;

import com.shuma.oneproject.domain.EntityFactory;
import org.springframework.stereotype.Component;

/**
 * 地址工厂
 *
 * @author 马文韬
 * @version 1.0
 * @date 2019/2/11
 */
@Component
public class AddressFactory implements EntityFactory<Address> {

    @Override
    public Address create() {
        return new Address();
    }

}
