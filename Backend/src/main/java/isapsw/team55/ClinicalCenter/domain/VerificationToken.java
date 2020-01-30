package isapsw.team55.ClinicalCenter.domain;

import javax.persistence.*;

@Entity
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_token;

    private String token;

    @OneToOne(targetEntity = Pacijent.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pacijenta", referencedColumnName = "id")
    private Pacijent pacijent;

    public Long getId() {
        return id_token;
    }

    public String getToken() {
        return token;
    }

    public Pacijent getPacijent() {
        return pacijent;
    }

    public void setId(Long id) {
        this.id_token = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setPacijent(Pacijent pacijent) {
        this.pacijent = pacijent;
    }

    public VerificationToken() {

    }

    public VerificationToken(String token, Pacijent pacijent) {
        this.token = token;
        this.pacijent = pacijent;
    }
}
