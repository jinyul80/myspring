package com.jinidev.myspring.mining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mining")
public class monitoring {

    @GetMapping("dashboard")
    public String dashboard() {
        return "mining/dashboard";
    }

}
