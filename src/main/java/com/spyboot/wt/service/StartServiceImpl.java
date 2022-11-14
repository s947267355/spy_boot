package com.spyboot.wt.service;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.log.StaticLog;

public class StartServiceImpl implements RunService {

    @Override
    public String run() {
        String result = "";
        String randomString = RandomUtil.randomString(21);
        try (HttpResponse httpResponse = HttpRequest.post("http://139.9.172.163:2017/api/v2ray")
                .body("")
                .header("Accept", "application/json, text/plain, */*")
                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .header("Authorization", Token.getAuthorization().get())
                .header("Content-Length", "0")
                .header("Origin", "http://139.9.172.163:2017")
                .header("Proxy-Connection", "keep-alive")
                .header("Referer", "http://139.9.172.163:2017/")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36 Edg/105.0.1343.53")
                .header("X-V2raya-Request-Id", randomString)
                .header("dnt", "1")
                .header("sec-gpc", "1")
                .execute()) {

            StaticLog.info("-- start status:{}, result:{}", httpResponse.isOk(), httpResponse.body());
            result = httpResponse.body();
        } catch (Exception e) {
            StaticLog.error(e.getMessage(), e);
        }
        return result;
    }

}
