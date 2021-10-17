package com.renovSolution.renov.controlleur;


import com.renovSolution.renov.model.*;
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


    @PostMapping("/add")
    public ResponseEntity<OffreService> addOffreService(@RequestBody OffreService offreService) {
        OffreService newClient = offreServiceService.addOffreService(offreService);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<OffreService> updateClient(@RequestBody OffreService offreService){

        OffreService updatedOffreService = offreServiceService.updateOffreService(offreService);
        return new ResponseEntity<>(updatedOffreService,HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id){
        offreServiceService.deleteOffreService(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @PutMapping("/mat/{id}")
    public ResponseEntity<OffreService> updateMatt(@RequestBody OdsMateriaux odsMateriaux,@PathVariable("id") Long id){

        OffreService updatedOffreService = offreServiceService.addMteriaux(odsMateriaux,id);
        return new ResponseEntity<>(updatedOffreService,HttpStatus.OK);

    }



}
