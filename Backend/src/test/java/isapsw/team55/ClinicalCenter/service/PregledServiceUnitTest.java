package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.*;
import isapsw.team55.ClinicalCenter.dto.PregledDTO;
import isapsw.team55.ClinicalCenter.repository.PacijentRepository;
import isapsw.team55.ClinicalCenter.repository.PregledRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.mail.MailException;

import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PregledServiceUnitTest {

    @MockBean
    private PregledRepository pregledRepository;

    @MockBean
    private PacijentService pacijentService;

    @Autowired
    private PregledService pregledService;

    @MockBean
    private EmailService emailService;

    @Test
    public void nemaPregleda() {
        Long pregledId = 3l;
        Long pacijentId = 2l;
        Mockito.when(pregledRepository.findOneById(pregledId)).thenReturn(null);
        PregledDTO pregledDTO = pregledService.zakaziPregled(pacijentId, pregledId);
        Assert.assertNull(pregledDTO);
    }

    @Test
    public void uspesnoZakazivanje()  {
        Long pregledId = 3l;
        Long pacijentId = 2l;

        Pacijent pacijent = new Pacijent();
        pacijent.setId(pacijentId);
        Pregled pregled = new Pregled();
        pregled.setId(pregledId);
        pregled.setTipPregleda(new TipPregleda());
        pregled.getTipPregleda().setId(10l);
        pregled.setLekar(new Lekar());
        Sala sala = new Sala();
        sala.setId(6l);
        sala.setKlinika(new Klinika());
        pregled.setSala(sala);
        pregled.getLekar().setId(5l);
        pregled.setPacijent(pacijent);
        Mockito.when(pacijentService.findOne(pacijentId)).thenReturn(pacijent);
        Mockito.when(pregledRepository.findOneById(pregledId)).thenReturn(pregled);
        PregledDTO pregledDTO = pregledService.zakaziPregled(pacijentId, pregledId);


        Assert.assertNotNull(pregledDTO);
        Mockito.verify(pregledRepository, times(1)).save(pregled);
    }
}
