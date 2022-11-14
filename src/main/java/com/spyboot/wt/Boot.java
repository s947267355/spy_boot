package com.spyboot.wt;

import cn.hutool.cron.CronUtil;
import cn.hutool.log.StaticLog;

public class Boot {

    public static void main(String[] args) {
        StaticLog.info("-- boot --");
        CronUtil.start();
    }
}
