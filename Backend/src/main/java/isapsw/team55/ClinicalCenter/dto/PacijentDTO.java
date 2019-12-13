package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.Pacijent;

public class PacijentDTO {

    private Long id;
    private String lozinka;
    private String ime;
    private String prezime;
    private String email;
    private String kontaktTelefon;
    private String adresa;
    private String grad;
    private String drzava;
    private String JBO;

    public PacijentDTO() {
    }

    public PacijentDTO(Long id, String lozinka, String ime, String prezime, String email, String kontaktTelefon, String adresa, String grad, String drzava, String JBO) {
        id = id;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.kontaktTelefon = kontaktTelefon;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.JBO = JBO;
    }

    public PacijentDTO (Pacijent pacijent) {
        this(pacijent.getId(), pacijent.getLozinka(), pacijent.getIme(), pacijent.getPrezime(), pacijent.getEmail(), pacijent.getKontaktTelefon(), pacijent.getAdresa(), pacijent.getGrad(), pacijent.getDrzava(), pacijent.getJbo());
    }

    public Long getId() {
        return id;
    }

    public String getLozinka() {
        return lozinka;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getEmail() {
        return email;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getGrad() {
        return grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public String getJBO() {
        return JBO;
    }
}
