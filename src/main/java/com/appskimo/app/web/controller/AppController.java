package com.appskimo.app.web.controller;

import com.google.common.collect.Maps;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by dominic.lee on 2016. 10. 13..
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppController {

    @RequestMapping(value = "sample", method = RequestMethod.GET)
    public Object sample() {
        Map<String, String> map = Maps.newHashMap();
        map.put("data", "sample");

        return map;
    }
    
}
