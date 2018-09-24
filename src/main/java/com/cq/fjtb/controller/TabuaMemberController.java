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

/**
 * @author: Celine Q
 * @create: 2018-09-16 14:54
 **/
@Controller
public class TabuaMemberController {

    @Autowired
    private TabuaMemberRepository repository;

    @GetMapping("/search")
    public String search(@RequestParam(value="cardNumber", required=true) String cardNumber, Model model){
        TabuaMember member = repository.findByCardNumber(cardNumber);
        if(member != null)
            model.addAttribute("member",member);
        else{
            String message = "用户不存在";
            model.addAttribute("message",message);
        }

        return "member";
    }

}