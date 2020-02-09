package isapsw.team55.ClinicalCenter.domain;

import javax.persistence.*;

@Entity
public class Zahtev {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "datum", nullable = false)
    private String datum;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Lekar lekar;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Klinika klinika;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private TipPregleda tipPregleda;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Pacijent pacijent;

    @Column(name = "tip", nullable = true)
    private String tip;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private Sala sala;

    @Column(name = "trajanje")
    private int trajanje;

    public Zahtev() {
    }

    public Zahtev(String datum, Lekar lekar, Klinika klinika, TipPregleda tipPregleda, Pacijent pacijent, String tip, Sala sala, int trajanje) {
        this.datum = datum;
        this.lekar = lekar;
        this.klinika = klinika;
        this.tipPregleda = tipPregleda;
        this.pacijent = pacijent;
        this.tip = tip;
        this.sala = sala;
        this.trajanje = trajanje;
    }

    public Long getId() {
        return id;
    }

    public String getDatum() {
        return datum;
    }

    public Lekar getLekar() {
        return lekar;
    }

    public Klinika getKlinika() {
        return klinika;
    }

    public TipPregleda getTipPregleda() {
        return tipPregleda;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public String getTip() {
        return tip;
    }

    public Sala getSala() {
        return sala;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setLekar(Lekar lekar) {
        this.lekar = lekar;
    }

    public void setKlinika(Klinika klinika) {
        this.klinika = klinika;
    }

    public void setTipPregleda(TipPregleda tipPregleda) {
        this.tipPregleda = tipPregleda;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }
}

