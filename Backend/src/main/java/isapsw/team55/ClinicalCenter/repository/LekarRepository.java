package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Lekar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LekarRepository extends JpaRepository<Lekar, Long> {
    Lekar findOneById(Long id);
    Page<Lekar> findAll(Pageable pageable);
    List<Lekar> findAllByPrezime(String prezime);
    List<Lekar> findAllByIme(String ime);
    List<Lekar> findAllByImeAndPrezime(String ime, String prezime);
    List<Lekar> findAllBySpecijalizacija(String specijalizacija);
    Lekar findOneByEmail(String email);

    List<Lekar> findAllByKlinikaIdAndSpecijalizacija(Long id, String specijalizacija);

    @Query("SELECT lekar from Lekar lekar where lekar.klinika.id=?1")
    List<Lekar> getAllFromKlinika(Long id);
}
