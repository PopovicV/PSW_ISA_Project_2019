package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.domain.VerificationToken;
import isapsw.team55.ClinicalCenter.service.EmailService;
import isapsw.team55.ClinicalCenter.service.PacijentService;
import isapsw.team55.ClinicalCenter.service.RegisterService;
import isapsw.team55.ClinicalCenter.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Context;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private VerificationTokenService verificationTokenService;

    @Autowired
    private PacijentService pacijentService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pacijent> loginPacijent(@RequestBody Pacijent pacijent) throws Exception {
        System.out.println(pacijent.toString());
        Pacijent noviKorisnik = registerService.registracijaKorisnika(pacijent);
        if (noviKorisnik != null) {
            emailService.sendNotificationAsync(noviKorisnik.getEmail(), "Dobrodosli na nas servis!", "Vas zahtev za registraciju je poslat administratoru servisa. Uskoro ćete dobiti verifikacioni link");
            return new ResponseEntity<Pacijent>(noviKorisnik, HttpStatus.OK);
        } else {
            return new ResponseEntity<Pacijent>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "/registrationConfirm")
    public String confirmRegistration(@RequestParam("token") String token) {
        VerificationToken vToken = verificationTokenService.findByToken(token);
        if (vToken == null) {
            System.out.println("TOKEN NIJE USPESNO NADJEN");
            return "";
        } else {
            Pacijent confirmPacijent = pacijentService.findOne(vToken.getPacijent().getId());
            confirmPacijent.setPacijentAktiviraoNalog("DA");
            pacijentService.save(confirmPacijent);
            System.out.println("KORISNIK USPESNO VERIFIKOVAN");
            return "";
        }


    }
}
