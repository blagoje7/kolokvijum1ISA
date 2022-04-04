package kolokvijum.prvikolokvijum.service;

import kolokvijum.prvikolokvijum.model.Namirnica;
import kolokvijum.prvikolokvijum.repository.NamirnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NamirnicaService {
    @Autowired
    private NamirnicaRepository namirnicaRepository;

    public NamirnicaRepository getNamirnicaRepository() {
        return namirnicaRepository;
    }

    public void setNamirnicaRepository(NamirnicaRepository namirnicaRepository) {
        this.namirnicaRepository = namirnicaRepository;
    }

    public Iterable<Namirnica> findAll(){
        return this.namirnicaRepository.findAll();
    }

    public Optional<Namirnica> findOne(Long id){
        return this.namirnicaRepository.findById(id);
    }

    public Namirnica save(Namirnica namirnica){
        return this.namirnicaRepository.save(namirnica);
    }

    public void delete(Namirnica namirnica){
        this.namirnicaRepository.delete(namirnica);
    }

    public void delete(Long id){
        this.namirnicaRepository.deleteById(id);
    }
}
