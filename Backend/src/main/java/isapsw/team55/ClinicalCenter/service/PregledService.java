package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.domain.Pregled;
import isapsw.team55.ClinicalCenter.dto.PregledDTO;
import isapsw.team55.ClinicalCenter.repository.PregledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PregledService {
    @Autowired
    private PregledRepository pregledRepository;

    @Autowired
    private PacijentService pacijentService;

    @Autowired
    private EmailService emailService;

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

    public List<Pregled> gellPregledRezervisan(boolean isRezervisan) { return pregledRepository.findAllByRezervisan(isRezervisan); }

    @Transactional
    public List<Pregled> getPregledPoTipuIRezervaciji(boolean isRezervisan, long tipPregledaId) { return pregledRepository.findAllByRezervisanAndTipPregleda_Id(isRezervisan, tipPregledaId); }

    public List<Pregled> findAllByTipPregledaNaziv(String tipPregeldaNaziv) {
        return pregledRepository.findAllByTipPregledaNaziv(tipPregeldaNaziv);
    }

    public List<Pregled> findAllByTipPregledaId(long tipPregledaId) {
        return pregledRepository.findAllByTipPregledaId(tipPregledaId);
    }

    public PregledDTO zakaziPregled(Long pacijentId, Long pregledId) {
        Pacijent pacijent = pacijentService.findOne(pacijentId);
        Pregled pregledZaZakazivanje = this.pregledRepository.findOneById(pregledId);

        if(pregledZaZakazivanje == null) {
            return null;
        }

        pregledZaZakazivanje.setPacijent(pacijent);
        pregledZaZakazivanje.setRezervisan(true);

        try {
            emailService.sendPotvrdaPredefinisanog(pacijent, pregledZaZakazivanje, "Pregled zakazan");
        } catch (Exception e) {
            return null;
        }

        pregledRepository.save(pregledZaZakazivanje);
        PregledDTO pregledDTO = new PregledDTO(pregledZaZakazivanje);
        return pregledDTO;
    }

    public List<Pregled> findAllByKlinikaId(Long klinikaId) {
        return pregledRepository.getAllFromKlinika(klinikaId);
    }
}
