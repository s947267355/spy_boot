package com.test;

//import cn.hutool.core.util.RandomUtil;
//import cn.hutool.core.util.StrUtil;
//import cn.hutool.http.HttpRequest;
//import cn.hutool.http.HttpResponse;
//import cn.hutool.json.JSONObject;
//import cn.hutool.json.JSONUtil;
//import cn.hutool.log.StaticLog;
//import okhttp3.*;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//import java.util.concurrent.atomic.AtomicReference;

public class Test1 {

//    private static volatile AtomicReference<String> authorization = new AtomicReference<>("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2NzA5ODM0NDksInVuYW1lIjoiYWRtaW4ifQ.9YATNCS9P1uMkI-3k8-26t6UuEWS8VyLiqJrrFuQDg0");
//
//    @Test
//    public void stop() throws IOException {
//        String randomString = RandomUtil.randomString(21);
//        try (HttpResponse httpResponse = HttpRequest.delete("http://139.9.172.163:2017/api/v2ray")
//                .body("")
//                .header("Accept", "application/json, text/plain, */*")
//                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
//                .header("Authorization", authorization.get())
//                .header("Origin", "http://139.9.172.163:2017")
//                .header("Proxy-Connection", "keep-alive")
//                .header("Referer", "http://139.9.172.163:2017/")
//                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36 Edg/105.0.1343.53")
//                .header("X-V2raya-Request-Id", randomString)
//                .header("dnt", "1")
//                .header("sec-gpc", "1")
//                .execute()) {
//
//            StaticLog.info(httpResponse.body());
//        } catch (Exception e) {
//            StaticLog.error(e.getMessage(), e);
//        }
//    }
//
//    @Test
//    public void start() throws IOException {
//        String randomString = RandomUtil.randomString(21);
//        try (HttpResponse httpResponse = HttpRequest.post("http://139.9.172.163:2017/api/v2ray")
//                .body("")
//                .header("Accept", "application/json, text/plain, */*")
//                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
//                .header("Authorization", authorization.get())
//                .header("Content-Length", "0")
//                .header("Origin", "http://139.9.172.163:2017")
//                .header("Proxy-Connection", "keep-alive")
//                .header("Referer", "http://139.9.172.163:2017/")
//                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36 Edg/105.0.1343.53")
//                .header("X-V2raya-Request-Id", randomString)
//                .header("dnt", "1")
//                .header("sec-gpc", "1")
//                .execute()) {
//
//            StaticLog.info("-- start status:{}, result:{}", httpResponse.isOk(), httpResponse.body());
//        } catch (Exception e) {
//            StaticLog.error(e.getMessage(), e);
//        }
//    }
//
//    @Test
//    public void login() {
//
//        try (HttpResponse httpResponse = HttpRequest.post("http://139.9.172.163:2017/api/login")
//                .body("{\"username\":\"admin\",\"password\":\"123456\"}")
//                .header("Accept", "application/json, text/plain, */*")
//                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
//                .header("Content-Type", "application/json")
//                .header("Origin", "http://139.9.172.163:2017")
//                .header("Proxy-Connection", "keep-alive")
//                .header("Referer", "http://139.9.172.163:2017/")
//                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36 Edg/105.0.1343.53")
//                .header("dnt", "1")
//                .header("sec-gpc", "1")
//                .execute()) {
//
//            String result = httpResponse.body();
//            StaticLog.info("-- login status:{}, result:{}", httpResponse.isOk(), result);
//            if (httpResponse.isOk() && result.contains("token")) {
//                JSONObject jsonObject = JSONUtil.parseObj(httpResponse.body());
//                JSONObject data = jsonObject.getJSONObject("data");
//                String token = data.getStr("token");
//                if (StrUtil.isNotBlank(token)) {
//                    String old = authorization.getAndSet(token);
//                    StaticLog.info("-- login success set token old:{}, new:{}, cur:{}", old, token, authorization.get());
//                }
//            }
//        } catch (Exception e) {
//            StaticLog.error(e.getMessage(), e);
//        }
//
//    }
}
