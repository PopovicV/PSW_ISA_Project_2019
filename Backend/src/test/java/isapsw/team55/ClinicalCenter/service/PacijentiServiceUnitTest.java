package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Pacijent;
import isapsw.team55.ClinicalCenter.repository.PacijentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PacijentiServiceUnitTest {

    @Autowired
    private PacijentService pacijentService;

    @MockBean
    private PacijentRepository pacijentRepository;

    @Test
    public void update() {
        String email = "email@email.com";
        Pacijent pacijent = new Pacijent();
        pacijent.setIme("Ime");
        pacijent.setPrezime("Prezime");
        pacijent.setLozinka("Lozinka");
        pacijent.setEmail(email);
        pacijent.setAdresa("Adresa");
        pacijent.setGrad("Grad");
        pacijent.setDrzava("Drzava");
        pacijent.setKontaktTelefon("Telefon");

        Mockito.when(pacijentRepository.findByEmail(email)).thenReturn(pacijent);
        Pacijent p = pacijentService.update(pacijent);


    }

}
