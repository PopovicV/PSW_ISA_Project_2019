package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.TipPregleda;

public class TipPregledaDTO {
    private long id;
    private String naziv;
    private String specijalizacija;
    private int trajanje;
    private long klinikaId;
    private float cenaPregleda;

    public TipPregledaDTO() {
    }

    public TipPregledaDTO(TipPregleda tipPregleda) {
        this.id = tipPregleda.getId();
        this.naziv = tipPregleda.getNaziv();
        this.specijalizacija = tipPregleda.getSpecijalizacija();
        this.trajanje = tipPregleda.getTrajanje();
        this.klinikaId = tipPregleda.getKlinika().getId();
        this.cenaPregleda = tipPregleda.getCenaPregleda();
    }

    public TipPregledaDTO(Long id, String naziv, String specijalizacija, int trajanje, long klinikaId, float cenaPregleda) {
        this.id = id;
        this.naziv = naziv;
        this.specijalizacija = specijalizacija;
        this.trajanje = trajanje;
        this.klinikaId = klinikaId;
        this.cenaPregleda = cenaPregleda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(String specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public long getKlinikaId() {
        return klinikaId;
    }

    public void setKlinikaId(long klinikaId) {
        this.klinikaId = klinikaId;
    }

    public float getCenaPregleda() {
        return cenaPregleda;
    }

    public void setCenaPregleda(float cenaPregleda) {
        this.cenaPregleda = cenaPregleda;
    }
}
