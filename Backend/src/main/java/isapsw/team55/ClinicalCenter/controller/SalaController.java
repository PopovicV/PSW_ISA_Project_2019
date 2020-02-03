package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Sala;
import isapsw.team55.ClinicalCenter.dto.SalaDTO;
import isapsw.team55.ClinicalCenter.service.KlinikaService;
import isapsw.team55.ClinicalCenter.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/sala")
public class SalaController {
    @Autowired
    private SalaService salaService;

    @Autowired
    private KlinikaService klinikaService;

    @GetMapping(value = "/allFromKlinika/{idKlinike}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDTO>> getAllKlinika(@PathVariable Long idKlinike) {
        List<Sala> salaList = salaService.getAllFromKlinika(idKlinike);

        if(salaList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<SalaDTO> salaDTOList = new ArrayList<>();

        for (Sala sala :
                salaList) {
            salaDTOList.add(new SalaDTO(sala));
        }

        return new ResponseEntity<List<SalaDTO>>(salaDTOList, HttpStatus.OK);
    }

    @PostMapping(value = "/addSala",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> addLekar(@RequestBody SalaDTO salaDTO) throws Exception {
        Sala sala = new Sala(salaDTO);

        sala.setKlinika(klinikaService.findOneById(salaDTO.getKlinikaId()));
        System.out.println("STIGNE ZAHTEV");
        System.out.println(sala.getNaziv());

        if(salaService.findOneByNaziv(salaDTO.getNaziv())==null) {
            salaService.save(sala);
            return new ResponseEntity<SalaDTO>(salaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<SalaDTO>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(value = "/removeSala/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> addLekar(@RequestBody SalaDTO salaDTO, @PathVariable Long id) throws Exception {
        salaService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
