package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.Korisnik;

public class KorisnikDTO {
    private Long id;
    private String email;
    private String lozinka;
    private String uloga;

    public KorisnikDTO(Long id, String email, String lozinka, String uloga) {
        this.id = id;
        this.email = email;
        this.lozinka = lozinka;
        this.uloga = uloga;
    }

    public KorisnikDTO(Korisnik k) {
        this(k.getId(), k.getEmail(), k.getLozinka(), k.getUloga());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
}
