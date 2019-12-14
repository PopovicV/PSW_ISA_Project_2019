package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.dto.PacijentDTO;
import isapsw.team55.ClinicalCenter.service.PacijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/pacijent")
public class PacijentController {

    @Autowired
    PacijentService pacijentService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<PacijentDTO>> getAllPacijenti() {
        List<Pacijent> pacijenti = pacijentService.findAll();

        List<PacijentDTO> pacijentDTO = new ArrayList<>();
        for (Pacijent s : pacijenti) {
            pacijentDTO.add(new PacijentDTO(s));
        }

        return new ResponseEntity<>(pacijentDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PacijentDTO> getPacijent(@PathVariable Long id) {
        Pacijent p = pacijentService.findOne(id);

        if(p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity<>(new PacijentDTO(p), HttpStatus.OK);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pacijent> updatePacijent(@RequestBody Pacijent pacijent) throws Exception{
        Pacijent p = pacijentService.update(pacijent);
        if(p != null) {
            return new ResponseEntity<Pacijent>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<Pacijent>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "/ulogovanKorisnik", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pacijent> getKorisnik(@Context HttpServletRequest request) {
        Korisnik korisnik = (Korisnik) request.getSession().getAttribute("ulogovanKorisnik");
        Pacijent p = pacijentService.findOne(korisnik.getId());

        if(p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity(p, HttpStatus.OK);
    }
}
