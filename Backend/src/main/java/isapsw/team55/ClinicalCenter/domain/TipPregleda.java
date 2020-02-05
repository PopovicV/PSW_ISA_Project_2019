package isapsw.team55.ClinicalCenter.domain;

import javax.persistence.*;

@Entity
public class TipPregleda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cenaPregeleda", nullable = false)
    private float cenaPregleda;

    @Column(name = "naziv", nullable = false)
    private String naziv;

    @Column(name = "specijalizacija", nullable = false)
    private String specijalizacija;

    @Column(name= "trajanje", nullable = false)
    private int trajanje;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Klinika klinika;

    public TipPregleda() {
    }

    public TipPregleda(String naziv, String specijalizacija, int trajanje, Klinika klinika, float cenaPregleda) {
        this.naziv = naziv;
        this.specijalizacija = specijalizacija;
        this.trajanje = trajanje;
        this.klinika = klinika;
        this.cenaPregleda = cenaPregleda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getSpecijalizacija() {
        return specijalizacija;
    }

    public void setSpecijalizacija(String specijalizacija) {
        this.specijalizacija = specijalizacija;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

    public Klinika getKlinika() {
        return klinika;
    }

    public void setKlinika(Klinika klinika) {
        this.klinika = klinika;
    }

    public float getCenaPregleda() {
        return cenaPregleda;
    }

    public void setCenaPregleda(float cenaPregleda) {
        this.cenaPregleda = cenaPregleda;
    }
}
