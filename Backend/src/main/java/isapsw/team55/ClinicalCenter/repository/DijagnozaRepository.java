package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Dijagnoza;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

@Repository
public interface DijagnozaRepository extends JpaRepository<Dijagnoza, Long> {

    Dijagnoza findOneById(Long id);
    Dijagnoza save(Dijagnoza dijagnoza);
    void deleteById(Long id);
    Page<Dijagnoza> findAll(Pageable pageable);

}
