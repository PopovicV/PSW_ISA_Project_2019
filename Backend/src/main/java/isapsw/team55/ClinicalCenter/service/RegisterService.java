package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.repository.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterService {

    @Autowired
    private PacijentRepository pacijentRepository;

    public Pacijent registracijaKorisnika(Pacijent noviPacijent) {
        Pacijent proveraPacijenta = pacijentRepository.findByEmail(noviPacijent.getEmail());
        System.out.println(noviPacijent.toString());
        if(proveraPacijenta == null && (noviPacijent.getId() == null)) {
             noviPacijent = pacijentRepository.save(noviPacijent);

            return noviPacijent;
        } else {
            return null;
        }
    }


}
