package com.cq.fjtb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TabuaMemberController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


}