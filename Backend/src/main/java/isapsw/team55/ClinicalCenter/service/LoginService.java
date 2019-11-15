package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.repository.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private PacijentRepository pacijentRepository;

    public Pacijent proveraKorisnika(String email, String lozinka) {
        Pacijent pacijent = pacijentRepository.findByEmail(email);
        if (pacijent.getLozinka().equals(lozinka)) {
            return pacijent;
        } else {
            return null;
        }
    }
}
