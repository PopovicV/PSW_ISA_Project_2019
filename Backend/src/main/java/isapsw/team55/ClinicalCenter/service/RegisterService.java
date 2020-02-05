package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.repository.KorisnikRepository;
import isapsw.team55.ClinicalCenter.repository.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {

    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
    private static Pattern pattern;
    private Matcher matcher;


    @Autowired
    private PacijentRepository pacijentRepository;
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Pacijent registracijaKorisnika(Pacijent noviPacijent) {
        //VALIDACIJA PODATAKA
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(noviPacijent.getEmail());

        if (matcher.matches() && noviPacijent.getLozinka().length() >= 6) {
            Korisnik proveraPacijenta = korisnikRepository.findByEmail(noviPacijent.getEmail());
            System.out.println("EMAIL JE: " + noviPacijent.getEmail());
            System.out.println(noviPacijent.toString());
            if ((noviPacijent.getId() == null)) {
                noviPacijent.setAdminAktiviraoNalog("NE");
                noviPacijent.setPacijentAktiviraoNalog("NE");
                noviPacijent.setUloga("PACIJENT");
                noviPacijent = pacijentRepository.save(noviPacijent);

                return noviPacijent;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


}
