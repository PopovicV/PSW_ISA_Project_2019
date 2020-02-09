package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Korisnik;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findOneById(Long id);

    Korisnik findByEmail(String email);

    Page<Korisnik> findAll(Pageable pageable);
}
