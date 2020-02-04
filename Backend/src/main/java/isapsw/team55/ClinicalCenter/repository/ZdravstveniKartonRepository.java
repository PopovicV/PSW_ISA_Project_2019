package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.ZdravstveniKarton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZdravstveniKartonRepository extends JpaRepository<ZdravstveniKarton, Long> {

    ZdravstveniKarton findOneById(Long id);
    ZdravstveniKarton save(ZdravstveniKarton zdravstveniKarton);
    void deleteById(Long id);

}
