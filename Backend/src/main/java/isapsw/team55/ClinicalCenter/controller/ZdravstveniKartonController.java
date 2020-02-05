package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Dijagnoza;
import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.service.ZdravstveniKartonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/zdravstveniKarton")
public class ZdravstveniKartonController {

    @Autowired
    ZdravstveniKartonService zdravstveniKartonService = new ZdravstveniKartonService();

    @GetMapping(value = "/dijagnoze", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Dijagnoza>> dijagnoze(@Context HttpServletRequest request) {

        Korisnik korisnik = (Korisnik) request.getSession().getAttribute("ulogovanKorisnik");

        List<Dijagnoza> dijagnoze = zdravstveniKartonService.listaDijagnoza(korisnik.getId());

        if(dijagnoze.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(dijagnoze, HttpStatus.OK);
    }
}
