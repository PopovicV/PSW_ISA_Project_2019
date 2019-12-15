package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Klinika;
import isapsw.team55.ClinicalCenter.repository.KlinikaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KlinikaService {
    @Autowired
    private KlinikaRepository klinikaRepository;

    public Klinika findByIme(String ime) {return klinikaRepository.findOneByIme(ime);}

    public Klinika addKlinika(Klinika klinika) {
        return klinikaRepository.save(klinika);
    }

    public List<Klinika> getAll() {
        return klinikaRepository.findAll();
    }

    public Klinika update(Klinika klinika) {
        return klinikaRepository.save(klinika);
    }

    public Klinika findOneById(Long id) {
        return klinikaRepository.findOneById(id);
    }
}
