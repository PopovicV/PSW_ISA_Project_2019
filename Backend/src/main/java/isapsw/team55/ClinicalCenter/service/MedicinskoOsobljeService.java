package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.MedicinskoOsoblje;
import isapsw.team55.ClinicalCenter.repository.MedicinskoOsobljeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.LoggingPermission;

@Service
public class MedicinskoOsobljeService {

    @Autowired
    private MedicinskoOsobljeRepository medicinskoOsobljeRepository;

    public MedicinskoOsoblje findOneById(Long id) {
        return medicinskoOsobljeRepository.findOneById(id);
    }
    public Page<MedicinskoOsoblje> findAll(Pageable pageable) {
        return medicinskoOsobljeRepository.findAll(pageable);
    }

    public List<MedicinskoOsoblje> findAll() {
        return medicinskoOsobljeRepository.findAll();
    }

    public List<MedicinskoOsoblje> findAllByPrezime(String prezime) {
        return medicinskoOsobljeRepository.findAllByPrezime(prezime);
    }

    public List<MedicinskoOsoblje> findAllByIme(String ime) {
        return medicinskoOsobljeRepository.findAllByIme(ime);
    }

    public List<MedicinskoOsoblje> findAllByImeAndPrezime(String ime, String prezime) {
        return medicinskoOsobljeRepository.findAllByImeAndPrezime(ime, prezime);
    }

    public MedicinskoOsoblje findOneByEmail(String email) {
        return medicinskoOsobljeRepository.findOneByEmail(email);
    }

    public MedicinskoOsoblje save(MedicinskoOsoblje medicinskoOsoblje) {
        return medicinskoOsobljeRepository.save(medicinskoOsoblje);
    }

    public void remove(Long id) {
        medicinskoOsobljeRepository.deleteById(id);
    }
}
