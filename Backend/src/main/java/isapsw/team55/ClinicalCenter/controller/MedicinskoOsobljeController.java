package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.MedicinskoOsoblje;
import isapsw.team55.ClinicalCenter.repository.MedicinskoOsobljeRepository;
import isapsw.team55.ClinicalCenter.service.MedicinskoOsobljeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/medicinskoOsoblje")
public class MedicinskoOsobljeController {
    @Autowired
    private MedicinskoOsobljeService medicinskoOsobljeService;

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MedicinskoOsoblje> updateMedicinskoOsoblje(@RequestBody MedicinskoOsoblje medicinskoOsoblje) throws Exception{
        MedicinskoOsoblje medicinskoOsoblje1 = medicinskoOsobljeService.update(medicinskoOsoblje);
        if(medicinskoOsoblje1 != null) {
            return new ResponseEntity<MedicinskoOsoblje>(medicinskoOsoblje1, HttpStatus.OK);
        } else {
            return new ResponseEntity<MedicinskoOsoblje>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
