package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Operacija;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface OperacijaRepository extends JpaRepository<Operacija, Long> {

    List<Operacija> findAllByPacijent_Id(Long pacijent_id);

    Page<Operacija> findAll(Pageable pageable);

    Operacija findOneById(Long id);

    List<Operacija> findAllBySala_Id(Long id);


}
