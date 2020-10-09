package com.elevenst.service.impl;

import com.elevenst.service.FeignProductRemoteService;
import org.springframework.stereotype.Component;

/**
 * @author Nick (km.oh@dreamus.io)
 * @created 2020-10-09
 */
@Component
public class ProductResourceFallback implements FeignProductRemoteService {

    @Override
    public String getProductInfo(String productId) {
        return "default value";
    }
}
