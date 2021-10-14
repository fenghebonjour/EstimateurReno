package com.renovSolution.renov.controlleur;


import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Contracteur;
import com.renovSolution.renov.model.OffreService;
import com.renovSolution.renov.model.Utilisateur;
import com.renovSolution.renov.repo.OffreServiceRepo;
import com.renovSolution.renov.service.OffreServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offreservice")
public class OffreServiceControlleur {
    private final OffreServiceService offreServiceService;


    public OffreServiceControlleur(OffreServiceService offreServiceService) {
        this.offreServiceService = offreServiceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OffreService>> getAllOffreService(){
        List<OffreService> offreServices =  offreServiceService.findAllOffreService();
        return new ResponseEntity<>(offreServices, HttpStatus.OK);
    }

    @GetMapping("/contracteur/{id}")
    public ResponseEntity<List<OffreService>> getOffreServiceByContracteurId(@PathVariable("id") Long id){
        List<OffreService> offreServices =  offreServiceService.findOffreServiceByContracteurId(id);
        return new ResponseEntity<>(offreServices, HttpStatus.OK);
    }


    @GetMapping("/appeloffre/{id}")
    public ResponseEntity<List<OffreService>> getOffreServiceByAppelOffreId(@PathVariable("id") Long id){
        List<OffreService> offreServices =  offreServiceService.findOffreServiceByAppelDOffre(id);
        return new ResponseEntity<>(offreServices, HttpStatus.OK);
    }


}
