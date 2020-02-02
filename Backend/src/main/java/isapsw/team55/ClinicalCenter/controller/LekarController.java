package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Lekar;
import isapsw.team55.ClinicalCenter.dto.LekarDTO;
import isapsw.team55.ClinicalCenter.service.LekarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "api/lekar")
public class LekarController {
    @Autowired
    private LekarService lekarService;

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
}
