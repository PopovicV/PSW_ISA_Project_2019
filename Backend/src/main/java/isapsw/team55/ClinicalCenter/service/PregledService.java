package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Pregled;
import isapsw.team55.ClinicalCenter.repository.PregledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    public Pregled update(Pregled pregled) {
        return pregledRepository.save(pregled);
    }

    public List<Pregled> findAllBySalaId(long salaId) {
        return pregledRepository.findAllBySalaId(salaId);
    }

    public List<Pregled> findAllByLekarId(long lekarId) {
        return  pregledRepository.findAllByLekarId(lekarId);
    }

    public List<Pregled> getPacijentPregledi(long pacijentId) { return pregledRepository.findAllByPacijent_Id(pacijentId); }

    public List<Pregled> findAllByTipPregledaNaziv(String tipPregeldaNaziv) {
        return pregledRepository.findAllByTipPregledaNaziv(tipPregeldaNaziv);
    }

    public List<Pregled> findAllByTipPregledaId(long tipPregledaId) {
        return pregledRepository.findAllByTipPregledaId(tipPregledaId);
    }

    public List<Pregled> findAllByKlinikaId(Long klinikaId) {
        return pregledRepository.getAllFromKlinika(klinikaId);
    }
}
