package isapsw.team55.ClinicalCenter.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import isapsw.team55.ClinicalCenter.domain.AdministratorKlinickogCentra;

import java.util.List;

public interface AdministratorKlinickogCentraRepository extends JpaRepository<AdministratorKlinickogCentra, Long> {
    Page<AdministratorKlinickogCentra> findAll(Pageable pageable);

    AdministratorKlinickogCentra findOneById(Long id);
    AdministratorKlinickogCentra findByEmail(String email);
    List<AdministratorKlinickogCentra> findAllByImeAllIgnoringCase(String ime);
    List<AdministratorKlinickogCentra> findAllByPrezimeAllIgnoringCase(String prezime);
    List<AdministratorKlinickogCentra> findAllByImeAndPrezimeAllIgnoringCase(String ime, String prezime);
    //ovo nam mozda nece trebati, ali nek stoji
    List<AdministratorKlinickogCentra> findAllByPrezimeAndImeAllIgnoringCase(String prezime, String ime);
}
