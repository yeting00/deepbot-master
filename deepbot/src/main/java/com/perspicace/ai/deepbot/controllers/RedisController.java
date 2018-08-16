package com.perspicace.ai.deepbot.controllers;

import com.perspicace.ai.deepbot.repository.RedisRepository;
import com.perspicace.ai.deepbot.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: deepbot
 * @description:
 * @author: Destiny
 * @create: 2018-06-26 20:02
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {
    private final RedisRepository redisRepository;

    @Autowired
    public RedisController(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }

    @RequestMapping(value = "get/{key}", method = RequestMethod.GET)
    public Result<String> find(@PathVariable("key") String key) {
        String value =(String) redisRepository.get(key);
        return new Result<>(value);
    }
}
