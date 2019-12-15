package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> loginPacijent(@RequestBody Korisnik korisnik, @Context HttpServletRequest request) throws Exception {
        Korisnik ulogovanKorisnik = loginService.proveraKorisnika(korisnik.getEmail(), korisnik.getLozinka());
        System.out.println("Usao sam u login");
        if (ulogovanKorisnik != null) {
            //Postavljanje trenutno ulogovanog korisnika
            request.getSession().setAttribute("ulogovanKorisnik", ulogovanKorisnik);
            System.out.println("Ulogovan korisnik je: " + ulogovanKorisnik.getEmail());
            return new ResponseEntity<Korisnik>(ulogovanKorisnik, HttpStatus.OK);
        } else {
            return new ResponseEntity<Korisnik>(korisnik, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/logout", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> logout(@Context HttpServletRequest request) throws Exception {
        System.out.println("usao sam u logout!");
        Korisnik ulogovanKorisnik = (Korisnik) request.getSession().getAttribute("ulogovanKorisnik");
        request.getSession().invalidate();
        System.out.println("KORISNIK " + ulogovanKorisnik.getEmail() + "JE IZLOGVAN.");
        return new ResponseEntity<Korisnik>(ulogovanKorisnik, HttpStatus.OK);
    }
}
