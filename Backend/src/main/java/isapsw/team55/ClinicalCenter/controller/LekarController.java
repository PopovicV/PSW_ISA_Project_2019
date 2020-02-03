package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Klinika;
import isapsw.team55.ClinicalCenter.domain.Lekar;
import isapsw.team55.ClinicalCenter.dto.LekarDTO;
import isapsw.team55.ClinicalCenter.service.KlinikaService;
import isapsw.team55.ClinicalCenter.service.LekarService;
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

    @GetMapping(value = "/allFromKlinika/{idKlinike}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LekarDTO>> getAllLekar(@PathVariable Long idKlinike) {
        List<Lekar> lekarList = lekarService.getAllFromKlinika(idKlinike);

        if(lekarList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

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
}
