package com.elevenst.api;

import com.elevenst.service.FeignProductRemoteService;
import com.elevenst.service.ProductRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/displays")
public class DisplayController {


    @Autowired
    private ProductRemoteService productRemoteService;

    @Autowired
    private FeignProductRemoteService feignProductRemoteService;

    @GetMapping(path = "/{displayId}")
    public String getDisplayDetail(@PathVariable String displayId) {
//        String productInfo = productRemoteService.getProductInfo("1111");
        String productInfo = feignProductRemoteService.getProductInfo("1111");
        return String.format("[display id = %s at %s %s ]", displayId, System.currentTimeMillis(), productInfo);
    }
}