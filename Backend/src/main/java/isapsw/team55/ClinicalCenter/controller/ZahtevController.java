package isapsw.team55.ClinicalCenter.controller;


import isapsw.team55.ClinicalCenter.domain.AdministratorKlinike;
import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.domain.Zahtev;
import isapsw.team55.ClinicalCenter.dto.ZahtevDTO;
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
@RequestMapping("api/zahtev")
public class ZahtevController {
    @Autowired
    private ZahtevService zahtevService;
    @Autowired
    private KlinikaService klinikaService;
    @Autowired
    private LekarService lekarService;
    @Autowired
    private PacijentService pacijentService;
    @Autowired
    private SalaService salaService;
    @Autowired
    private TipPregledaService tipPregledaService;

    @Autowired
    private AdministratorKlinikeService administratorKlinikeService;

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/allFromKlinika/{idKlinike}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZahtevDTO>> getAllFromKlinika(@PathVariable Long idKlinike) {
        List<Zahtev> zahtevList = zahtevService.findAllByKlinika_id(idKlinike);

        List<ZahtevDTO> zahtevDTOList = new ArrayList<>();

        for (Zahtev zahtev :
                zahtevList) {
            zahtevDTOList.add(new ZahtevDTO(zahtev));
        }

        return new ResponseEntity<List<ZahtevDTO>>(zahtevDTOList, HttpStatus.OK);
    }

    @PostMapping(value = "/addZahtev",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevDTO> addZahtev(@RequestBody ZahtevDTO zahtevDTO) throws Exception {
        Zahtev zahtev = new Zahtev();

        zahtev.setKlinika(klinikaService.findOneById(zahtevDTO.getKlinikaId()));
        zahtev.setDatum(zahtevDTO.getDatum());
        zahtev.setLekar(lekarService.findOneById(zahtevDTO.getLekarId()));
        zahtev.setPacijent(pacijentService.findOne(zahtevDTO.getPacijentId()));
        zahtev.setSala(salaService.findOneById(zahtevDTO.getSalaId()));
        zahtev.setTip(zahtevDTO.getTip());
        zahtev.setTipPregleda(tipPregledaService.findOneById(zahtevDTO.getTipPregledaId()));

        zahtevService.save(zahtev);
        return new ResponseEntity<>(zahtevDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/pacijentAddZahtev",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ZahtevDTO> pacijentAddZahtev(@RequestBody ZahtevDTO zahtevDTO, @Context HttpServletRequest request) throws Exception {
        Zahtev zahtev = new Zahtev();
        Korisnik ulogovanKorisnik = (Korisnik) request.getSession().getAttribute("ulogovanKorisnik");
        Pacijent ulogovanPacijent = pacijentService.findOne(ulogovanKorisnik.getId());
        zahtev.setKlinika(klinikaService.findOneById(zahtevDTO.getKlinikaId()));
        zahtev.setDatum(zahtevDTO.getDatum());
        zahtev.setLekar(lekarService.findOneById(zahtevDTO.getLekarId()));
        zahtev.setPacijent(pacijentService.findOne(ulogovanKorisnik.getId()));
        zahtev.setSala(salaService.findOneById(zahtevDTO.getSalaId()));
        zahtev.setTip(zahtevDTO.getTip());
        zahtev.setTipPregleda(tipPregledaService.findOneById(zahtevDTO.getTipPregledaId()));

        zahtevService.save(zahtev);

        List<AdministratorKlinike> ak = administratorKlinikeService.getAllFromKlinika(zahtevDTO.getKlinikaId());

        emailService.sendZahtevAdministratoru(ulogovanPacijent, zahtev, ak, "Novi zahtev za pregled!");
        return new ResponseEntity<>(zahtevDTO, HttpStatus.OK);
    }
}
