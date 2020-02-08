package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.domain.Pregled;
import isapsw.team55.ClinicalCenter.domain.VerificationToken;
import isapsw.team55.ClinicalCenter.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    @Autowired
    VerificationTokenRepository verificationTokenRepository;


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

    @Async
    public void sendVerificationMail(Pacijent pacijent, String subject) throws MailException, InterruptedException {
        System.out.println("Proces slanja verifikacionog maila zapocet.");
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(pacijent.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject(subject);
        String token = UUID.randomUUID().toString();
        VerificationToken vToken = new VerificationToken(token, pacijent);
        verificationTokenRepository.save(vToken);

        mail.setText("Administrator je prihvation vaš zahtev za registraciju. Možete aktiviriti vaš nalog odlaskom na sledeći link\n" +
                "Verifikacioni link:\t" +
                "http://localhost:4200/registrationConfirm?token=" + token);

        javaMailSender.send(mail);

        System.out.println("Email poslat");

    }

    @Async
    public void sendPotvrdaPredefinisanog(Pacijent pacijent, Pregled pregled, String subject) throws MailException, InterruptedException {
        System.out.println("Proces slanja verifikacionog maila zapocet.");
        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo(pacijent.getEmail());
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject(subject);
        String zaSplit[] = pregled.getDatum().split("\\|");
        String datum = zaSplit[0];
        String vreme = zaSplit[1];
        mail.setText("Uspešno ste zakazali pregled " + pregled.getTipPregleda().getNaziv() + " koji će se održati " + datum + " u " + vreme + "." +
                "\n Naziv klinike: " + pregled.getSala().getKlinika().getIme() + "." +
                "\n Adresa klinike: " + pregled.getSala().getKlinika().getAdresa() + "." +
                "\n Naziv sale: " + pregled.getSala().getNaziv() + "." +
                "\n Izabrani lekar: " + pregled.getLekar().getIme() + " " + pregled.getLekar().getPrezime() + "." +
                "\n\n Hvala Vam na poverenju.");

        javaMailSender.send(mail);

        System.out.println("Email poslat");

    }
}
