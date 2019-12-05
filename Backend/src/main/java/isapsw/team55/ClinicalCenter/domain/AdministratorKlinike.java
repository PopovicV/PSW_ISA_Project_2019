package isapsw.team55.ClinicalCenter.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
public class AdministratorKlinike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lozinka", nullable = false)
    private String lozinka;

    @Column(name = "ime", nullable = false)
    private String ime;

    @Column(name = "prezime", nullable = false)
    private String prezime;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "kontaktTelefon", nullable = false)
    private String kontaktTelefon;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Klinika klinika;

    public AdministratorKlinike() {
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

    public Klinika getKlinika() {
        return klinika;
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

    public void setKlinika(Klinika klinika) {
        this.klinika = klinika;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdministratorKlinike t = (AdministratorKlinike) o;
        if (t.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, t.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
