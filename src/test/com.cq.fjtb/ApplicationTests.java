package com.cq.fjtb;

import com.cq.fjtb.entity.TabuaMember;
import com.cq.fjtb.repository.TabuaMemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Executable;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTests {

    @Autowired
    private TabuaMemberRepository tabuaMemberRepository;

    @Test
    public void getTabuaMemberByCarNumber()throws Exception{
        String cardNumber = "0NR44K";
        TabuaMember tm = tabuaMemberRepository.findByCardNumber(cardNumber);
        System.out.println("name is: " + tm.getName());
    }


}
