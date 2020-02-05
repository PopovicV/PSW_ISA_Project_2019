package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.Sala;

public class SalaDTO {
    private Long id;
    private Long klinikaId;
    private String naziv;

    public SalaDTO() {

    }

    public SalaDTO(Sala sala) {
        this.id = sala.getId();
        this.klinikaId = sala.getKlinika().getId();
        this.naziv = sala.getNaziv();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKlinikaId() {
        return klinikaId;
    }

    public void setKlinikaId(Long klinikaId) {
        this.klinikaId = klinikaId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
