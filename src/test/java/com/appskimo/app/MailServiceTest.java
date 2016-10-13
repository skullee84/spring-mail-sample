package com.appskimo.app;

import com.appskimo.app.domain.Mail;
import com.appskimo.app.service.MailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

//import static org.hamcrest.CoreMatchers.is;

//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = "/test-service.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MailServiceTest {

    @Inject
    private MailService mailService;

    @Before
    public void setup() {
        assertNotNull(mailService);
    }

    @Test
    public void test() {
        Mail mail = getSampleMail();

        mailService.send(mail);
    }

    public Mail getSampleMail() {
        Mail mail = new Mail();
        mail.setAddress("dominic.lee@kakaocorp.com");
        mail.setTitle("sample title");
        mail.setContent("<html><body><h1>sample content</h1></body></html>");

        return mail;
    }
}
