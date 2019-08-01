package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping(value = "test")
    public String test(Boolean bool) {

        if (bool) {
            throw new BusinessException("报错了");
        }

        return "aabbcc";
    }
}
