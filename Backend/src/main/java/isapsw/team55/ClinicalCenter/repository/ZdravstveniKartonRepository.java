package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Dijagnoza;
import isapsw.team55.ClinicalCenter.domain.ZdravstveniKarton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZdravstveniKartonRepository extends JpaRepository<ZdravstveniKarton, Long> {

    ZdravstveniKarton findOneById(Long id);
    ZdravstveniKarton save(ZdravstveniKarton zdravstveniKarton);
    void deleteById(Long id);

//   @Query("select zd from ZdravstveniKarton zd where zd.pacijent.id = ?1")
//    ZdravstveniKarton findZdravstveniKarton(Long pacijent_id);

   ZdravstveniKarton findOneByPacijentId(Long id);

}
