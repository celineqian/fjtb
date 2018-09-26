package com.cq.fjtb.controller;

import com.cq.fjtb.entity.TabuaMember;
import com.cq.fjtb.repository.TabuaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Celine Q
 * @create: 2018-09-16 14:54
 **/
@Controller
public class TabuaMemberController {

    @Autowired
    private TabuaMemberRepository repository;

    @GetMapping("/search")
    public String search(@RequestParam(value="cardNumber") String cardNumber, @RequestParam(value="name")String name, Model model){
        TabuaMember member;
        String message;
        List<TabuaMember> list =  new ArrayList<TabuaMember>();
        if(cardNumber.isEmpty() && name.isEmpty()) {
            message = "至少输入一个参数 Please entry at least one condition!";
            model.addAttribute("message",message);
        }else if(!cardNumber.isEmpty()){
            member = repository.findByCardNumber(cardNumber.trim());
            if(member!=null)
                list.add(member);
            model.addAttribute("list",list);
        }else if(!name.isEmpty()){
            list = repository.findWithPartOfName(name);
            model.addAttribute("list",list);
        }
        return "list";
    }
}