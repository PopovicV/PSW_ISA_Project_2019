package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.AdministratorKlinike;
import isapsw.team55.ClinicalCenter.repository.AdministratorKlinikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorKlinikeService {

    @Autowired
    private AdministratorKlinikeRepository administratorKlinikeRepository;

    public AdministratorKlinike findOneById(Long id) {
        return administratorKlinikeRepository.findById(id).orElseGet(null);
    }

    public Page<AdministratorKlinike> findAll(Pageable pageable) {
        return administratorKlinikeRepository.findAll(pageable);
    }

    public List<AdministratorKlinike> findAll() {
        return administratorKlinikeRepository.findAll();
    }

    public List<AdministratorKlinike> findAllByPrezime(String prezime) {
        return administratorKlinikeRepository.findAll();
    }

    public List<AdministratorKlinike> findAllByIme(String ime) {
        return administratorKlinikeRepository.findAllByIme(ime);
    }

    public List<AdministratorKlinike> findAllByImeAndPrezime(String ime, String prezime) {
        return administratorKlinikeRepository.findAllByPrezime(prezime);
    }
    public AdministratorKlinike findOneByEmail(String email) {
        return administratorKlinikeRepository.findOneByEmail(email);
    }

    public AdministratorKlinike save(AdministratorKlinike administratorKlinike) {
        return administratorKlinikeRepository.save(administratorKlinike);
    }

    public void remove(Long id) {
        administratorKlinikeRepository.deleteById(id);
    }
}
