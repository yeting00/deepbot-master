package com.perspicace.ai.deepbot.utils;

import com.perspicace.ai.common.constant.Constant;
import com.perspicace.ai.common.constant.HeaderType;
import com.perspicace.ai.common.exception.CustomerException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author energy
 * @version http工具类
 **/
@Component
@Slf4j
public class HttpClientUtil {
    private static HttpClientUtil httpClientUtil;

    public synchronized static HttpClientUtil getInstance() {
        if (httpClientUtil == null) {
            httpClientUtil = new HttpClientUtil();
        }
        return httpClientUtil;
    }

    // 超时时间配置
    private RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(15000) // 数据传输超时
            .setConnectTimeout(15000) // 建立连接超时
            .setConnectionRequestTimeout(15000) // httputils clilent中从connetcion pool中获得一个connection的超时时间
            .build();

    public String sendHttpPost(String url, String content, HeaderType headerType, int retryTimes) throws CustomerException {
        if (retryTimes < 0) {
            retryTimes = 0;
        }

        String reStr = null;
        int retryIndex = 0;
        while (retryTimes >= 0) {
            try {
                reStr = sendHttpPost(url, content, headerType);
                break;
            } catch (CustomerException be) {
                boolean throwable = false;
                // 非200返回或者timeout进行重试
                if (be.errorNo == Constant.error100002 || be.errorNo == Constant.error100003) {
                    retryTimes--;
                    retryIndex++;

                    if (retryTimes < 0) {
                        throwable = true;
                    } else {
                        // 重试
                        System.out.println(be.getMessage() + " 正在重试第" + retryIndex + "次!");
                    }
                } else {
                    throwable = true;
                    be.printStackTrace();
                }

                if (throwable) {
                    throw new CustomerException(be.errorNo, "获取意图信息失败");
                }
            } catch (Exception e) {
                // 其他错误直接退出
                e.printStackTrace();
                break; // 如果去掉throw 此处需要break
            }
        }
        return reStr;
    }

    /**
     * 发送post请求
     *
     * @param url
     * @param content
     * @return
     */
    public String sendHttpPost(String url, String content, HeaderType headerType) throws CustomerException {
        HttpPost post = null;
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = null;
        String responseContent ;

        try {
            post = new HttpPost(url);
            httpClient = HttpClients.createDefault();
            post.setConfig(requestConfig);

            // 构造消息头
            switch (headerType) {
                case PERSPICACE_HEADER:
                    post.setHeader("Content-type", "application/json; charset=utf-8");
                    post.setHeader("Connection", "Close");
                    post.setHeader("app-key", "Strawberry");
                    break;
                case AZURE_HEADER:
                    post.setHeader("Content-type", "application/json; charset=utf-8");
                    post.setHeader("Accept", "text/html,application/json;q=0.9,*/*;q=0.8");
                    break;
                default:
                    post.setHeader("Content-type", "application/json; charset=utf-8");
                    post.setHeader("Connection", "Close");
                    post.setHeader("app-key", "Strawberry");
                    break;
            }
            // 构建消息实体
            StringEntity entity = new StringEntity(content, Charset.forName("UTF-8"));
            entity.setContentEncoding("UTF-8");
            // 发送Json格式的数据请求
            entity.setContentType("application/json");
            post.setEntity(entity);
            response = httpClient.execute(post);
            // 检验返回码
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                log.error("请求出错: " + statusCode + " url is " + url);
                throw new CustomerException(Constant.error100002, "post非正常返回");
            } else {
                HttpEntity rentity = response.getEntity();
                responseContent = EntityUtils.toString(rentity, "UTF-8");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new CustomerException(Constant.error100003, e.getMessage());
        } finally {
            if (post != null) {
                post.releaseConnection();
            }
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    public String sendHttpGet(String httpUrl) throws CustomerException {
        return this.sendHttpGet(httpUrl, null);
    }

    /**
     * 发送get请求
     *
     * @param
     * @return
     */
    public String sendHttpGet(String httpUrl, HashMap<String, String> headerMap) throws CustomerException {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(httpUrl);

            httpClient = HttpClients.createDefault();
            httpGet.setConfig(requestConfig);
            if (null != headerMap) {
                // 添加头部信息
                Iterator iter = headerMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String key = entry.getKey().toString();
                    String value = entry.getValue().toString();
                    httpGet.addHeader(key, value);
                }
            }

            long time1 = System.currentTimeMillis();

            response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();

            long time2 = System.currentTimeMillis();

            log.info("cost " + (time2 - time1));

            if (statusCode != HttpStatus.SC_OK) {
                throw new CustomerException(Constant.error100002, "get请求非正常返回");
            } else {
                entity = response.getEntity();
                responseContent = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            throw new CustomerException(Constant.error100003, e.getMessage());
        } finally {
            if (httpGet != null) {
                httpGet.releaseConnection();
            }
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }
}
