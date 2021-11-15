package org.csu.electriccommerce.service;

import org.apache.tomcat.util.http.fileupload.util.mime.MimeUtility;
import org.csu.electriccommerce.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.*;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.fromMail.addr}")
    private String from;

    public static String myEmailAccount = "1633737877@qq.com";
    public static String myEmailPassword = "ugzpjrkwhucyfcbd";
    public static String server = "pop.qq.com";

    /**
     * 发送简单邮件
     *
     * @param to      接受者。邮件的接受者
     * @param subject 主题。邮箱标题
     * @param content 内容。是邮箱的Text
     */
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);//接受者
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        try {
            javaMailSender.send(mailMessage);
            System.out.println("发送简单邮件");
        } catch (Exception e) {
            System.out.println("发送简单邮件失败");
        }
    }
}
