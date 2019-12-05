package isapsw.team55.ClinicalCenter.dto;

import isapsw.team55.ClinicalCenter.domain.Lekar;
import isapsw.team55.ClinicalCenter.domain.Pregled;
import isapsw.team55.ClinicalCenter.domain.Sala;

public class PregledDTO {
    private Long id;
    private float cenaPregleda;
    private String datum;
    private Lekar lekar;
    private Sala sala;

    public PregledDTO() {
    }

    public PregledDTO(Pregled pregled) {
        this(pregled.getId(), pregled.getCenaPregleda(), pregled.getDatum(),
                pregled.getLekar(), pregled.getSala());
    }

    public PregledDTO(Long id, float cenaPregleda, String datum, Lekar lekar, Sala sala) {
        this.id = id;
        this.cenaPregleda = cenaPregleda;
        this.datum = datum;
        this.lekar = lekar;
        this.sala = sala;
    }
}
