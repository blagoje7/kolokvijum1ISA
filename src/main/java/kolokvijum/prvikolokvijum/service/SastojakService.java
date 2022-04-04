package kolokvijum.prvikolokvijum.service;

import kolokvijum.prvikolokvijum.model.Sastojak;
import kolokvijum.prvikolokvijum.repository.SastojakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SastojakService {
    @Autowired
    private SastojakRepository sastojakRepository;

    public SastojakRepository getSastojakRepository() {
        return sastojakRepository;
    }

    public void setSastojakRepository(SastojakRepository sastojakRepository) {
        this.sastojakRepository = sastojakRepository;
    }

    public Iterable<Sastojak> findAll(){
        return this.sastojakRepository.findAll();
    }

    public Optional<Sastojak> findOne(Long id){
        return this.sastojakRepository.findById(id);
    }

    public Sastojak save(Sastojak sastojak){
        return this.sastojakRepository.save(sastojak);
    }

    public void delete(Sastojak sastojak){
        this.sastojakRepository.delete(sastojak);
    }

    public void delete(Long id){
        this.sastojakRepository.deleteById(id);
    }
}
