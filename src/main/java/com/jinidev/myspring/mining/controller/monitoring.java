package com.jinidev.myspring.mining.controller;

import com.jinidev.myspring.mining.repository.MinerLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mining")
public class monitoring {

    @Autowired
    private MinerLogRepository minerLogRepository;

    @GetMapping("/")
    public String dashboard() {
        return "mining/dashboard";
    }

}
