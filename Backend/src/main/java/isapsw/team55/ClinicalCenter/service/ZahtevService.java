package isapsw.team55.ClinicalCenter.service;

import isapsw.team55.ClinicalCenter.domain.Pregled;
import isapsw.team55.ClinicalCenter.domain.Sala;
import isapsw.team55.ClinicalCenter.domain.Zahtev;
import isapsw.team55.ClinicalCenter.repository.ZahtevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Service
public class ZahtevService {

    @Autowired
    private ZahtevRepository zahtevRepository;

    @Autowired
    private PregledService pregledService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SalaService salaService;

    public Zahtev findOneById(Long zahtev_id) { return zahtevRepository.findOneById(zahtev_id); }

    public List<Zahtev> findAllByKlinika_id(Long klinika_id) { return zahtevRepository.findAllByKlinika_Id(klinika_id); }

    public List<Zahtev> findAllByLekar_id(Long lekar_id) { return zahtevRepository.findAllByLekar_Id(lekar_id); }

    public List<Zahtev> findAllByPacijent_id(Long pacijent_id) { return zahtevRepository.findAllByPacijent_Id(pacijent_id); }

    @Transactional
    public Zahtev save(Zahtev zahtev) { return zahtevRepository.save(zahtev); }

    public void deleteById(Long zahtev_id) { zahtevRepository.deleteById(zahtev_id); }

    public List<Zahtev> findAllByTip(String tip) { return zahtevRepository.findAllByTip(tip); }

    public List<Zahtev> findAllBySala_id(Long sala_id) { return zahtevRepository.findAllBySalaId(sala_id); }

    public Pregled automatskaRezervacija(Zahtev zahtev) throws ParseException {
        List<Pregled> pregledList = pregledService.findAllByKlinikaId(zahtev.getKlinika().getId());

        if(pregledList == null) {
            Pregled newPregled = new Pregled(zahtev);
            pregledService.save(newPregled);

            //TODO: OBAVESTITI MASU MEJLOM
            return newPregled;
        }

        Sala trazenaSala = salaService.findOneById(zahtev.getSala().getId());

        if(trazenaSala == null) {
            return null;
        }

        List<Pregled> pregledInSala = new ArrayList<Pregled>();
        for (Pregled pregled: pregledList) {
            if(pregled.getSala().getId() == trazenaSala.getId()) {
                pregledInSala.add(pregled);
            }
        }

        for (Pregled pregled: pregledInSala) {
            String pocetakPregleda = pregled.getDatum();
            int trajanjePregleda = pregled.getTipPregleda().getTrajanje();

            String datumPregleda = pocetakPregleda.split("|")[0];
            String vremePocetkaPregleda = pocetakPregleda.split("|")[1];

            int satPocetka = Integer.parseInt(vremePocetkaPregleda.split(":")[0]);
            int minPocetka = Integer.parseInt(vremePocetkaPregleda.split(":")[1]);

            int satKraj = satPocetka + (minPocetka + trajanjePregleda) % 60;
            int minKraj = minPocetka + (minPocetka + trajanjePregleda) / 60;

            String pocetakZahteva = zahtev.getDatum();
            int trajanjeZahteva = zahtev.getTipPregleda().getTrajanje();

            String datumZahteva = pocetakZahteva.split("|")[0];
            String vremePocetkaZahteva = pocetakZahteva.split("|")[1];

            int satPocetkaZahteva = Integer.parseInt(vremePocetkaZahteva.split(":")[0]);
            int minPocetkaZahteva = Integer.parseInt(vremePocetkaZahteva.split(":")[1]);

            int satKrajZahteva = satPocetkaZahteva + (minPocetkaZahteva + trajanjeZahteva) % 60;
            int minKrajZahteva = minPocetkaZahteva + (minPocetkaZahteva + trajanjeZahteva) / 60;

            if(satPocetka > satKrajZahteva || satKraj < satPocetkaZahteva) {
                continue;
            }

            if(satPocetka == satKrajZahteva) {
                if(minPocetka > minKrajZahteva) {
                    continue;
                } else {
                    try {
                        zahtev = pronadjiSalu(zahtev, pregled.getSala(), datumPregleda, satKraj, minKraj);
                    } catch (Exception e) {
                        System.out.println("Unable to parse!");
                        return null;
                    }
                    if(zahtev == null) {
                        return null;
                    }
                    Pregled newPregled = new Pregled(zahtev);
                    pregledService.save(newPregled);

                    //TODO: OBAVESTITI MASU MEJLOM
                    return newPregled;
                }
            }

            if(satKraj == satPocetkaZahteva) {
                if(minKraj < minPocetkaZahteva) {
                    continue;
                } else {
                    try {
                        zahtev = pronadjiSalu(zahtev, pregled.getSala(), datumPregleda, satKraj, minKraj);
                    } catch (Exception e) {
                        System.out.println("Unable to parse!");
                        return null;
                    }
                    if(zahtev == null) {
                        return null;
                    }
                    Pregled newPregled = new Pregled(zahtev);
                    pregledService.save(newPregled);

                    //TODO: OBAVESTITI MASU MEJLOM
                    return newPregled;
                }
            }

            if(satPocetka < satPocetkaZahteva && satKraj > satPocetkaZahteva) {
                try {
                    zahtev = pronadjiSalu(zahtev, pregled.getSala(), datumPregleda, satKraj, minKraj);
                } catch (Exception e) {
                    System.out.println("Unable to parse!");
                    return null;
                }

                if(zahtev == null) {
                    return null;
                }
                Pregled newPregled = new Pregled(zahtev);
                pregledService.save(newPregled);

                //TODO: OBAVESTITI MASU MEJLOM
                return newPregled;
            }

            if(satPocetka < satKrajZahteva && satKraj > satKrajZahteva) {
                try {
                    zahtev = pronadjiSalu(zahtev, pregled.getSala(), datumPregleda, satKraj, minKraj);
                } catch (Exception e) {
                    System.out.println("Unable to parse!");
                    return null;
                }

                if(zahtev == null) {
                    return null;
                }
                Pregled newPregled = new Pregled(zahtev);
                pregledService.save(newPregled);

                //TODO: OBAVESTITI MASU MEJLOM
                return newPregled;
            }


        }

        Pregled newPregled = new Pregled(zahtev);
        pregledService.save(newPregled);


        //TODO: OBAVESTITI MASU MEJLOM
        return newPregled;
    }

    private Zahtev pronadjiSalu(Zahtev zahtev, Sala sala, String datumPregleda, int satKraj, int minKraj) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy|hh:mm", Locale.ENGLISH);
        cal.setTime(sdf.parse(datumPregleda));

        List<Pregled> pregledList = pregledService.findAllBySalaId(sala.getId());

        return zahtev;
    }
}
