package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.Zahtev;

public class ZahtevDTO {
    private long id;
    private String tip;
    private long pacijentId;
    private long salaId;
    private long tipPregledaId;
    private String datum;
    private int trajanje;
    private long lekarId;
    private long klinikaId;

    public ZahtevDTO() {
    }

    public ZahtevDTO(long id, String tip, long pacijentId, long salaId, long tipPregledaId, String datum, int trajanje, long lekarId) {
        this.id = id;
        this.tip = tip;
        this.pacijentId = pacijentId;
        this.salaId = salaId;
        this.tipPregledaId = tipPregledaId;
        this.datum = datum;
        this.trajanje = trajanje;
        this.lekarId = lekarId;
    }

    public ZahtevDTO(Zahtev zahtev) {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public long getPacijentId() {
        return pacijentId;
    }

    public void setPacijentId(long pacijentId) {
        this.pacijentId = pacijentId;
    }

    public long getSalaId() {
        return salaId;
    }

    public void setSalaId(long salaId) {
        this.salaId = salaId;
    }

    public long getTipPregledaId() {
        return tipPregledaId;
    }

    public void setTipPregledaId(long tipPregledaId) {
        this.tipPregledaId = tipPregledaId;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatu(String datum) {
        this.datum = datum;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public long getLekarId() {
        return lekarId;
    }

    public void setLekarId(long lekarId) {
        this.lekarId = lekarId;
    }

    public long getKlinikaId() {
        return klinikaId;
    }

    public void setKlinikaId(long klinikaId) {
        this.klinikaId = klinikaId;
    }
}