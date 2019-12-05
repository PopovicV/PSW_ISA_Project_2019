package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.repository.KorisnikRepository;
import isapsw.team55.ClinicalCenter.repository.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private PacijentRepository pacijentRepository;
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Pacijent registracijaKorisnika(Pacijent noviPacijent) {
        Korisnik proveraPacijenta = korisnikRepository.findByEmail(noviPacijent.getEmail());
        System.out.println("EMAIL JE: " + noviPacijent.getEmail());
        System.out.println(noviPacijent.toString());
        if((noviPacijent.getId() == null)) {
            noviPacijent.setAdminAktiviraoNalog("NE");
            noviPacijent.setPacijentAktiviraoNalog("NE");
            noviPacijent.setUloga("PACIJENT");
            noviPacijent = pacijentRepository.save(noviPacijent);

            return noviPacijent;
        } else {
            return null;
        }
    }


}
