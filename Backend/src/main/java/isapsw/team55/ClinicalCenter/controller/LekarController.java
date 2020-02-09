package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Klinika;
import isapsw.team55.ClinicalCenter.domain.Lekar;
import isapsw.team55.ClinicalCenter.domain.TipPregleda;
import isapsw.team55.ClinicalCenter.dto.LekarDTO;
import isapsw.team55.ClinicalCenter.service.KlinikaService;
import isapsw.team55.ClinicalCenter.service.LekarService;
import isapsw.team55.ClinicalCenter.service.TipPregledaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/lekar")
public class LekarController {
    @Autowired
    private LekarService lekarService;

    @Autowired
    private KlinikaService klinikaService;

    @Autowired
    private TipPregledaService tipPregledaService;

    @GetMapping(value = "/allFromKlinika/{idKlinike}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LekarDTO>> getAllLekar(@PathVariable Long idKlinike) {
        List<Lekar> lekarList = lekarService.getAllFromKlinika(idKlinike);

        List<LekarDTO> lekarDTOList = new ArrayList<LekarDTO>();

        for (Lekar lekar: lekarList
             ) {
            lekarDTOList.add(new LekarDTO(lekar));
        }

        return new ResponseEntity<List<LekarDTO>>(lekarDTOList, HttpStatus.OK);
    }

    @PostMapping(value = "/addLekar",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LekarDTO> addLekar(@RequestBody LekarDTO lekarDTO) throws Exception {
        Lekar lekar = new Lekar(lekarDTO);

        lekar.setKlinika(klinikaService.findOneById(lekarDTO.getKlinikaId()));
        System.out.println("STIGNE ZAHTEV");
        System.out.println(lekar.getIme());

        if(lekarService.findOneByEmail(lekarDTO.getEmail())==null) {
            lekarService.save(lekar);
            return new ResponseEntity<LekarDTO>(lekarDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<LekarDTO>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(value = "/removeLekar/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LekarDTO> addLekar(@RequestBody LekarDTO lekarDTO, @PathVariable Long id) throws Exception {
            lekarService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/lekarKlinikaTip/{idTipa}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Lekar>> getLekarKlinikaTip(@PathVariable Long idTipa) throws  Exception{


        TipPregleda tp = tipPregledaService.findOneById(idTipa);

        List<Lekar> lekari = new ArrayList<Lekar>();

        lekari = lekarService.lekariKlinikaTip(tp.getKlinika().getId(), tp.getSpecijalizacija());

        System.out.println("DUZINA NIZA JE: " + lekari.size());

        return new ResponseEntity<List<Lekar>>(lekari, HttpStatus.OK);
    }
}
