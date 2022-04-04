package kolokvijum.prvikolokvijum.controller;

import kolokvijum.prvikolokvijum.dto.NamirnicaDTO;
import kolokvijum.prvikolokvijum.dto.SastojakDTO;
import kolokvijum.prvikolokvijum.model.Namirnica;
import kolokvijum.prvikolokvijum.model.Sastojak;
import kolokvijum.prvikolokvijum.service.SastojakService;
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
@RequestMapping(path = "/api/sastojci")
public class SastojakController {

    @Autowired
    private SastojakService sastojakService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<SastojakDTO>> findAllSastojak(){
        ArrayList<SastojakDTO> sastojakDTOS = new ArrayList<SastojakDTO>();

        for(Sastojak sastojak : sastojakService.findAll()){
            sastojakDTOS.add(new SastojakDTO(sastojak.getId(),sastojak.getKolicina(),
                    new NamirnicaDTO(sastojak.getNamirnica().getId(),sastojak.getNamirnica().getNaziv(),sastojak.getNamirnica().getKalorijskaVrednost(),
                            sastojak.getNamirnica().getCena(),sastojak.getNamirnica().getMernaJedinica(),null)));
        }
        return new ResponseEntity<Iterable<SastojakDTO>>(sastojakDTOS, HttpStatus.OK);
    }

    @RequestMapping(path = "{sastojakId}", method = RequestMethod.GET)
    public ResponseEntity<SastojakDTO> findOneSastojak(@PathVariable("sastojakId")Long sastojakId){
        Optional<Sastojak> sastojak = sastojakService.findOne(sastojakId);
        if(sastojak.isPresent()) {
            SastojakDTO sastojakDTO = new SastojakDTO(sastojak.get().getId(), sastojak.get().getKolicina(),
                                new NamirnicaDTO(sastojak.get().getNamirnica().getId(),sastojak.get().getNamirnica().getNaziv(),sastojak.get().getNamirnica().getKalorijskaVrednost(),
                                        sastojak.get().getNamirnica().getCena(),sastojak.get().getNamirnica().getMernaJedinica(),null));
            return new ResponseEntity<SastojakDTO>(sastojakDTO, HttpStatus.OK);
        }
        return new ResponseEntity<SastojakDTO>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "",method = RequestMethod.POST)
    public ResponseEntity<Sastojak> createSastojak(@RequestBody Sastojak sastojak){
        try {
            sastojakService.save(sastojak);
            return new ResponseEntity<Sastojak>(sastojak,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<Sastojak>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/{sastojakId}",method = RequestMethod.PUT)
    public ResponseEntity<Sastojak> updateSastojak(@PathVariable("sastojakId") Long sastojakId,
                                                     @RequestBody Sastojak izmenjenSastojak){
        Sastojak sastojak = sastojakService.findOne(sastojakId).orElse(null);
        if(sastojak!=null){
            izmenjenSastojak.setId(sastojakId);
            sastojakService.save(izmenjenSastojak);
            return new ResponseEntity<Sastojak>(izmenjenSastojak,HttpStatus.OK);
        }
        return new ResponseEntity<Sastojak>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{sastojakId}", method = RequestMethod.DELETE)
    public ResponseEntity<Sastojak> deleteSastojak(@PathVariable("sastojakId")Long sastojakId){
        if(sastojakService.findOne(sastojakId).isPresent()){
            sastojakService.delete(sastojakId);
            return new ResponseEntity<Sastojak>(HttpStatus.OK);
        }
        return new ResponseEntity<Sastojak>(HttpStatus.NOT_FOUND);
    }
}

