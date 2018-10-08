package com.cq.fjtb;

import com.cq.fjtb.entity.TabuaMember;
import com.cq.fjtb.repository.TabuaMemberRepository;
import com.cq.fjtb.util.RSAUtil;
import javafx.scene.control.Tab;
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


    @Test
    public void getTabuaMemberByCarNumber()throws Exception{
        String cardNumber = "KW008S";
        TabuaMember tm = repository.findByCardNumber(cardNumber);
        System.out.println("name is: " + tm.getName());
    }


    public void findWithPartName() throws Exception{
        String name = "li";
        List<TabuaMember> list = repository.findWithPartOfName(name);
        for (TabuaMember tm: list){
            System.out.println("名字：" + tm.getName() + "卡号：" + tm.getCardNumber());
        }
    }

    public void findAll()throws Exception{
        List<TabuaMember> members = repository.findAll();
        List<TabuaMember> m = new ArrayList<TabuaMember>();
        for(TabuaMember tm : members){
            System.out.println("原密码是：" + tm.getPassword());
            String cryptograph = RSAUtil.encrypt(tm.getPassword(), RSAUtil.PUBLIC_KEY_FILE);//生成的密文
            tm.setPassword(cryptograph);
            System.out.println("现密码是：" + tm.getPassword());
            m.add(tm);
        }
        repository.saveAll(m);
    }




    public void decrypt(){
        TabuaMember tm = repository.findByCardNumber("LRSKM3");
        if(tm.getPassword().length()>100){
            try{
                System.out.println("加密密码为：" + tm.getPassword());
                String text = RSAUtil.decrypt(tm.getPassword(),RSAUtil.PRIVATE_KEY_FILE);
                System.out.println("解密后密码为：" + text);
            }catch (Exception e){
                System.out.println("解密过程中发生错误");
            }
        }else{
            System.out.println("密码不存在");
        }
    }

    public void findValidAll(){
        List<TabuaMember> members = repository.findValidAll();
        System.out.println("共计数据："+members.size());
    }



}
