package com.cq.fjtb.pipeline;

import com.cq.fjtb.entity.TabuaMember;
import com.cq.fjtb.repository.TabuaMemberRepository;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import java.util.Map;

/**
 * @author: Celine Q
 * @create: 2018-09-16 14:54
 **/
@Component
public class TabuaMemberPipeline implements Pipeline {

    private TabuaMemberRepository tabuaMemberRepository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        TabuaMember tm = new TabuaMember();
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if(entry.getKey().contains("Name")){
                String name = (String)entry.getValue();
                tm = tabuaMemberRepository.findByName(name);
            }
            if(entry.getKey().contains("Status Credit Balance"))
                tm.setStatusCredit((String) entry.getValue());
            if(entry.getKey().contains("Upgrade Credit Balance"))
                tm.setUpgradeCredit((String) entry.getValue());
            if(entry.getKey().contains("Expiry Date")){
               tm.setExpiryDate((String)entry.getValue());
            }
        }
        tabuaMemberRepository.saveAndFlush(tm);
    }
}

