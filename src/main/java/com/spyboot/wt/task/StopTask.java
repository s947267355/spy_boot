package com.spyboot.wt.task;

import cn.hutool.aop.ProxyUtil;
import com.spyboot.wt.service.AuthAspect;
import com.spyboot.wt.service.RunService;
import com.spyboot.wt.service.StopServiceImpl;

public class StopTask {


    public void taskRun() {
        RunService service = ProxyUtil.proxy(new StopServiceImpl(), AuthAspect.class);
        service.run();
    }
}
