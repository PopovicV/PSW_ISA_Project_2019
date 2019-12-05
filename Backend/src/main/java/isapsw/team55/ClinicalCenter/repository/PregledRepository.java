package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Pregled;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PregledRepository extends JpaRepository<Pregled, Long> {
    Pregled findOneById(Long id);
    List<Pregled> findAllByDatum(String datum);
}
