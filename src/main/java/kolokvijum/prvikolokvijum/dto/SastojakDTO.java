package kolokvijum.prvikolokvijum.dto;

import kolokvijum.prvikolokvijum.model.Namirnica;

import java.util.HashSet;
import java.util.Set;

public class SastojakDTO {
    private Long id;
    private Double kolicina;

    private Namirnica namirnica;

    private Set<ReceptDTO> recepti = new HashSet<ReceptDTO>();

    public SastojakDTO(Long id, Double kolicina, NamirnicaDTO namirnicaDTO) {
        super();
    }

    public SastojakDTO(Long id, Double kolicina, Namirnica namirnica, Set<ReceptDTO> recepti) {
        this.id = id;
        this.kolicina = kolicina;
        this.namirnica = namirnica;
        this.recepti = recepti;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getKolicina() {
        return kolicina;
    }

    public void setKolicina(Double kolicina) {
        this.kolicina = kolicina;
    }

    public Namirnica getNamirnica() {
        return namirnica;
    }

    public void setNamirnica(Namirnica namirnica) {
        this.namirnica = namirnica;
    }

    public Set<ReceptDTO> getRecepti() {
        return recepti;
    }

    public void setRecepti(Set<ReceptDTO> recepti) {
        this.recepti = recepti;
    }
}
