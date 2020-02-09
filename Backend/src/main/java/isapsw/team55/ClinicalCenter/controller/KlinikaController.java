package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.AdministratorKlinike;
import isapsw.team55.ClinicalCenter.domain.Klinika;
import isapsw.team55.ClinicalCenter.dto.AdministratorKlinikeDTO;
import isapsw.team55.ClinicalCenter.dto.KlinikaAdministratorDTO;
import isapsw.team55.ClinicalCenter.dto.KlinikaDTO;
import isapsw.team55.ClinicalCenter.repository.KlinikaRepository;
import isapsw.team55.ClinicalCenter.service.AdministratorKlinikeService;
import isapsw.team55.ClinicalCenter.service.KlinikaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/klinika")
public class KlinikaController {
    @Autowired
    private KlinikaService klinikaService;

    @Autowired
    private AdministratorKlinikeService administratorKlinikeService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Klinika>> getAllKlinika() {
        List<Klinika> klinikaList = klinikaService.getAll();
        return new ResponseEntity<>(klinikaList, HttpStatus.OK);
    }

    /*@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Klinika> addKlinika(@RequestBody Klinika klinika) throws Exception {
        Klinika klinika1 = klinikaService.addKlinika(klinika);
        if(klinika1 != null) {
            return new ResponseEntity<Klinika>(klinika, HttpStatus.OK);
        } else {
            return new ResponseEntity<Klinika>(HttpStatus.NOT_ACCEPTABLE);
        }
    }*/

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Klinika> updateKlinika(@RequestBody Klinika klinika) throws Exception {
        Klinika klinika1 = klinikaService.update(klinika);
        if(klinika1 != null) {
            return new ResponseEntity<Klinika>(klinika1, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(value = "/dodeliAdministratora/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Klinika> dodeliAdministratora(@RequestBody KlinikaAdministratorDTO klinikaAdministratorDTO) throws Exception {
        Klinika klinika = klinikaService.findOneById(klinikaAdministratorDTO.klinikaId);
        AdministratorKlinike administratorKlinike = administratorKlinikeService.findOneById(klinikaAdministratorDTO.administratorId);

        if(administratorKlinike.getKlinika() == null) {
            klinika.addAdministratorKlinike(administratorKlinike);
            return new ResponseEntity<Klinika>(klinikaService.update(klinika), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KlinikaDTO> getAdministratorKlinike(@PathVariable Long id) {
            Klinika klinika = klinikaService.findOneById(id);

        if(klinika == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return  new ResponseEntity<>(new KlinikaDTO(klinika), HttpStatus.OK);
    }

    @GetMapping(value = "/getAdministratoriKlinike/{id}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdministratorKlinikeDTO>> getAdministratoriKlinike(@PathVariable Long id) {
        List<AdministratorKlinike> administratori = klinikaService.getAdministratoriKlinike(id);
        List<AdministratorKlinikeDTO> administratoriDTO = new ArrayList<AdministratorKlinikeDTO>();
        System.out.println("kontroler");
        for(AdministratorKlinike administrator: administratori) {
            administratoriDTO.add(new AdministratorKlinikeDTO(administrator));
            System.out.println(administrator.getIme());
        }
        return new ResponseEntity<List<AdministratorKlinikeDTO>>(administratoriDTO, HttpStatus.OK);
    }



}
