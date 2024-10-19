package org.apache.dubbo.springboot.demo.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.springboot.demo.idl.CategoryRequest;
import org.apache.dubbo.springboot.demo.idl.CategoryResponse;
import org.apache.dubbo.springboot.demo.idl.Greeter;
import org.apache.dubbo.springboot.demo.idl.GreeterReply;
import org.apache.dubbo.springboot.demo.idl.GreeterRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @DubboReference
    private Greeter greeter;

    @GetMapping("/test/{id}")
    public String test(@PathVariable("id") String id) {
        GreeterReply result = greeter.greet(GreeterRequest.newBuilder().setName(id).build());
        System.out.println("Received result ======> " + result.getMessage());
        return result.getMessage();
    }

    @GetMapping("/cat/{id}")
    public String cat(@PathVariable("id") String id) {
        CategoryResponse result = greeter.getCategory(CategoryRequest.newBuilder().setName(id).build());
        System.out.println("Received result ======> " + result.getName() + " " + result.getType());
        return result.getName();
    }
}
