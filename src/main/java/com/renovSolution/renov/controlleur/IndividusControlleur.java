package com.renovSolution.renov.controlleur;


import com.renovSolution.renov.model.Contracteur;
import com.renovSolution.renov.model.Individus;
import com.renovSolution.renov.service.IndividuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
