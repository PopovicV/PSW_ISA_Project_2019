package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Pregled;
import isapsw.team55.ClinicalCenter.repository.PregledRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PregledService {
    @Autowired
    private PregledRepository pregledRepository;

    public Pregled findOneById(Long id) {
        return pregledRepository.findOneById(id);
    }

    public List<Pregled> findAllByDatum(String datum) {
        return pregledRepository.findAllByDatum(datum);
    }

    public Pregled save(Pregled pregled) {
        return pregledRepository.save(pregled);
    }

    public void remove(Long id) {
        pregledRepository.deleteById(id);
    }

}
