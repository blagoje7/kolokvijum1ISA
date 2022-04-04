package kolokvijum.prvikolokvijum.dto;

import kolokvijum.prvikolokvijum.model.Sastojak;

public class ReceptDTO {
    private Long id;
    private String naziv;
    private String postupak;
    private Double brojPorcija;

    private SastojakDTO sastojak;

    public ReceptDTO() {
        super();
    }

    public ReceptDTO(Long id, String naziv, String postupak, Double brojPorcija, SastojakDTO sastojak) {
        this.id = id;
        this.naziv = naziv;
        this.postupak = postupak;
        this.brojPorcija = brojPorcija;
        this.sastojak = sastojak;
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

    public String getPostupak() {
        return postupak;
    }

    public void setPostupak(String postupak) {
        this.postupak = postupak;
    }

    public Double getBrojPorcija() {
        return brojPorcija;
    }

    public void setBrojPorcija(Double brojPorcija) {
        this.brojPorcija = brojPorcija;
    }

    public SastojakDTO getSastojak() {
        return sastojak;
    }

    public void setSastojak(SastojakDTO sastojak) {
        this.sastojak = sastojak;
    }
}
