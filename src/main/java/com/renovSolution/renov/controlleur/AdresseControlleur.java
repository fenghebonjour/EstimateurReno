package com.renovSolution.renov.controlleur;


import com.renovSolution.renov.model.Adresse;
import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.service.AdresseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/adresse")
public class AdresseControlleur {

    private final AdresseService adresseService ;

    public AdresseControlleur(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Adresse>> getAllAdresses(){
        List<Adresse> adresses =  adresseService.findAllAdresses();
        return new ResponseEntity<>(adresses, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Adresse> getAdresseById(@PathVariable("id") Long id){
        Adresse unAdresse =  adresseService.findAdresseById(id);
        return new ResponseEntity<>(unAdresse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Adresse> addClient(@RequestBody Adresse adresse) {
        Adresse newAdresse = adresseService.addAdresse(adresse);
        return new ResponseEntity<>(newAdresse, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Adresse> updateAdresse(@RequestBody Adresse adresse){

        Adresse updatedAdresse = adresseService.updateAdresse(adresse);
        return new ResponseEntity<>(updatedAdresse,HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAdresse(@PathVariable("id") Long id){
        adresseService.deleteAdresse(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}

