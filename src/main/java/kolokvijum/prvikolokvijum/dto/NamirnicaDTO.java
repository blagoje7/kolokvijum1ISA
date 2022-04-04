package kolokvijum.prvikolokvijum.dto;

import kolokvijum.prvikolokvijum.model.Sastojak;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class NamirnicaDTO {
    private Long id;
    private String naziv;
    private Double kalorijskaVrednost;
    private Double cena;
    private String mernaJedinica;

    private Set<SastojakDTO> sastojci = new HashSet<SastojakDTO>();

    public NamirnicaDTO() {
        super();
    }

    public NamirnicaDTO(Long id, String naziv, Double kalorijskaVrednost, Double cena, String mernaJedinica, Set<SastojakDTO> sastojci) {
        this.id = id;
        this.naziv = naziv;
        this.kalorijskaVrednost = kalorijskaVrednost;
        this.cena = cena;
        this.mernaJedinica = mernaJedinica;
        this.sastojci = sastojci;
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

    public Double getKalorijskaVrednost() {
        return kalorijskaVrednost;
    }

    public void setKalorijskaVrednost(Double kalorijskaVrednost) {
        this.kalorijskaVrednost = kalorijskaVrednost;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getMernaJedinica() {
        return mernaJedinica;
    }

    public void setMernaJedinica(String mernaJedinica) {
        this.mernaJedinica = mernaJedinica;
    }

    public Set<SastojakDTO> getSastojci() {
        return sastojci;
    }

    public void setSastojci(Set<SastojakDTO> sastojci) {
        this.sastojci = sastojci;
    }
}
