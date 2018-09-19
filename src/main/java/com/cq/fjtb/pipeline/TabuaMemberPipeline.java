package com.cq.fjtb.pipeline;

import com.cq.fjtb.entity.TabuaMember;
import com.cq.fjtb.repository.TabuaMemberRepository;
import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
public class TabuaMemberPipeline extends Thread implements Pipeline {

    @Autowired
    protected TabuaMemberRepository repository;

    @Override
    public void process(ResultItems resultItems, Task task) {
        TabuaMember tm = new TabuaMember();
        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if(entry.getKey().contains("cardNumber")){
                String cardNumber = (String)entry.getValue();
                tm = repository.findByCardNumber(cardNumber);

                if(entry.getKey().contains("Name"))
                    tm.setName((String)entry.getValue());
                if(entry.getKey().contains("Status Credit Balance"))
                    tm.setStatusCredit((String) entry.getValue());
                if(entry.getKey().contains("Upgrade Credit Balance"))
                    tm.setUpgradeCredit((String) entry.getValue());
                if(entry.getKey().contains("Expiry Date")){
                    String expireDate = (String)entry.getValue();
                    tm.setExpiryDate(expireDate);
                    if(com.cq.fjtb.util.DateUtil.isExpired(expireDate))
                        tm.setIsValid(0);
            }

            }
        }
        if(tm.getCardNumber()!=null)
            repository.save(tm);
    }
}

