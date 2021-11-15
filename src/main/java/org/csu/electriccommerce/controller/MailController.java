package org.csu.electriccommerce.controller;

import org.csu.electriccommerce.entity.Mail;
import org.csu.electriccommerce.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/mail")
@SessionAttributes("mail")
public class MailController {
    @Autowired
    MailService mailService;

    @RequestMapping("/sendmail")
    public String sendmail(HttpServletRequest request){
        String content = request.getParameter("message");
        String from  = request.getParameter("email");
        String subject = request.getParameter("subject");
        mailService.sendMail(from,subject,content);
        return "page/contact";
    }
}
