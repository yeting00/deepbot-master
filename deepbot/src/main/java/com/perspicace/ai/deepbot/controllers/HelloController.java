package com.perspicace.ai.deepbot.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    @Value("${test.name}")
    private String name;
    @Value("${test.birthday}")
    private String birthday;

    @RequestMapping("/getdate")
    public String show()
    {
        return this.birthday;
    }


}
