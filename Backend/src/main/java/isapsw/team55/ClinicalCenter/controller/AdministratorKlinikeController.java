package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.*;
import isapsw.team55.ClinicalCenter.dto.AdministratorKlinikeDTO;
import isapsw.team55.ClinicalCenter.service.AdministratorKlinikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/administratorKlinike")
public class AdministratorKlinikeController {

    @Autowired
    private AdministratorKlinikeService administratorKlinikeService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<AdministratorKlinikeDTO>> getAllAdministratorKlinike() {
        List<AdministratorKlinike> administratori = administratorKlinikeService.findAll();

        List<AdministratorKlinikeDTO> administratorKlinikeDTO = new ArrayList<>();
        for (AdministratorKlinike s : administratori) {
            administratorKlinikeDTO.add(new AdministratorKlinikeDTO(s));
        }

        return new ResponseEntity<>(administratorKlinikeDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdministratorKlinikeDTO> getAdministratorKlinike(@PathVariable Long id) {
            AdministratorKlinike administratorKlinike = administratorKlinikeService.findOneById(id);

            if(administratorKlinike == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        return  new ResponseEntity<>(new AdministratorKlinikeDTO(administratorKlinike), HttpStatus.OK);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdministratorKlinike> updateAdministratorKlinike(@RequestBody AdministratorKlinike administratorKlinike) throws Exception{
        AdministratorKlinike administratorKlinike1 = administratorKlinikeService.update(administratorKlinike);
        if(administratorKlinike1 != null) {
            return new ResponseEntity<AdministratorKlinike>(administratorKlinike1, HttpStatus.OK);
        } else {
            return new ResponseEntity<AdministratorKlinike>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(value = "/addMedicinskoOsoblje", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicinskoOsoblje> addMedicinskoOsoblje(@RequestBody MedicinskoOsoblje medicinskoOsoblje) throws Exception {
        MedicinskoOsoblje me = administratorKlinikeService.addMedicinsoOsoblje(medicinskoOsoblje);
        if(me != null) {
            return new ResponseEntity<MedicinskoOsoblje>(medicinskoOsoblje, HttpStatus.OK);
        } else {
            return new ResponseEntity<MedicinskoOsoblje>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "/ulogovanKorisnik", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdministratorKlinikeDTO> getKorisnik(@Context HttpServletRequest request) {
        Korisnik korisnik = (Korisnik) request.getSession().getAttribute("ulogovanKorisnik");
        AdministratorKlinike administratorKlinike = administratorKlinikeService.findOneById(korisnik.getId());

        if(administratorKlinike == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Ulogovan administrator:" + administratorKlinike.getIme());
        System.out.println(administratorKlinike.getKlinika().getId());
        return  new ResponseEntity(new AdministratorKlinikeDTO(administratorKlinike), HttpStatus.OK);
    }
}
