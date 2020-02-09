package isapsw.team55.ClinicalCenter.service;

import java.util.List;

import isapsw.team55.ClinicalCenter.domain.AdministratorKlinickogCentra;
import isapsw.team55.ClinicalCenter.domain.AdministratorKlinike;
import isapsw.team55.ClinicalCenter.domain.Klinika;
import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.repository.AdministratorKlinickogCentraRepository;
import isapsw.team55.ClinicalCenter.repository.KlinikaRepository;
import isapsw.team55.ClinicalCenter.repository.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdministratorKlinickogCentraService {
    @Autowired
    private AdministratorKlinickogCentraRepository administratorKlinickogCentraRepository;

    @Autowired
    private PacijentRepository pacijentRepository;

    @Autowired
    private KlinikaRepository klinikaRepository;

    public AdministratorKlinickogCentra findOneById(Long id) {
        return administratorKlinickogCentraRepository.findById(id).orElseGet(null);
    }

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

    public AdministratorKlinickogCentra save(AdministratorKlinickogCentra administratorKlinickogCentra) {
        return administratorKlinickogCentraRepository.save(administratorKlinickogCentra);
    }

    public AdministratorKlinickogCentra update(AdministratorKlinickogCentra administratorKlinickogCentra) {
        AdministratorKlinickogCentra akc = administratorKlinickogCentraRepository.findOneById(administratorKlinickogCentra.getId());

        akc.setId(administratorKlinickogCentra.getId());
        akc.setEmail(administratorKlinickogCentra.getEmail());
        akc.setLozinka(administratorKlinickogCentra.getLozinka());
        akc.setIme(administratorKlinickogCentra.getIme());
        akc.setPrezime(administratorKlinickogCentra.getPrezime());
        akc.setKontaktTelefon(administratorKlinickogCentra.getKontaktTelefon());

        return save(akc);
    }

    public void remove(Long id) {
        administratorKlinickogCentraRepository.deleteById(id);
    }

    public Pacijent aktivirajNalog(Pacijent pacijent) {
        Pacijent pacijentAkt = pacijentRepository.findByEmail(pacijent.getEmail());
        pacijentAkt.setAdminAktiviraoNalog("DA");
        return pacijentRepository.save(pacijentAkt);
    }

    public Klinika addKlinika(Klinika klinika) {
        Klinika k = klinikaRepository.findOneById(klinika.getId());
        if(k == null) {
            klinikaRepository.save(klinika);
            return  klinika;
        } else {
            return null;
        }
    }
}
