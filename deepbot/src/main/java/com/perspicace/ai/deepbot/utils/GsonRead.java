package com.perspicace.ai.deepbot.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.perspicace.ai.deepbot.nlu.model.NLUInputData;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class GsonRead {
    public NLUInputData getJson() throws IOException{
        File file = new File(GsonRead.class.getResource("/inputdata.json").getFile());
        String content = FileUtils.readFileToString(file);
//	    content = URLEncoder.encode(content, "UTF-8");         //避免文件编码错误
        Gson gson = new GsonBuilder().create();
        NLUInputData jsonRootBean = gson.fromJson(content, NLUInputData.class);
        return jsonRootBean;
    }
}
