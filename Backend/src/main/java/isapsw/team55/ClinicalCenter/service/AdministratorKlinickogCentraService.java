package isapsw.team55.ClinicalCenter.service;

import java.util.List;

import isapsw.team55.ClinicalCenter.domain.AdministratorKlinickogCentra;
import isapsw.team55.ClinicalCenter.repository.AdministratorKlinickogCentraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdministratorKlinickogCentraService {
    @Autowired
    private AdministratorKlinickogCentraRepository administratorKlinickogCentraRepository;

    public Page<AdministratorKlinickogCentra> findAll(Pageable pageable) {
        return administratorKlinickogCentraRepository.findAll(pageable);
    }

    public AdministratorKlinickogCentra findOne(Long id) {
        return administratorKlinickogCentraRepository.findById(id).orElseGet(null);
    }

    public AdministratorKlinickogCentra findByEmail(String email) {
        return administratorKlinickogCentraRepository.findByEmail(email);
    }

    public List<AdministratorKlinickogCentra> findByIme(String ime) {
        return administratorKlinickogCentraRepository.findAllByImeAllIgnoringCase(ime);
    }

    public List<AdministratorKlinickogCentra> findByPrezime(String prezime) {
        return administratorKlinickogCentraRepository.findAllByPrezimeAllIgnoringCase(prezime);
    }

    public List<AdministratorKlinickogCentra> findByImeAndPrezime(String ime, String prezime) {
        return administratorKlinickogCentraRepository.findAllByImeAndPrezimeAllIgnoringCase(ime, prezime);
    }

    public List<AdministratorKlinickogCentra> findByIPrezimeAndIme(String prezime, String ime) {
        return administratorKlinickogCentraRepository.findAllByPrezimeAndImeAllIgnoringCase(prezime, ime);
    }
}
