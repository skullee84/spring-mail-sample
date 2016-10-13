package com.appskimo.app.web.controller;

import com.appskimo.app.domain.Mail;
import com.appskimo.app.service.MailService;
import com.google.common.collect.Maps;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by dominic.lee on 2016. 10. 13..
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MailController {

    @Inject
    private MailService mailService;

    @RequestMapping(value = "sample", method = RequestMethod.GET)
    public Object sample() {
        Map<String, String> map = Maps.newHashMap();
        map.put("data", "sample");

        return map;
    }

    @RequestMapping(value = "mail/send", method = RequestMethod.POST)
    public void send(@RequestBody Mail mail) {
        mailService.asyncSend(mail);
    }

}