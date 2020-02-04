package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Dijagnoza;
import isapsw.team55.ClinicalCenter.repository.DijagnozaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DijagnozaService {

    @Autowired
    private DijagnozaRepository dijagnozaRepository;

    Dijagnoza findOne(Long id) { return dijagnozaRepository.findOneById(id); }

    Dijagnoza save(Dijagnoza dijagnoza) { return dijagnozaRepository.save(dijagnoza); }

    void delete(Long id) { dijagnozaRepository.deleteById(id); }

    Page<Dijagnoza> findAll(Pageable pageable) {return dijagnozaRepository.findAll(pageable); }
}
