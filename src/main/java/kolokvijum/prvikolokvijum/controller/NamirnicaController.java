package kolokvijum.prvikolokvijum.controller;

import kolokvijum.prvikolokvijum.dto.NamirnicaDTO;
import kolokvijum.prvikolokvijum.model.Namirnica;
import kolokvijum.prvikolokvijum.repository.ReceptRepository;
import kolokvijum.prvikolokvijum.service.NamirnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api/namirnice")
public class NamirnicaController {
    @Autowired
    private NamirnicaService namirnicaService;


    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<NamirnicaDTO>> findAllNamirnica(){
        ArrayList<NamirnicaDTO> namirnicaDTOS = new ArrayList<NamirnicaDTO>();

        for(Namirnica namirnica : namirnicaService.findAll()){
            namirnicaDTOS.add(new NamirnicaDTO(namirnica.getId(),namirnica.getNaziv(),namirnica.getKalorijskaVrednost(),namirnica.getCena(),namirnica.getMernaJedinica(),null));
        }
        return new ResponseEntity<Iterable<NamirnicaDTO>>(namirnicaDTOS, HttpStatus.OK);
    }

    @RequestMapping(path = "{namirnicaId}", method = RequestMethod.GET)
    public ResponseEntity<NamirnicaDTO> findOneNamirnica(@PathVariable("namirnicaId")Long namirnicaId){
        Optional<Namirnica> namirnica = namirnicaService.findOne(namirnicaId);
        if(namirnica.isPresent()) {
            NamirnicaDTO namirnicaDTO = new NamirnicaDTO(namirnica.get().getId(), namirnica.get().getNaziv(), namirnica.get().getKalorijskaVrednost(), namirnica.get().getCena(), namirnica.get().getMernaJedinica(), null);
            return new ResponseEntity<NamirnicaDTO>(namirnicaDTO, HttpStatus.OK);
        }
            return new ResponseEntity<NamirnicaDTO>(HttpStatus.NOT_FOUND);
        }

    @RequestMapping(path = "",method = RequestMethod.POST)
    public ResponseEntity<Namirnica> createNamirnica(@RequestBody Namirnica namirnica){
        try {
            namirnicaService.save(namirnica);
            return new ResponseEntity<Namirnica>(namirnica,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<Namirnica>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/{namirnicaID}",method = RequestMethod.PUT)
    public ResponseEntity<Namirnica> updateNamirnica(@PathVariable("namirnicaId") Long namirnicaID,
                                                     @RequestBody Namirnica izmenjenaNamirnica){
        Namirnica namirnica = namirnicaService.findOne(namirnicaID).orElse(null);
        if(namirnica!=null){
            izmenjenaNamirnica.setId(namirnicaID);
            namirnicaService.save(izmenjenaNamirnica);
            return new ResponseEntity<Namirnica>(izmenjenaNamirnica,HttpStatus.OK);
        }
        return new ResponseEntity<Namirnica>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{namirnicaId}", method = RequestMethod.DELETE)
    public ResponseEntity<Namirnica> deleteNamirnica(@PathVariable("namirnicaID")Long namirnicaId){
        if(namirnicaService.findOne(namirnicaId).isPresent()){
            namirnicaService.delete(namirnicaId);
            return new ResponseEntity<Namirnica>(HttpStatus.OK);
        }
        return new ResponseEntity<Namirnica>(HttpStatus.NOT_FOUND);
    }

}
