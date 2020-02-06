package isapsw.team55.ClinicalCenter.dto;

public class OperacijaDTO {

    private Long id;

    private Long idPacijenta;

    private String imePacijenta;

    private String prezimePacijenta;

    private String tipOperacije;

    private String nazivSale;

    private String datum;

    private int trajanje;

    private float cena;

    public OperacijaDTO() {
    }

    public OperacijaDTO(Long id, Long idPacijenta, String imePacijenta, String prezimePacijenta, String tipOperacije, String nazivSale, String datum, int trajanje, float cena) {
        this.id = id;
        this.idPacijenta = idPacijenta;
        this.imePacijenta = imePacijenta;
        this.prezimePacijenta = prezimePacijenta;
        this.tipOperacije = tipOperacije;
        this.nazivSale = nazivSale;
        this.datum = datum;
        this.trajanje = trajanje;
        this.cena = cena;
    }

    public Long getId() {
        return id;
    }

    public Long getIdPacijenta() {
        return idPacijenta;
    }

    public String getImePacijenta() {
        return imePacijenta;
    }

    public String getPrezimePacijenta() {
        return prezimePacijenta;
    }

    public String getTipOperacije() {
        return tipOperacije;
    }

    public String getNazivSale() {
        return nazivSale;
    }

    public String getDatum() {
        return datum;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdPacijenta(Long idPacijenta) {
        this.idPacijenta = idPacijenta;
    }

    public void setImePacijenta(String imePacijenta) {
        this.imePacijenta = imePacijenta;
    }

    public void setPrezimePacijenta(String prezimePacijenta) {
        this.prezimePacijenta = prezimePacijenta;
    }

    public void setTipOperacije(String tipOperacije) {
        this.tipOperacije = tipOperacije;
    }

    public void setNazivSale(String nazivSale) {
        this.nazivSale = nazivSale;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        this.trajanje = trajanje;
    }

}
