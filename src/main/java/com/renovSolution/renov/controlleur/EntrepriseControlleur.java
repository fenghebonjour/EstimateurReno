package com.renovSolution.renov.controlleur;


import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Entreprise;
import com.renovSolution.renov.service.EntrepriseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/entreprise")
public class EntrepriseControlleur {

    private final EntrepriseService entrepriseService ;

    public EntrepriseControlleur(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Entreprise>> getAllEntreprises(){
        List<Entreprise> entreprises =  entrepriseService.findAllEntreprises();
        return new ResponseEntity<>(entreprises, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Entreprise> getEntrepriseById(@PathVariable("id") Long id){
        Entreprise unEntreprise =  entrepriseService.findEntrepriseById(id);
        return new ResponseEntity<>(unEntreprise, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Entreprise> addEntreprise(@RequestBody Entreprise entreprise) {
        Entreprise newEntreprise = entrepriseService.addEntreprise(entreprise);
        return new ResponseEntity<>(newEntreprise, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Entreprise> updateEntreprise(@RequestBody Entreprise entreprise){

        Entreprise updatedEntreprise = entrepriseService.updateEntreprise(entreprise);
        return new ResponseEntity<>(updatedEntreprise,HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEntreprise(@PathVariable("id") Long id){
        entrepriseService.deleteEntreprise(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }



}
