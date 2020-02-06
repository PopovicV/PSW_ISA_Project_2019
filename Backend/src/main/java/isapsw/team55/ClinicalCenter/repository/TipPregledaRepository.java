package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.TipPregleda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipPregledaRepository extends JpaRepository<TipPregleda, Long> {
    TipPregleda findOneById(Long id);
    List<TipPregleda> findAll();
    List<TipPregleda> findAllByNaziv(String naziv);
    List<TipPregleda> findAllBySpecijalizacija(String specijalizacija);
    List<TipPregleda> findAllByKlinikaId(Long klinikaId);
}
