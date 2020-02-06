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
    private String adminAktiviraoNalog;
    private String pacijentAktiviraoNalog;

    public PacijentDTO() {
    }

    public PacijentDTO(Long id, String lozinka, String ime, String prezime, String email, String kontaktTelefon, String adresa, String grad, String drzava, String JBO, String adminAktiviraoNalog, String pacijentAktiviraoNalog) {
        this.id = id;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.kontaktTelefon = kontaktTelefon;
        this.adresa = adresa;
        this.grad = grad;
        this.drzava = drzava;
        this.JBO = JBO;
        this.adminAktiviraoNalog = adminAktiviraoNalog;
        this.pacijentAktiviraoNalog = pacijentAktiviraoNalog;
    }

    public PacijentDTO (Pacijent pacijent) {
        this(pacijent.getId(), pacijent.getLozinka(), pacijent.getIme(), pacijent.getPrezime(), pacijent.getEmail(), pacijent.getKontaktTelefon(), pacijent.getAdresa(), pacijent.getGrad(), pacijent.getDrzava(), pacijent.getJbo(), pacijent.getAdminAktiviraoNalog(), pacijent.getPacijentAktiviraoNalog());
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

    public String getAdminAktiviraoNalog() {
        return adminAktiviraoNalog;
    }

    public String getPacijentAktiviraoNalog() {
        return pacijentAktiviraoNalog;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public void setJBO(String JBO) {
        this.JBO = JBO;
    }

    public void setAdminAktiviraoNalog(String adminAktiviraoNalog) {
        this.adminAktiviraoNalog = adminAktiviraoNalog;
    }

    public void setPacijentAktiviraoNalog(String pacijentAktiviraoNalog) {
        this.pacijentAktiviraoNalog = pacijentAktiviraoNalog;
    }
}
