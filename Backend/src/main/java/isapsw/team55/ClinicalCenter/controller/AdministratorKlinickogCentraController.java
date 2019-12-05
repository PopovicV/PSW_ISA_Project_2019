package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.AdministratorKlinickogCentra;
import isapsw.team55.ClinicalCenter.dto.AdministratorKlinickogCentraDTO;
import isapsw.team55.ClinicalCenter.service.AdministratorKlinickogCentraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/administratorKlinickogCentra")
public class AdministratorKlinickogCentraController {
    @Autowired
    AdministratorKlinickogCentraService administratorKlinickogCentraService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AdministratorKlinickogCentraDTO>> getAllAdministratorKlinickogCentra(Pageable page) {

        Page<AdministratorKlinickogCentra> administratoriKlinickogCentra = administratorKlinickogCentraService.findAll(page);

        // convert administratorKlinickogCentra to DTOs
        List<AdministratorKlinickogCentraDTO> administratorKlinickogCentraDTO = new ArrayList<>();
        for (AdministratorKlinickogCentra akc : administratoriKlinickogCentra) {
            administratorKlinickogCentraDTO.add(new AdministratorKlinickogCentraDTO(akc));
        }

        return new ResponseEntity<>(administratorKlinickogCentraDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdministratorKlinickogCentraDTO> getAdministratorKlinickogCentra(@PathVariable("id") Long id) {

        AdministratorKlinickogCentra akc = administratorKlinickogCentraService.findOne(id);

        // mora postojati administrator klinickog centra
        if (akc == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new AdministratorKlinickogCentraDTO(akc), HttpStatus.OK);
    }
}
