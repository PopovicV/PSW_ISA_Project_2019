package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.ZahtevZaGodisnji;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ZahtevZaGodisnjiRepository extends JpaRepository<ZahtevZaGodisnji, Long> {
    ZahtevZaGodisnji findOneById(Long id);
    List<ZahtevZaGodisnji> findAll();
    List<ZahtevZaGodisnji> findAllByKlinikaId(Long id);
    void deleteById(Long id);
}
