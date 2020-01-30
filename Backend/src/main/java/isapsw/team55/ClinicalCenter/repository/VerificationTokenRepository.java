package isapsw.team55.ClinicalCenter.repository;

import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.domain.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken save(VerificationToken verificationToken);

    @Query("select vT from VerificationToken vT where vT.token = ?1")
    VerificationToken pronadjiToken(String token);
}
