package com.spyboot.wt.task;

import cn.hutool.aop.ProxyUtil;
import com.spyboot.wt.service.AuthAspect;
import com.spyboot.wt.service.RunService;
import com.spyboot.wt.service.StartServiceImpl;

public class StartTask {

    public void taskRun() {
        RunService service = ProxyUtil.proxy(new StartServiceImpl(), AuthAspect.class);
        service.run();
    }
}
