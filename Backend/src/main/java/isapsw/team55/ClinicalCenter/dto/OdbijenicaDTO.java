package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.ZahtevZaGodisnji;

public class OdbijenicaDTO {
    private ZahtevZaGodisnjiDTO zahtevZaGodisnji;
    private String napomena;

    public OdbijenicaDTO(ZahtevZaGodisnjiDTO zahtevZaGodisnji, String napomena) {
        this.zahtevZaGodisnji = zahtevZaGodisnji;
        this.napomena = napomena;
    }

    public OdbijenicaDTO() {
    }

    public ZahtevZaGodisnjiDTO getZahtevZaGodisnji() {
        return zahtevZaGodisnji;
    }

    public void setZahtevZaGodisnji(ZahtevZaGodisnjiDTO zahtevZaGodisnji) {
        this.zahtevZaGodisnji = zahtevZaGodisnji;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String toString() {
        return "OdbijenicaDTO{" +
                "zahtevZaGodisnji=" + zahtevZaGodisnji +
                ", napomena='" + napomena + '\'' +
                '}';
    }
}
