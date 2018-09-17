package com.cq.fjtb.scheduler;

import com.cq.fjtb.pipeline.TabuaMemberPipeline;
import com.cq.fjtb.processor.TabuaMemberProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

/**
 * @author: Celine Q
 * @create: 2018-09-17 19:59
 **/
@Component
public class TabuaMemberScheduler {

    @Autowired
    private TabuaMemberPipeline pipeline;

    @Autowired
    private TabuaMemberProcessor processor;

    @Scheduled(cron ="0 19 23 * * ?")
    public void TMShuScheduled(){
        System.out.println("---- 开始执行定时任务 -----");
        processor.login();
        Spider spider = Spider.create(processor)
                .addPipeline(pipeline)
                .addUrl("https://www.fijiairways.com/tabua-club/member-login/");
        spider.start();
        spider.setExitWhenComplete(true);
        spider.close();
    }
}


