package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Sala;
import isapsw.team55.ClinicalCenter.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    public Sala findOneById(Long id) {return salaRepository.findOneById(id);}
    public Page<Sala> findAll(Pageable pageable){return salaRepository.findAll(pageable);}
    public List<Sala> findAll(){return salaRepository.findAll();}
    public Sala findOneByNaziv(String naziv){return salaRepository.findOneByNaziv(naziv);}

    public List<Sala> getAllFromKlinika(Long id) {return salaRepository.getAllFromKlinika(id);}

    public  Sala save(Sala sala) {return salaRepository.save(sala);}
    public void remove(Long id) {salaRepository.deleteById(id);}

    public Sala update(Sala sala) {
        Sala sala1 = salaRepository.findOneById(sala.getId());
        sala1.setNaziv(sala.getNaziv());
        sala1.setKlinika(sala.getKlinika());

        return save(sala1);
    }
}
