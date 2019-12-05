package isapsw.team55.ClinicalCenter.domain;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name="pacijent")
public class Pacijent extends Korisnik{

    @Column(name = "ime", nullable = false)
    private String ime;

    @Column(name = "prezime", nullable = false)
    private String prezime;


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

    @Column(name = "adminAktivirao")
    private String adminAktiviraoNalog;

    @Column(name = "pacijentAktivirao")
    private String pacijentAktiviraoNalog;


    //private ZdravstveniKarton zdravstveniKarton;
    //ArrayList<Pregled> listaPregleda = new ArrayList<Pregled>();


    public Pacijent() {
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
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

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
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


    public String getJbo() {
        return jbo;
    }

    public void setJbo(String jbo) {
        this.jbo = jbo;
    }

    public String getAdminAktiviraoNalog() {
        return adminAktiviraoNalog;
    }

    public void setAdminAktiviraoNalog(String adminAktiviraoNalog) {
        this.adminAktiviraoNalog = adminAktiviraoNalog;
    }

    public String getPacijentAktiviraoNalog() {
        return pacijentAktiviraoNalog;
    }

    public void setPacijentAktiviraoNalog(String pacijentAktiviraoNalog) {
        this.pacijentAktiviraoNalog = pacijentAktiviraoNalog;
    }

    @Override
    public String toString() {
        return "Pacijent{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", kontaktTelefon='" + kontaktTelefon + '\'' +
                ", adresa='" + adresa + '\'' +
                ", grad='" + grad + '\'' +
                ", drzava='" + drzava + '\'' +
                ", jbo='" + jbo + '\'' +
                ", adminAktiviraoNalog='" + adminAktiviraoNalog + '\'' +
                ", pacijentAktiviraoNalog='" + pacijentAktiviraoNalog + '\'' +
                '}';
    }
}
