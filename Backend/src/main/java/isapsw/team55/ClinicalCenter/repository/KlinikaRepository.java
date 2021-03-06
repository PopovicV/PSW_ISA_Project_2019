package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.AdministratorKlinike;
import isapsw.team55.ClinicalCenter.domain.Klinika;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KlinikaRepository extends JpaRepository<Klinika, Long> {
    Klinika findOneById(Long id);
    List<Klinika> findAllByIme(String ime);
    Page<Klinika> findAll(Pageable pageable);
    Klinika findOneByIme(String ime);
    Klinika save(Klinika klinika);

    @Query("SELECT admin from AdministratorKlinike admin where admin.klinika.id=?1")
    List<AdministratorKlinike> getAdministratoriKlinike(Long id);
}
