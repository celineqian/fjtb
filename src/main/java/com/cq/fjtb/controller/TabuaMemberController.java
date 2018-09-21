package com.cq.fjtb.controller;

import com.cq.fjtb.entity.TabuaMember;
import com.cq.fjtb.repository.TabuaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Celine Q
 * @create: 2018-09-16 14:54
 **/
@Controller
public class TabuaMemberController {

    private TabuaMemberRepository repository;


    public String findOne(Model model, @PathVariable("cardNumber") String cardNumber){
        model.addAttribute("member", repository.findByCardNumber(cardNumber));
        return "member";
    }

}