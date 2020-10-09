package com.elevenst.service.impl;

import com.elevenst.service.ProductRemoteService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Nick (km.oh@dreamus.io)
 * @created 2020-10-07
 */
@Service
public class ProductRemoteServiceImpl implements ProductRemoteService {
    public static final String URL = "http://localhost:8082/products/";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getProductInfoFallback")
    public String getProductInfo(String productId) {
        return restTemplate.getForObject(URL+productId, String.class);
    }


    /**
     * Circuit Open이 된다면 해당 fallback 메서드는 실행되지 않고 RuntimeException이 바로 발생한다 . ( short-curcuited )
     */
    public String getProductInfoFallback(String productId , Throwable throwable){
        System.out.println("t = "+ throwable);
        return "[This product is sold out]";
    }
}
