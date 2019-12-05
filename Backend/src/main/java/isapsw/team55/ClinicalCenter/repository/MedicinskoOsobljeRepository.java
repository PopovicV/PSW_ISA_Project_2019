package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.MedicinskoOsoblje;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicinskoOsobljeRepository extends JpaRepository<MedicinskoOsoblje, Long> {
    MedicinskoOsoblje findOneById(Long id);
    Page<MedicinskoOsoblje> findAll(Pageable pageable);
    List<MedicinskoOsoblje> findAllByPrezime(String prezime);
    List<MedicinskoOsoblje> findAllByIme(String ime);
    List<MedicinskoOsoblje> findAllByImeAndPrezime(String ime, String prezime);
    MedicinskoOsoblje findOneByEmail(String email);
}
