package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.domain.Operacija;
import isapsw.team55.ClinicalCenter.dto.OperacijaDTO;
import isapsw.team55.ClinicalCenter.service.OperacijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/operacija")
public class OperacijaController {

    @Autowired
    private OperacijaService operacijaService = new OperacijaService();

    @GetMapping(value = "/pacijentOperacije", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OperacijaDTO>> operacije(@Context HttpServletRequest request) {

        Korisnik korisnik = (Korisnik) request.getSession().getAttribute("ulogovanKorisnik");

        List<Operacija> operacije = operacijaService.getOperacijePacijenta(korisnik.getId());

        if(operacije.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<OperacijaDTO> operacijeDTO = new ArrayList<>();

        for(Operacija operacija : operacije) {
            OperacijaDTO temp = new OperacijaDTO(operacija.getId(), operacija.getPacijent().getId(), operacija.getPacijent().getIme(), operacija.getPacijent().getPrezime(),operacija.getTipOperacije(), operacija.getSala().getNaziv(),operacija.getDatum(), operacija.getTrajanje(), operacija.getCena());
            operacijeDTO.add(temp);
        }

        return new ResponseEntity(operacijeDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/salaOperacije/{idSale}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OperacijaDTO>> operacije(@PathVariable Long idSale) {



        List<Operacija> operacije = operacijaService.getOperacijeSala(idSale);

        if(operacije.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<OperacijaDTO> operacijeDTO = new ArrayList<>();

        for(Operacija operacija : operacije) {
            OperacijaDTO temp = new OperacijaDTO(operacija.getId(), operacija.getPacijent().getId(), operacija.getPacijent().getIme(), operacija.getPacijent().getPrezime(),operacija.getTipOperacije(), operacija.getSala().getNaziv(),operacija.getDatum(), operacija.getTrajanje(), operacija.getCena());
            operacijeDTO.add(temp);
        }
        return new ResponseEntity(operacijeDTO, HttpStatus.OK);
    }
}
