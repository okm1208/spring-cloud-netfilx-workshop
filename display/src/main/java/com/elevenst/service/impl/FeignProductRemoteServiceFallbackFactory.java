package com.elevenst.service.impl;

import com.elevenst.service.FeignProductRemoteService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Nick (km.oh@dreamus.io)
 * @created 2020-10-09
 */
@Component
public class FeignProductRemoteServiceFallbackFactory implements FallbackFactory<FeignProductRemoteService> {

    @Override
    public FeignProductRemoteService create(Throwable cause) {
        System.out.println("t = "+cause);
        return productId -> "[This product sold out.]";
    }
}
