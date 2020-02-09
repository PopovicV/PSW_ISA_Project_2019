package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.ZahtevZaGodisnji;
import isapsw.team55.ClinicalCenter.repository.ZahtevZaGodisnjiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZahtevZaGodisnjiService {
    @Autowired
    private ZahtevZaGodisnjiRepository zahtevZaGodisnjiRepository;

    public ZahtevZaGodisnji findOneById(Long id) {return zahtevZaGodisnjiRepository.findOneById(id);};
    public List<ZahtevZaGodisnji> findAll() {return zahtevZaGodisnjiRepository.findAll();}
    public List<ZahtevZaGodisnji> findAllByKlinikaId(Long klinikaId) {return zahtevZaGodisnjiRepository.findAllByKlinikaId(klinikaId);}
    public void deleteById(Long id) {zahtevZaGodisnjiRepository.deleteById(id);}
}
