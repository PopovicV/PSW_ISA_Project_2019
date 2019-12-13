package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;


    @Async
    public void sendNotificationAsync(String email, String subject, String poruka) throws MailException, InterruptedException {
        System.out.println("Proces slanja maila zapocet.");
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(email);
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject(subject);
        mail.setText(poruka);
        javaMailSender.send(mail);

        System.out.println("Email poslat");

    }
}
