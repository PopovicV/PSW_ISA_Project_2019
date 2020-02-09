package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.AdministratorKlinike;
import isapsw.team55.ClinicalCenter.domain.MedicinskoOsoblje;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdministratorKlinikeRepository extends JpaRepository<AdministratorKlinike, Long> {
    AdministratorKlinike findOneById(Long id);
    Page<AdministratorKlinike> findAll(Pageable pageable);
    List<AdministratorKlinike> findAllByPrezime(String prezime);
    List<AdministratorKlinike> findAllByIme(String ime);
    List<AdministratorKlinike> findAllByImeAndPrezime(String ime, String prezime);
    AdministratorKlinike findOneByEmail(String email);

    @Query("SELECT admin from AdministratorKlinike admin where admin.klinika.id=?1")
    List<AdministratorKlinike> getAllFromKlinika(Long id);

}
