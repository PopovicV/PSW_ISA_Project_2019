package isapsw.team55.ClinicalCenter.controller;

import isapsw.team55.ClinicalCenter.domain.ZahtevZaGodisnji;
import isapsw.team55.ClinicalCenter.dto.OdbijenicaDTO;
import isapsw.team55.ClinicalCenter.dto.ZahtevZaGodisnjiDTO;
import isapsw.team55.ClinicalCenter.service.EmailService;
import isapsw.team55.ClinicalCenter.service.ZahtevZaGodisnjiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/zahtevZaGodisnji")
public class ZahtevZaGodisnjiController {

    @Autowired
    private ZahtevZaGodisnjiService zahtevZaGodisnjiService;

    @Autowired
    private EmailService emailService;

    @GetMapping(value = "/allFromKlinika/{idKlinike}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ZahtevZaGodisnjiDTO>> getAllFromKlinika(@PathVariable Long idKlinike) {
        List<ZahtevZaGodisnji> zahtevZaGodisnjiList = zahtevZaGodisnjiService.findAllByKlinikaId(idKlinike);

        List<ZahtevZaGodisnjiDTO> zahtevZaGodisnjiDTOList = new ArrayList<>();
        for(ZahtevZaGodisnji zahtevZaGodisnji: zahtevZaGodisnjiList) {
            zahtevZaGodisnjiDTOList.add(new ZahtevZaGodisnjiDTO(zahtevZaGodisnji));
        }

        return new ResponseEntity<>(zahtevZaGodisnjiDTOList, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity odobriZahtev(@PathVariable Long id) {
        ZahtevZaGodisnji zahtevZaGodisnji = zahtevZaGodisnjiService.findOneById(id);
        String subject = "Odobren zahtev za godisnji odmor";
        String poruka = "Vas zahtev za godisnji odmor, od "+ zahtevZaGodisnji.getPocetak() + " do " +
                zahtevZaGodisnji.getKraj() +", je odobren." +
                "\n Uzivajte u slobodnim danima.";
        try {
            emailService.sendNotificationAsync(zahtevZaGodisnji.getKorisnik().getEmail(), subject, poruka);
            zahtevZaGodisnjiService.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping(value = "/odbij", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity odbijZahtev(@RequestBody OdbijenicaDTO odbijenicaDTO) {
        System.out.println(odbijenicaDTO.toString());
        ZahtevZaGodisnji zahtevZaGodisnji = zahtevZaGodisnjiService.findOneById(odbijenicaDTO.getZahtevZaGodisnji().getId());
        String subject = "Odbijen zahtev za godisnji odmor";
        String poruka = "Vas zahtev za godisnji odmor, od "+ zahtevZaGodisnji.getPocetak() + " do " +
                zahtevZaGodisnji.getKraj() +", je odbijen." +
                "Napomena:\n" + odbijenicaDTO.getNapomena();
        try {
            emailService.sendNotificationAsync(zahtevZaGodisnji.getKorisnik().getEmail(), subject, poruka);
            zahtevZaGodisnjiService.deleteById(zahtevZaGodisnji.getId());
            return new ResponseEntity(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
