package kolokvijum.prvikolokvijum.service;

import kolokvijum.prvikolokvijum.model.Recept;
import kolokvijum.prvikolokvijum.repository.ReceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReceptService {

    @Autowired
    private ReceptRepository receptRepository;

    public ReceptRepository getReceptRepository() {
        return receptRepository;
    }

    public void setReceptRepository(ReceptRepository receptRepository) {
        this.receptRepository = receptRepository;
    }

    public Iterable<Recept> findAll(){
        return this.receptRepository.findAll();
    }

    public Optional<Recept> findOne(Long id){
        return this.receptRepository.findById(id);
    }

    public Recept save(Recept recept){
        return this.receptRepository.save(recept);
    }

    public void delete(Recept recept){
        this.receptRepository.delete(recept);
    }

    public void delete(Long id){
        this.receptRepository.deleteById(id);
    }
}
