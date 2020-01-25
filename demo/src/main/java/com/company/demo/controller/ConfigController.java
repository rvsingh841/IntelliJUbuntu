package com.company.demo.controller;

import com.company.demo.config.ConfigClass;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ConfigController {
    private final ConfigClass configClass;

    public ConfigController(ConfigClass configClass) {
        this.configClass = configClass;
    }

    @GetMapping("/config")
    public String getConfigProperties(){
      return  this.configClass.getMaximum() + "," + this.configClass.getMinimum();
    }
}
