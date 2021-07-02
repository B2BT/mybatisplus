package com.example.mybatisplus.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/console")
    public String console(){
        return "views/home/console";
    }

    @RequestMapping("/auto")
    public String auto(){
        return "/views/component/table/auto";
    }
}
