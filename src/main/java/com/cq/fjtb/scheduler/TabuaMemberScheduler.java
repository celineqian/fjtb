package com.cq.fjtb.scheduler;

import com.cq.fjtb.entity.TabuaMember;
import com.cq.fjtb.pipeline.TabuaMemberPipeline;
import com.cq.fjtb.processor.TabuaMemberProcessor;
import com.cq.fjtb.repository.TabuaMemberRepository;
import com.cq.fjtb.util.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import java.util.List;

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

    @Autowired
    private TabuaMemberRepository repository;


    @Scheduled(cron ="0 30 11 * * ?")
    public void TMShuScheduled() {
        System.out.println("----- 开始执行定时任务 -----");
        List<TabuaMember> members = repository.findValidAll();
        for (TabuaMember tm : members) {
            try {
                processor.setPassword(tm.getPassword());
                processor.setCardNumber(tm.getCardNumber());
                processor.login();
            } catch (Exception e) {
                System.out.println("登陆过程中发生错误：" + e.getMessage());
                return;
            }
            Spider spider = Spider.create(processor).addPipeline(pipeline)
                    .addUrl("https://www.fijiairways.com/tabua-club/member-login/").thread(5);
            spider.run();
        }
    }
}


