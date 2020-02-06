package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Operacija;
import isapsw.team55.ClinicalCenter.repository.OperacijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperacijaService {

    @Autowired
    OperacijaRepository operacijaRepository;

    public List<Operacija> getOperacijePacijenta(Long pacijent_id) { return operacijaRepository.findAllByPacijent_Id(pacijent_id); }

    public Page<Operacija> findAll(Pageable pageable) { return operacijaRepository.findAll(pageable); }

    public Operacija getOperacijaById(Long id) { return operacijaRepository.findOneById(id); }

    public List<Operacija> getOperacijeSala(Long id) { return operacijaRepository.findAllBySala_Id(id); }

}
