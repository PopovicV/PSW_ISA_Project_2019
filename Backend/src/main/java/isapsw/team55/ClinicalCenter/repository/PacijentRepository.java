package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Pacijent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacijentRepository extends JpaRepository<Pacijent, Long> {

        Page<Pacijent> findAll(Pageable pageable);

        List<Pacijent> findAllByPrezime(String prezime);

        List<Pacijent> findByImeAndPrezimeAllIgnoringCase(String ime, String prezime);

        Pacijent findOneById(Long id);

        Pacijent save(Pacijent pacijent);

        @Query("select p from Pacijent p where p.adminAktiviraoNalog = ?1")
        List<Pacijent> pronadjiNeaktiviraneKorisnike(String uslov);

        Pacijent findByEmail(String email);

}
