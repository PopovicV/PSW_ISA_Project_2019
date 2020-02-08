package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Zahtev;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZahtevRepository extends JpaRepository<Zahtev, Long> {

    Zahtev findOneById(Long id);

    List<Zahtev> findAllByKlinika_Id(Long id);

    List<Zahtev> findAllByLekar_Id(Long id);

    List<Zahtev> findAllByPacijent_Id(Long id);

    List<Zahtev> findAllByTip(String tip);

    List<Zahtev> findAllBySalaId(Long id);

    Zahtev save(Zahtev zahtev);

    void deleteById(Long id);
}
