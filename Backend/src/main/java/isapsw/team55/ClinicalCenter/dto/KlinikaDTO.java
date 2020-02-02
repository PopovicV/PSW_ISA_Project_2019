package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.Klinika;

public class KlinikaDTO {
    private Long id;
    private String ime;
    private String adresa;
    private String opis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public KlinikaDTO(Klinika klinika) {
        this.id=klinika.getId();
        this.ime = klinika.getIme();
        this.adresa = klinika.getAdresa();
        this.opis = klinika.getOpis();
    }
}
