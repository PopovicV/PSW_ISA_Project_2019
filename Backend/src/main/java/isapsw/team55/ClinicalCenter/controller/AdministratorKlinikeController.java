package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.AdministratorKlinike;
import isapsw.team55.ClinicalCenter.dto.AdministratorKlinikeDTO;
import isapsw.team55.ClinicalCenter.service.AdministratorKlinikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
