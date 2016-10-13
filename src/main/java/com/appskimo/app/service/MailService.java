package com.appskimo.app.service;


import com.appskimo.app.domain.Mail;

/**
 * Created by dominic.lee on 2016. 10. 13..
 */
public interface MailService {

    void asyncSend(Mail mail);

    void send(Mail mail);

}
