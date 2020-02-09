package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.Zahtev;

public class ZahtevDTO {

    private String datum;

    private Long lekarId;

    private Long klinikaId;

    private Long tipPregledaId;

    private Long pacijentId;

    private String tip;

    private Long salaId;

    public ZahtevDTO(String datum, Long lekarId, Long klinikaId, Long tipPregledaId, Long pacijentId, String tip, Long salaId) {
        this.datum = datum;
        this.lekarId = lekarId;
        this.klinikaId = klinikaId;
        this.tipPregledaId = tipPregledaId;
        this.pacijentId = pacijentId;
        this.tip = tip;
        this.salaId = salaId;
    }

    public ZahtevDTO(Zahtev zahtev) {
        this.datum = zahtev.getDatum();
        this.lekarId = zahtev.getLekar().getId();
        this.klinikaId = zahtev.getKlinika().getId();
        this.tipPregledaId = zahtev.getTipPregleda().getId();
        this.pacijentId = zahtev.getPacijent().getId();
        this.tip = zahtev.getTip();
        this.salaId = zahtev.getSala().getId();
    }

    public ZahtevDTO() {
    }

    public String getDatum() {
        return datum;
    }

    public Long getLekarId() {
        return lekarId;
    }

    public Long getKlinikaId() {
        return klinikaId;
    }

    public Long getTipPregledaId() {
        return tipPregledaId;
    }

    public Long getPacijentId() {
        return pacijentId;
    }

    public String getTip() {
        return tip;
    }

    public Long getSalaId() {
        return salaId;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setLekarId(Long lekarId) {
        this.lekarId = lekarId;
    }

    public void setKlinikaId(Long klinikaId) {
        this.klinikaId = klinikaId;
    }

    public void setTipPregledaId(Long tipPregledaId) {
        this.tipPregledaId = tipPregledaId;
    }

    public void setPacijentId(Long pacijentId) {
        this.pacijentId = pacijentId;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setSalaId(Long salaId) {
        this.salaId = salaId;
    }
}
