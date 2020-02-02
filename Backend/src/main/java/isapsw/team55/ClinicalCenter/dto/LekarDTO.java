package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.Lekar;

public class LekarDTO {
    private String ime;
    private String prezime;
    private String kontaktTelefon;
    private Long klinikaId;
    private float ocena;
    private String specijalizacija;
    private int smena;

    public LekarDTO() {

    }

    public LekarDTO(Lekar lekar) {
        this.ime = lekar.getIme();
        this.prezime = lekar.getPrezime();
        this.kontaktTelefon = lekar.getKontaktTelefon();
        this.klinikaId = lekar.getKlinika().getId();
        this.ocena = lekar.getOcena();
        this.specijalizacija = lekar.getSpecijalizacija();
        this.smena = lekar.getSmena();
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public Long getKlinikaId() {
        return klinikaId;
    }

    public void setKlinikaId(Long klinikaId) {
        this.klinikaId = klinikaId;
    }

    public float getOcena() {
        return ocena;
    }

    public void setOcena(float ocena) {
        this.ocena = ocena;
    }

    public String getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(String specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public int getSmena() {
        return smena;
    }

    public void setSmena(int smena) {
        this.smena = smena;
    }
}
