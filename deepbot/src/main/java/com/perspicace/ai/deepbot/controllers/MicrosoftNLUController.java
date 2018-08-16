package com.perspicace.ai.deepbot.controllers;

import com.perspicace.ai.deepbot.nlu.service.impl.AzureNLUServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by destiny
 * on 2018/6/22.
 */

@RestController
public class MicrosoftNLUController {
    @Autowired
    private AzureNLUServiceImpl azureNLUService;

    @RequestMapping("getAzureIntent")
    public void test() throws Exception {
    }
}
