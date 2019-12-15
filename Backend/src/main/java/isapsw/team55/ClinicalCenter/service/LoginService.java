package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.repository.KorisnikRepository;
import isapsw.team55.ClinicalCenter.repository.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik proveraKorisnika(String email, String lozinka) {
        Korisnik korisnik = korisnikRepository.findByEmail(email);
        if (korisnik == null) {
            System.out.println("Ne postoji korisnik sa unetom email adresom.");
            return null;
        } else {
            if (korisnik.getLozinka().equals(lozinka)) {
                return korisnik;
            } else {
                System.out.println("Uneta sifra nije odgovarajuca.");
                return null;
            }
        }
    }
}
