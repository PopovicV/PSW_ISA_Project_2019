package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Lekar;
import isapsw.team55.ClinicalCenter.repository.LekarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LekarService {
    @Autowired
    private LekarRepository lekarRepository;

    public Lekar findOneById(Long id) {
        return lekarRepository.findOneById(id);
    }

    public Page<Lekar> findAll(Pageable pageable) {
        return lekarRepository.findAll(pageable);
    }
    public List<Lekar> findAllByPrezime(String prezime) {
        return lekarRepository.findAllByPrezime(prezime);
    }
    public List<Lekar> findAllByIme(String ime) {
        return lekarRepository.findAllByIme(ime);
    }
    public List<Lekar> findAllByImeAndPrezime(String ime, String prezime) {
        return lekarRepository.findAllByImeAndPrezime(ime, prezime);
    }
    public Lekar findOneByEmail(String email) {
        return lekarRepository.findOneByEmail(email);
    }

    public List<Lekar> getAllFromKlinika(Long id) {
        return lekarRepository.getAllFromKlinika(id);
    }
}
