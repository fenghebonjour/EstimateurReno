package com.renovSolution.renov.controlleur;


import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Contracteur;
import com.renovSolution.renov.model.Individus;
import com.renovSolution.renov.service.IndividuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/individus")
public class IndividusControlleur {
    private final IndividuService individuService;

    public IndividusControlleur(IndividuService individuService) {
        this.individuService = individuService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Individus>> getAllIndividus(){
        List<Individus> individus =  individuService.findAllIndividus();
        return new ResponseEntity<>(individus, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Individus> getIndividusById(@PathVariable("id") Long id){
        Individus unIndividus =  individuService.findIndividusById(id);
        return new ResponseEntity<>(unIndividus, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Individus> addIndividus(@RequestBody Individus individus) {
        Individus newIndividus = individuService.addIndividus(individus);
        return new ResponseEntity<>(newIndividus, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Individus> updateIndividus(@RequestBody Individus individus){

        Individus updatedIndividus = individuService.updateIndividus(individus);
        return new ResponseEntity<>(updatedIndividus,HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIndividus(@PathVariable("id") Long id){
        individuService.deleteIndividus(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
