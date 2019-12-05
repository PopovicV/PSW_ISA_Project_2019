package isapsw.team55.ClinicalCenter.domain;

import javax.persistence.*;
import static javax.persistence.InheritanceType.JOINED;

@Entity
@Table(name="korisnik")
@Inheritance(strategy = JOINED)
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true, nullable = false)
    private Long id;

    @Column(name = "lozinka", nullable = false)
    private String lozinka;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "uloga", nullable = true)
    private String uloga;

    public Long getId() {
        return id;
    }

    public Korisnik() {
    }

    public Korisnik(String lozinka, String email, String uloga) {
        this.lozinka = lozinka;
        this.email = email;
        this.uloga = uloga;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }
}
