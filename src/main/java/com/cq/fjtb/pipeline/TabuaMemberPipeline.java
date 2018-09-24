package com.cq.fjtb.pipeline;

import com.cq.fjtb.entity.TabuaMember;
import com.cq.fjtb.repository.TabuaMemberRepository;
import com.cq.fjtb.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Date;
import java.util.Map;


/**
 * @author: Celine Q
 * @create: 2018-09-16 14:54
 **/
@Component
public class TabuaMemberPipeline implements Pipeline {

    @Autowired
    protected TabuaMemberRepository repository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        String name = "";
        String scb = "";
        String ucb = "";
        String expiryDate = "";
//        String la = "";

        TabuaMember tm = new TabuaMember();
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if(entry.getKey().contains("cardNumber")){
                String cardNumber = (String)entry.getValue();
                tm = repository.findByCardNumber(cardNumber);
            }
            if(entry.getKey().contains("Name")){
                name = (String)entry.getValue();
                tm.setName(name);
            }
            if(entry.getKey().contains("Status Credit Balance")){
                scb = (String)entry.getValue();
                tm.setStatusCredit(scb);
            }
            if(entry.getKey().contains("Upgrade Credit Balance")){
                ucb = (String)entry.getValue();
                tm.setUpgradeCredit(ucb);
            }
            if(entry.getKey().contains("Expiry Date")){
                expiryDate = (String)entry.getValue();
                tm.setExpiryDate(expiryDate);
                if(DateUtil.isExpired(tm.getExpiryDate()))
                    tm.setIsValid(0);
            }
//            if(entry.getKey().contains("Last activity")){
//                la = (String)entry.getValue();
//                tm.setLastActivityDate(la);
//            }
        }
        if(name!="" && scb!="" && ucb!="" && expiryDate!=""){
            tm.setLastUpdateDate(DateUtil.DateToStr(new Date()));
            repository.save(tm);
        }
    }
}

