package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Pacijent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacijentRepository extends JpaRepository<Pacijent, Long> {

        Pacijent findOneById(Long id);

        Pacijent findByEmail(String email);

        Page<Pacijent> findAll(Pageable pageable);

        List<Pacijent> findAllByPrezime(String prezime);

        List<Pacijent> findByImeAndPrezimeAllIgnoringCase(String ime, String prezime);

        Pacijent save(Pacijent pacijent);

}
