package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.TipPregleda;
import isapsw.team55.ClinicalCenter.repository.TipPregledaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipPregledaService {
    @Autowired
    private TipPregledaRepository tipPregledaRepository;

    public TipPregleda findOneById(Long id) {return tipPregledaRepository.findOneById(id);}
    public List<TipPregleda> findAll() {return tipPregledaRepository.findAll();}
    public List<TipPregleda> findAllByNaziv(String naziv) {return tipPregledaRepository.findAllByNaziv(naziv);}
    public List<TipPregleda> findAllBySpecijalizacija(String specijalizacija){
        return tipPregledaRepository.findAllBySpecijalizacija(specijalizacija);
    }
    public TipPregleda save(TipPregleda tipPregleda) { return tipPregledaRepository.save(tipPregleda);}
    public void remove(Long id) {tipPregledaRepository.deleteById(id);}
    public TipPregleda update(TipPregleda tipPregleda) {
        return  tipPregledaRepository.save(tipPregleda);
    }
    public List<TipPregleda> findAllByKlinikaId(Long klinikaId) {
        return tipPregledaRepository.findAllByKlinikaId(klinikaId);
    }
}
