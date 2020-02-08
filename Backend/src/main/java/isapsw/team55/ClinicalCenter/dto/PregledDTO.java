package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.Lekar;
import isapsw.team55.ClinicalCenter.domain.Pregled;
import isapsw.team55.ClinicalCenter.domain.Sala;
import isapsw.team55.ClinicalCenter.domain.TipPregleda;

public class PregledDTO {
    private Long id;
    private String datum;
    private long lekarId;
    private String lekarIme;
    private String lekarPrezime;
    private String klinikaIme;
    private long salaId;
    private String salaNaziv;
    private String tipPregledaNaziv;
    private float cenaPregleda;
    private long tipPregledaId;
    private long pacijentId;
    private boolean rezervisan;

    public PregledDTO() {
    }

    public PregledDTO(Pregled pregled) {
        this(pregled.getId(), pregled.getDatum(),
                pregled.getLekar(), pregled.getSala(), pregled.getTipPregleda(), pregled.isRezervisan());
        if(pregled.getPacijent() != null) {
            this.pacijentId = pregled.getPacijent().getId();
        }
    }

    public PregledDTO(Long id, String datum, Lekar lekar, Sala sala
            , TipPregleda tipPregleda, boolean rezervisan) {
        this.id = id;
        this.datum = datum;
        this.lekarId = lekar.getId();
        this.lekarIme = lekar.getIme();
        this.lekarPrezime = lekar.getPrezime();
        this.klinikaIme = sala.getKlinika().getIme();
        this.salaId = sala.getId();
        this.tipPregledaId = tipPregleda.getId();
        this.tipPregledaNaziv = tipPregleda.getNaziv();
        this.rezervisan = rezervisan;
        this.salaNaziv = sala.getNaziv();
        this.cenaPregleda = tipPregleda.getCenaPregleda();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public long getLekarId() {
        return lekarId;
    }

    public void setLekarId(long lekarId) {
        this.lekarId = lekarId;
    }

    public long getSalaId() {
        return salaId;
    }

    public void setSalaId(long salaId) {
        this.salaId = salaId;
    }

    public String getTipPregledaNaziv() {
        return tipPregledaNaziv;
    }

    public void setTipPregledaNaziv(String tipPregledaNaziv) {
        this.tipPregledaNaziv = tipPregledaNaziv;
    }

    public long getTipPregledaId() {
        return tipPregledaId;
    }

    public void setTipPregledaId(long tipPregledaId) {
        this.tipPregledaId = tipPregledaId;
    }

    public long getPacijentId() {
        return pacijentId;
    }

    public void setPacijentId(long pacijentId) {
        this.pacijentId = pacijentId;
    }

    public boolean isRezervisan() {
        return rezervisan;
    }

    public void setRezervisan(boolean rezervisan) {
        this.rezervisan = rezervisan;
    }

    public String getSalaNaziv() {
        return salaNaziv;
    }

    public void setSalaNaziv(String salaNaziv) {
        this.salaNaziv = salaNaziv;
    }

    public String getLekarIme() {
        return lekarIme;
    }

    public String getLekarPrezime() {
        return lekarPrezime;
    }

    public String getKlinikaIme() {
        return klinikaIme;
    }

    public void setLekarIme(String lekarIme) {
        this.lekarIme = lekarIme;
    }

    public void setLekarPrezime(String lekarPrezime) {
        this.lekarPrezime = lekarPrezime;
    }

    public void setKlinikaIme(String klinikaIme) {
        this.klinikaIme = klinikaIme;
    }

    public float getCenaPregleda() {
        return cenaPregleda;
    }

    public void setCenaPregleda(float cenaPregleda) {
        this.cenaPregleda = cenaPregleda;
    }

    

    @Override
    public String toString() {
        return "PregledDTO{" +
                "id=" + id +
                ", datum='" + datum + '\'' +
                ", lekarId=" + lekarId +
                ", lekarIme='" + lekarIme + '\'' +
                ", lekarPrezime='" + lekarPrezime + '\'' +
                ", klinikaIme='" + klinikaIme + '\'' +
                ", salaId=" + salaId +
                ", salaNaziv='" + salaNaziv + '\'' +
                ", tipPregledaNaziv='" + tipPregledaNaziv + '\'' +
                ", cenaPregleda=" + cenaPregleda +
                ", tipPregledaId=" + tipPregledaId +
                ", pacijentId=" + pacijentId +
                ", rezervisan=" + rezervisan +
                '}';
    }
}
