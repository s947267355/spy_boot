package com.spyboot.wt.service;

import cn.hutool.aop.aspects.SimpleAspect;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;

import java.lang.reflect.Method;

public class AuthAspect extends SimpleAspect {

    @Override
    public boolean before(Object target, Method method, Object[] args) {
        StaticLog.info("-- before --");
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] args, Object returnVal) {
        StaticLog.info("-- after AuthAspect --");
        if (returnVal == null) {
            return true;
        }
        String result = returnVal.toString();
        if (result.contains("token is expired")) {
            StaticLog.info("-- token is expired --");
            login();
            RunService service = (RunService) target;
            service.run();
        }
        return true;
    }

    public void login(){
        try (HttpResponse httpResponse = HttpRequest.post("http://139.9.172.163:2017/api/login")
                .body("{\"username\":\"admin\",\"password\":\"123456\"}")
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .header("Content-Type", "application/json")
                .header("Origin", "http://139.9.172.163:2017")
                .header("Proxy-Connection", "keep-alive")
                .header("Referer", "http://139.9.172.163:2017/")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36 Edg/105.0.1343.53")
                .header("dnt", "1")
                .header("sec-gpc", "1")
                .execute()) {

            String result = httpResponse.body();
            StaticLog.info("-- login status:{}, result:{}", httpResponse.isOk(), result);
            if (httpResponse.isOk() && result.contains("token")) {
                JSONObject jsonObject = JSONUtil.parseObj(httpResponse.body());
                JSONObject data = jsonObject.getJSONObject("data");
                String token = data.getStr("token");
                if (StrUtil.isNotBlank(token)) {
                    String old = Token.getAuthorization().getAndSet(token);
                    StaticLog.info("-- login success set token old:{}, new:{}, cur:{}", old, token, Token.getAuthorization().get());
                }
            }
        } catch (Exception e) {
            StaticLog.error(e.getMessage(), e);
        }
    }
}
