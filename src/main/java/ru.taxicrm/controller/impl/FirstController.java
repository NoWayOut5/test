package ru.taxicrm.controller.impl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

@RestController
@ApiIgnore
@CrossOrigin
public class FirstController {

    @GetMapping(value = "/test")
    public Map getHome() {
        Map<String, String> map = new HashMap<>();
        map.put("test1", "v1");
        map.put("test2", "v2");
        map.put("test3", "v3");
        return map;
    }
}