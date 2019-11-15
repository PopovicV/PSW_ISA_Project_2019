package isapsw.team55.ClinicalCenter.domain;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pacijent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lozinka", nullable = false)
    private String lozinka;

    @Column(name = "ime", nullable = false)
    private String ime;

    @Column(name = "prezime", nullable = false)
    private String prezime;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "kontaktTelefon", nullable = false)
    private String kontaktTelefon;

    @Column(name = "adresa", nullable = false)
    private String adresa;

    @Column(name = "grad", nullable = false)
    private String grad;

    @Column(name = "drzava", nullable = false)
    private String drzava;

    @Column(name = "jbo")
    private String jbo;

    //private ZdravstveniKarton zdravstveniKarton;
    //ArrayList<Pregled> listaPregleda = new ArrayList<Pregled>();


    public Pacijent() {
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
        return jbo;
    }

    public void setId(long id) {
        id = id;
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
        this.jbo = JBO;
    }

    @Override
    public String toString() {
        return "Pacijent{" +
                "id=" + id +
                ", lozinka='" + lozinka + '\'' +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", email='" + email + '\'' +
                ", kontaktTelefon='" + kontaktTelefon + '\'' +
                ", adresa='" + adresa + '\'' +
                ", grad='" + grad + '\'' +
                ", drzava='" + drzava + '\'' +
                ", JBO='" + jbo + '\'' +
                '}';
    }
}
