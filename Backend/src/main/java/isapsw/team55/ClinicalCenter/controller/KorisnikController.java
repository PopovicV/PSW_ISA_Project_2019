package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
//import isapsw.team55.ClinicalCenter.dto.KorisnikDTO;
import isapsw.team55.ClinicalCenter.dto.KorisnikDTO;
import isapsw.team55.ClinicalCenter.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

@RestController
@RequestMapping("/api/ulogovanKorisnik")
public class KorisnikController {

    @Autowired
    KorisnikService korisnikService = new KorisnikService();

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Korisnik> getKorisnik(@Context HttpServletRequest request) {
        Korisnik korisnik = (Korisnik) request.getSession().getAttribute("ulogovanKorisnik");

        if(korisnik == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(new KorisnikDTO(korisnik), HttpStatus.OK);
    }
}
