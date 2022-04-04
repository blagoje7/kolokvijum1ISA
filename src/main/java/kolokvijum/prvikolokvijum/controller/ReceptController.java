package kolokvijum.prvikolokvijum.controller;

import kolokvijum.prvikolokvijum.dto.NamirnicaDTO;
import kolokvijum.prvikolokvijum.dto.ReceptDTO;
import kolokvijum.prvikolokvijum.dto.SastojakDTO;
import kolokvijum.prvikolokvijum.model.Namirnica;
import kolokvijum.prvikolokvijum.model.Recept;
import kolokvijum.prvikolokvijum.repository.ReceptRepository;
import kolokvijum.prvikolokvijum.service.ReceptService;
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
@RequestMapping(path = "/api/recepti")
public class ReceptController {
    @Autowired
    private ReceptService receptService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseEntity<Iterable<ReceptDTO>> getAllRecept() {
        ArrayList<ReceptDTO> receptDTOS = new ArrayList<ReceptDTO>();
        for (Recept recept : receptService.findAll()) {
            receptDTOS.add(new ReceptDTO(recept.getId(), recept.getNaziv(), recept.getPostupak(), recept.getBrojPorcija(),
                    new SastojakDTO(recept.getSastojak().getId(), recept.getSastojak().getKolicina(),
                            new NamirnicaDTO(recept.getSastojak().getNamirnica().getId(), recept.getSastojak().getNamirnica().getNaziv(), recept.getSastojak().getNamirnica().getKalorijskaVrednost(),
                                    recept.getSastojak().getNamirnica().getCena(), recept.getSastojak().getNamirnica().getMernaJedinica(), null))));
        }
        return new ResponseEntity<Iterable<ReceptDTO>>(receptDTOS, HttpStatus.OK);
    }

    @RequestMapping(path = "/{receptId}", method = RequestMethod.GET)
    public ResponseEntity<ReceptDTO> getOneRecept(@PathVariable("receptId") Long receptId) {
        Optional<Recept> recept = receptService.findOne(receptId);
        if (recept.isPresent()) {
            ReceptDTO receptDTO = new ReceptDTO(recept.get().getId(), recept.get().getNaziv(), recept.get().getPostupak(), recept.get().getBrojPorcija(),
                    new SastojakDTO(recept.get().getSastojak().getId(), recept.get().getSastojak().getKolicina(),
                            new NamirnicaDTO(recept.get().getSastojak().getNamirnica().getId(), recept.get().getSastojak().getNamirnica().getNaziv(), recept.get().getSastojak().getNamirnica().getKalorijskaVrednost(),
                                    recept.get().getSastojak().getNamirnica().getCena(), recept.get().getSastojak().getNamirnica().getMernaJedinica(), null)));
            return new ResponseEntity<ReceptDTO>(receptDTO, HttpStatus.OK);
        }
        return new ResponseEntity<ReceptDTO>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Recept> createRecept(@RequestBody Recept recept) {
        try {
            receptService.save(recept);
            return new ResponseEntity<Recept>(recept, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Recept>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(path = "/{receptId}", method = RequestMethod.PUT)
    public ResponseEntity<Recept> updateNamirnica(@PathVariable("receptId") Long receptID,
                                                  @RequestBody Recept izmenjenRecept) {
        Recept recept = receptService.findOne(receptID).orElse(null);
        if (recept != null) {
            izmenjenRecept.setId(receptID);
            receptService.save(izmenjenRecept);
            return new ResponseEntity<Recept>(izmenjenRecept, HttpStatus.OK);
        }
        return new ResponseEntity<Recept>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path = "/{receptId}", method = RequestMethod.DELETE)
    public ResponseEntity<Recept> deleteRecept(@PathVariable("receptId") Long receptId) {
        if (receptService.findOne(receptId).isPresent()) {
            receptService.delete(receptId);
            return new ResponseEntity<Recept>(HttpStatus.OK);
        }
        return new ResponseEntity<Recept>(HttpStatus.NOT_FOUND);
    }
}
