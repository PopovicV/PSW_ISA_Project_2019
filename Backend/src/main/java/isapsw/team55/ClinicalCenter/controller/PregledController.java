package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.domain.Pregled;
import isapsw.team55.ClinicalCenter.dto.PregledDTO;
import isapsw.team55.ClinicalCenter.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.*;

@RestController
@RequestMapping("api/pregled")
public class PregledController {
    @Autowired
    private PregledService pregledService;
    @Autowired
    private LekarService lekarService;
    @Autowired
    private PacijentService pacijentService;
    @Autowired
    private SalaService salaService;
    @Autowired
    private TipPregledaService tipPregledaService;

    @GetMapping(value = "/allFromSala/{idSale}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PregledDTO>> getAllFromSala(@PathVariable Long idSale) {
        List<Pregled> pregledList = pregledService.findAllBySalaId(idSale);

        List<PregledDTO> pregledDTOList = new ArrayList<>();
        for(Pregled pregled: pregledList) {
            pregledDTOList.add(new PregledDTO(pregled));
        }

        return new ResponseEntity<>(pregledDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/allFromLekar/{idLekara}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PregledDTO>> getAllFromLekar(@PathVariable Long idLekara) {
        List<Pregled> pregledList = pregledService.findAllByLekarId(idLekara);

        List<PregledDTO> pregledDTOList = new ArrayList<>();
        for(Pregled pregled: pregledList) {
            pregledDTOList.add(new PregledDTO(pregled));
        }

        return new ResponseEntity<>(pregledDTOList, HttpStatus.OK);
    }

    @PostMapping(value = "/addPregled",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PregledDTO> addPregled(@RequestBody PregledDTO pregledDTO) throws Exception {
        System.out.println(pregledDTO.toString());
        Pregled pregled = new Pregled();
        pregled.setDatum(pregledDTO.getDatum());
        pregled.setLekar(lekarService.findOneById(pregledDTO.getLekarId()));
        pregled.setRezervisan(pregledDTO.isRezervisan());
        if(pregledDTO.getPacijentId()!=0) {
            pregled.setPacijent(pacijentService.findOne(pregledDTO.getPacijentId()));
        }
        pregled.setSala(salaService.findOneById(pregledDTO.getSalaId()));
        pregled.setTipPregleda(tipPregledaService.findOneById(pregledDTO.getTipPregledaId()));

        System.out.println(pregled.toString());

        pregledService.save(pregled);
        return new ResponseEntity<PregledDTO>(pregledDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/removePregled/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addLekar(@PathVariable Long id) throws Exception {
        pregledService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/pacijentPregledi", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PregledDTO>> pacijentPregledi(@Context HttpServletRequest request) {
        Korisnik korisnik = (Korisnik) request.getSession().getAttribute("ulogovanKorisnik");

        List<Pregled> pregledi = pregledService.getPacijentPregledi(korisnik.getId());

        if(pregledi.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<PregledDTO> preglediDTO = new ArrayList<>();

        for(Pregled pregled : pregledi) {
            PregledDTO temp = new PregledDTO(pregled);
            preglediDTO.add(temp);
        }

        return new ResponseEntity(preglediDTO, HttpStatus.OK);
    }
}
