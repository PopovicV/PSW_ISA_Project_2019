package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.AdministratorKlinickogCentra;
import isapsw.team55.ClinicalCenter.domain.KlinickiCentar;

//kada se napravi klinicki centar, potrebno je svuda dodati sve vezano za njega

public class AdministratorKlinickogCentraDTO {
    private Long id;
    private String lozinka;
    private String ime;
    private String prezime;
    private String email;
    private String kontaktTelefon;
    private KlinickiCentar klinickiCentar;

    public AdministratorKlinickogCentraDTO() {

    }

    public AdministratorKlinickogCentraDTO(Long id, String lozinka, String ime, String prezime, String email, String kontaktTelefon, KlinickiCentar klinickiCentar) {
        id = id;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.kontaktTelefon = kontaktTelefon;
        this.klinickiCentar = klinickiCentar;
    }

    public AdministratorKlinickogCentraDTO(AdministratorKlinickogCentra akc) {
        this(akc.getId(), akc.getLozinka(), akc.getIme(), akc.getPrezime(), akc.getEmail(), akc.getKontaktTelefon(), akc.getKlinickiCentar());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public KlinickiCentar getKlinickiCentar() {
        return klinickiCentar;
    }

    public void setKlinickiCentar(KlinickiCentar klinickiCentar) {
        this.klinickiCentar = klinickiCentar;
    }
}
