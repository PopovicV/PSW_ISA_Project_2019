package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.Context;

@RestController
@RequestMapping("/api/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pacijent> loginPacijent(@RequestBody Pacijent pacijent) throws Exception {
        System.out.println(pacijent.toString());
        Pacijent noviKorisnik = registerService.registracijaKorisnika(pacijent);
        if (noviKorisnik != null) {
            return new ResponseEntity<Pacijent>(noviKorisnik, HttpStatus.OK);
        } else {
            return new ResponseEntity<Pacijent>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
