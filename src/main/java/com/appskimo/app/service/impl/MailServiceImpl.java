package com.appskimo.app.service.impl;

import com.appskimo.app.domain.Mail;
import com.appskimo.app.service.MailService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.util.Properties;

/**
 * Created by dominic.lee on 2016. 10. 13..
 */
@Component
public class MailServiceImpl implements MailService {
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_TEXT_HTML = "text/html; charset=UTF-8";
    private static final String CHARSET = "UTF-8";

    @Inject private JavaMailSender defaultMailSender;
    @Inject private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public void asyncSend(final Mail mail) {
        threadPoolTaskExecutor.execute(() -> {
            send(mail);
        });
    }

    @Override
    public void send(final Mail mail) {
        try {
            MimeMessage msg = new MimeMessage(Session.getDefaultInstance(new Properties(), null));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(mail.getAddress()));
            msg.setHeader(CONTENT_TYPE, CONTENT_TYPE_TEXT_HTML);
            msg.setSubject(MimeUtility.encodeText(mail.getTitle(), CHARSET, "B"));
            msg.setContent(mail.getContent(), CONTENT_TYPE_TEXT_HTML);
            msg.setFrom(new InternetAddress("Dominic <dominic.lee@kakaocorp.com>"));
            defaultMailSender.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
