package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.ZahtevZaGodisnji;

public class ZahtevZaGodisnjiDTO {
    private long id;
    private long korisnikId;
    private String pocetak;
    private String kraj;
    private long klinikaId;

    public ZahtevZaGodisnjiDTO(long id, long korisnikId, String pocetak, String kraj, long klinikaId) {
        this.id = id;
        this.korisnikId = korisnikId;
        this.pocetak = pocetak;
        this.kraj = kraj;
        this.klinikaId = klinikaId;
    }

    public ZahtevZaGodisnjiDTO() {
    }

    public ZahtevZaGodisnjiDTO(ZahtevZaGodisnji zahtevZaGodisnji) {
        this.id = zahtevZaGodisnji.getId();
        this.korisnikId = zahtevZaGodisnji.getKorisnik().getId();
        this.pocetak = zahtevZaGodisnji.getPocetak();
        this.kraj = zahtevZaGodisnji.getKraj();
        this.klinikaId = zahtevZaGodisnji.getKlinika().getId();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getPocetak() {
        return pocetak;
    }

    public void setPocetak(String pocetak) {
        this.pocetak = pocetak;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    public long getKlinikaId() {
        return klinikaId;
    }

    public void setKlinikaId(long klinikaId) {
        this.klinikaId = klinikaId;
    }
}
