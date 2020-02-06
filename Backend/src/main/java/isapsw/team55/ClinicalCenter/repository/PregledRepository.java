package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Pregled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PregledRepository extends JpaRepository<Pregled, Long> {
    Pregled findOneById(Long id);
    List<Pregled> findAllByDatum(String datum);
    List<Pregled> findAll();

    //PROVERITI DA LI RADI
    List<Pregled> findAllBySalaId(long salaId);
    List<Pregled> findAllByLekarId(long lekarId);
    List<Pregled> findAllByTipPregledaNaziv(String tipPregeldaNaziv);
    List<Pregled> findAllByTipPregledaId(long tipPregledaId);
    List<Pregled> findAllByPacijent_Id(long pacijentId);

    @Query("SELECT p from Pregled p where p.sala.klinika.id=?1")
    List<Pregled> getAllFromKlinika(long klinikaId);
}
