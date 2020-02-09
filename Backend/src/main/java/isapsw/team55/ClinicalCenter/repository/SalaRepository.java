package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Sala;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    Sala findOneById(Long id);
    Page<Sala> findAll(Pageable pageable);
    List<Sala> findAll();
    Sala findOneByNaziv(String naziv);

    @Query("SELECT sala from Sala sala where sala.klinika.id=?1")
    List<Sala> getAllFromKlinika(Long id);
}
