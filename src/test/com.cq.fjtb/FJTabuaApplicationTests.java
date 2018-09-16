package com.cq.fjtb;

import com.cq.fjtb.entity.TabuaMember;
import com.cq.fjtb.repository.TabuaMemberRepository;
import com.cq.fjtb.util.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Executable;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FJTabuaApplicationTests {

    @Autowired
    private TabuaMemberRepository tabuaMemberRepository;

    public void getTabuaMemberByCarNumber()throws Exception{
        String cardNumber = "0NR44K";
        TabuaMember tm = tabuaMemberRepository.findByCardNumber(cardNumber);
        System.out.println("name is: " + tm.getName());
    }

//    public void updatePassword() throws Exception{
//        String cardNumber = "0NR44K";
//        TabuaMember tm = tabuaMemberRepository.findByCardNumber("0NR44K");
//        System.out.println("name is:" + tm.getName()+"     pwd is: " + tm.getPassword());
//        tabuaMemberRepository.updatePwd(MD5Utils.md5(tm.getPassword()),cardNumber);
//    }
//
//    @Test
//    public void updateAll() throws Exception{
//        List<TabuaMember> members = tabuaMemberRepository.findAll();
//        for (TabuaMember tabuaMember: members){
//            String carNumber = tabuaMember.getCardNumber();
//            String cryptPwd = MD5Utils.md5(tabuaMember.getPassword());
//            tabuaMemberRepository.updatePwd(cryptPwd,carNumber);
//        }
//        System.out.println("===============DONE===============");
//
//    }


}
