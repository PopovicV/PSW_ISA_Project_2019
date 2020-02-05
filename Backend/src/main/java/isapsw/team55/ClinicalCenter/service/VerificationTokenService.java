package isapsw.team55.ClinicalCenter.service;


import isapsw.team55.ClinicalCenter.domain.VerificationToken;
import isapsw.team55.ClinicalCenter.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationTokenService {

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    public VerificationToken findByToken(String token) { return verificationTokenRepository.pronadjiToken(token); }
}
