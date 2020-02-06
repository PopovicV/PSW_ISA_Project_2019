package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.TipPregleda;
import isapsw.team55.ClinicalCenter.dto.TipPregledaDTO;
import isapsw.team55.ClinicalCenter.service.KlinikaService;
import isapsw.team55.ClinicalCenter.service.TipPregledaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.SchemaOutputResolver;
import java.util.*;
import java.util.List;

@RestController
@RequestMapping("api/tipPregleda")
public class TipPregledaController {
    @Autowired
    private TipPregledaService tipPregledaService;
    @Autowired
    private KlinikaService klinikaService;

    @GetMapping(value = "/allFromKlinika/{idKlinike}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TipPregledaDTO>> getAllFromKlinika(@PathVariable Long idKlinike) {
        List<TipPregleda> tipPregledaList = tipPregledaService.findAllByKlinikaId(idKlinike);

        List<TipPregledaDTO> tipPregledaDTOList = new ArrayList<>();
        for(TipPregleda tipPregleda: tipPregledaList) {
            tipPregledaDTOList.add(new TipPregledaDTO(tipPregleda));
        }

        return new ResponseEntity<>(tipPregledaDTOList, HttpStatus.OK);
    }

    @PostMapping(value = "/addTipPregleda",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipPregledaDTO> addTipPregleda(@RequestBody TipPregledaDTO tipPregledaDTO) throws Exception {
        TipPregleda tipPregleda = new TipPregleda();
        tipPregleda.setNaziv(tipPregledaDTO.getNaziv());
        tipPregleda.setKlinika(klinikaService.findOneById(tipPregledaDTO.getKlinikaId()));
        tipPregleda.setSpecijalizacija(tipPregledaDTO.getSpecijalizacija());
        tipPregleda.setTrajanje(tipPregledaDTO.getTrajanje());
        tipPregleda.setCenaPregleda(tipPregledaDTO.getCenaPregleda());

        System.out.println(tipPregledaDTO);
        System.out.println(tipPregleda);
        if(tipPregledaService.findAllByNaziv(tipPregleda.getNaziv()).size()==0) {
            tipPregledaService.save(tipPregleda);
            return new ResponseEntity<TipPregledaDTO>(tipPregledaDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<TipPregledaDTO>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(value = "/removeTipPregleda/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity removeTipPregleda(@PathVariable Long id) throws Exception {
        System.out.println("STIGAO ZAHTEV ZA REMOVE TIP PREGLEDA ID " + id);
        tipPregledaService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/updateTipPregleda",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TipPregledaDTO> updateTipPregleda(@RequestBody TipPregledaDTO tipPregledaDTO) throws Exception {
        TipPregleda tipPregleda = tipPregledaService.findOneById(tipPregledaDTO.getId());
        tipPregleda.setNaziv(tipPregledaDTO.getNaziv());
        tipPregleda.setKlinika(klinikaService.findOneById(tipPregledaDTO.getKlinikaId()));
        tipPregleda.setSpecijalizacija(tipPregledaDTO.getSpecijalizacija());
        tipPregleda.setTrajanje(tipPregledaDTO.getTrajanje());
        tipPregleda.setCenaPregleda(tipPregledaDTO.getCenaPregleda());


        tipPregledaService.update(tipPregleda);
        return new ResponseEntity<TipPregledaDTO>(tipPregledaDTO, HttpStatus.OK);
    }
}
