package com.elevenst.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nick (km.oh@dreamus.io)
 * @created 2020-10-07
 */

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/{productId}")
    public String getProduct(@PathVariable String productId){
        System.out.println("/products/"+productId + "called:");
        return "[product id = "+productId +" at "+System.currentTimeMillis() + "]";
    }

}
