package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Zahtev;
import isapsw.team55.ClinicalCenter.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZahtevService {

    @Autowired
    private ZahtevRepository zahtevRepository;

    public Zahtev findOneById(Long zahtev_id) { return zahtevRepository.findOneById(zahtev_id); }

    public List<Zahtev> findAllByKlinika_id(Long klinika_id) { return zahtevRepository.findAllByKlinika_Id(klinika_id); }

    public List<Zahtev> findAllByLekar_id(Long lekar_id) { return zahtevRepository.findAllByLekar_Id(lekar_id); }

    public List<Zahtev> findAllByPacijent_id(Long pacijent_id) { return zahtevRepository.findAllByPacijent_Id(pacijent_id); }

    public Zahtev save(Zahtev zahtev) { return zahtevRepository.save(zahtev); }

    public void deleteById(Long zahtev_id) { zahtevRepository.deleteById(zahtev_id); }

    public List<Zahtev> findAllByTip(String tip) { return zahtevRepository.findAllByTip(tip); }

    public List<Zahtev> findAllBySala_id(Long sala_id) { return zahtevRepository.findAllBySalaId(sala_id); }
}
