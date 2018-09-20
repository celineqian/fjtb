package com.cq.fjtb;

import com.cq.fjtb.entity.TabuaMember;
import com.cq.fjtb.repository.TabuaMemberRepository;
import com.cq.fjtb.util.RSAUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FJTabuaApplicationTests {

    @Autowired
    private TabuaMemberRepository repository;

    public void getTabuaMemberByCarNumber()throws Exception{
        String cardNumber = "0NR44K";
        TabuaMember tm = repository.findByCardNumber(cardNumber);
        System.out.println("name is: " + tm.getName());
    }


    @Test
    public void findAll()throws Exception{
        List<TabuaMember> members = repository.findAll();
        List<TabuaMember> m = new ArrayList<TabuaMember>();
        for(TabuaMember tm : members){
            System.out.println("原密码是：" + tm.getPassword());
            String cryptograph = RSAUtil.encrypt(tm.getPassword(), RSAUtil.PUBLIC_KEY_FILE);//生成的密文
            tm.setPassword(cryptograph);
            System.out.println("原密码是：" + tm.getPassword());
            m.add(tm);
        }
        repository.saveAll(m);
    }
//
//
//
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
