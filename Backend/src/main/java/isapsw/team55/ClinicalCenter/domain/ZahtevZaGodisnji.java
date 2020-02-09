package isapsw.team55.ClinicalCenter.domain;

import javax.persistence.*;

@Entity
public class ZahtevZaGodisnji {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Korisnik korisnik;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Klinika klinika;

    @Column(name = "pocetak", nullable = false)
    private String pocetak;

    @Column(name = "kraj", nullable = false)
    private String kraj;

    public ZahtevZaGodisnji() {
    }

    public ZahtevZaGodisnji(Korisnik korisnik, Klinika klinika, String pocetak, String kraj) {
        this.korisnik = korisnik;
        this.klinika = klinika;
        this.pocetak = pocetak;
        this.kraj = kraj;
    }

    public Klinika getKlinika() {
        return klinika;
    }

    public void setKlinika(Klinika klinika) {
        this.klinika = klinika;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public String getPocetak() {
        return pocetak;
    }

    public void setPocetak(String pocetak) {
        this.pocetak = pocetak;
    }

    public String getKraj() {
        return kraj;
    }

    public void setKraj(String kraj) {
        this.kraj = kraj;
    }

    @Override
    public String toString() {
        return "ZahtevZaGodisnji{" +
                "id=" + id +
                ", korisnik=" + korisnik +
                ", pocetak='" + pocetak + '\'' +
                ", kraj='" + kraj + '\'' +
                '}';
    }
}
