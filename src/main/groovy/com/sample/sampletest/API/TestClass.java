package com.sample.sampletest.API;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestClass {

    @PostMapping("/test")
    public String testMethod(@RequestBody(required = false) Map<String,Object> map){

        return "test";

    }
}
