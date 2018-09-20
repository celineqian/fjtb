package com.cq.fjtb.controller;

import com.cq.fjtb.entity.TabuaMember;
import com.cq.fjtb.repository.TabuaMemberRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TabuaMemberController {

    private TabuaMemberRepository repository;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/{cardNumber}", method = RequestMethod.GET)
    public String show(@PathVariable String cardNumber, ModelMap map){
        TabuaMember tm = repository.findByCardNumber(cardNumber);
        map.put("tm",tm);
        return "index";
    }

}