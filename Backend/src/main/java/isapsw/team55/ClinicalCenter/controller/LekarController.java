package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.domain.Lekar;
import isapsw.team55.ClinicalCenter.domain.TipPregleda;
import isapsw.team55.ClinicalCenter.dto.LekarDTO;
import isapsw.team55.ClinicalCenter.service.EmailService;
import isapsw.team55.ClinicalCenter.service.KlinikaService;
import isapsw.team55.ClinicalCenter.service.KorisnikService;
import isapsw.team55.ClinicalCenter.service.LekarService;
import isapsw.team55.ClinicalCenter.service.TipPregledaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import java.util.*;

@RestController
@RequestMapping("api/lekar")
public class LekarController {
    @Autowired
    private LekarService lekarService;

    @Autowired
    private KlinikaService klinikaService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private KorisnikService korisnikService;
    
    @Autowired
    private TipPregledaService tipPregledaService;


    @GetMapping(value = "/ulogovanKorisnik", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LekarDTO> getKorisnik(@Context HttpServletRequest request) {
        Korisnik korisnik = (Korisnik) request.getSession().getAttribute("ulogovanKorisnik");
        Lekar lekar = lekarService.findOneById(korisnik.getId());

        if(lekar == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("Ulogovan lekar:" + lekar.getIme());
        System.out.println(lekar.getKlinika().getId());
        return  new ResponseEntity(new LekarDTO(lekar), HttpStatus.OK);
    }

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
            try {
                Korisnik korisnik = korisnikService.findByEmail(lekarDTO.getEmail());
                String subject = "Novi lekar na klinici";
                String poruka = "Cestitamo, registrovani ste na nasoj online klinici. Molimo da se ulogujete" +
                        "i promenite lozinku. Vasa trenutna lozinka je: " + korisnik.getLozinka();
            } catch (Exception e) {
                System.out.println("NIJE POSLAT MAIL");
            }
            lekarService.save(lekar);
            return new ResponseEntity<LekarDTO>(lekarDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<LekarDTO>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(value = "/removeLekar/{id}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LekarDTO> removeLekar(@RequestBody LekarDTO lekarDTO, @PathVariable Long id) throws Exception {
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

//    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<AdministratorKlinike> updateAdministratorKlinike(@RequestBody LekarDTO administratorKlinike) throws Exception{
//        AdministratorKlinike administratorKlinike1 = lekarService.update(administratorKlinike);
//        if(administratorKlinike1 != null) {
//            return new ResponseEntity<AdministratorKlinike>(administratorKlinike1, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<AdministratorKlinike>(HttpStatus.NOT_ACCEPTABLE);
//        } }

    @GetMapping(value = "/getOneById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LekarDTO> getOneById(@PathVariable Long id) {
        Lekar lekar = lekarService.findOneById(id);

        return  new ResponseEntity(new LekarDTO(lekar), HttpStatus.OK);
    }

}
