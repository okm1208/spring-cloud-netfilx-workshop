package com.elevenst.service;

import com.elevenst.service.impl.FeignProductRemoteServiceFallbackFactory;
import com.elevenst.service.impl.ProductResourceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Nick (km.oh@dreamus.io)
 * @created 2020-10-09
 */

@FeignClient(name="product", fallbackFactory = FeignProductRemoteServiceFallbackFactory.class)
public interface FeignProductRemoteService {
    @RequestMapping(path="/products/{productId}")
    String getProductInfo(@PathVariable("productId") String productId);
}
