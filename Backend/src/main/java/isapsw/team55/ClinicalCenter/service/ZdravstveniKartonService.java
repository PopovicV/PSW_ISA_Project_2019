package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Dijagnoza;
import isapsw.team55.ClinicalCenter.domain.ZdravstveniKarton;
import isapsw.team55.ClinicalCenter.repository.ZdravstveniKartonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ZdravstveniKartonService {

    @Autowired
    private ZdravstveniKartonRepository zdravstveniKartonRepository;

    public ZdravstveniKarton findOne(Long id) { return zdravstveniKartonRepository.findOneById(id);}

    public ZdravstveniKarton save(ZdravstveniKarton zdravstveniKarton) {return zdravstveniKartonRepository.save(zdravstveniKarton); }

    public void deleteById(Long id) { zdravstveniKartonRepository.deleteById(id);}

    public List<Dijagnoza> listaDijagnoza(Long pacijent_id) {
        ZdravstveniKarton zd = zdravstveniKartonRepository.findOneByPacijentId(pacijent_id);
        List<Dijagnoza> dijagnoze =  zd.getDijagnoze();
        return dijagnoze;
    }
}
