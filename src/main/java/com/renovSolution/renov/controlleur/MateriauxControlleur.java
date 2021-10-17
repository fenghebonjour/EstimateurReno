package com.renovSolution.renov.controlleur;


import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Materiaux;
import com.renovSolution.renov.service.MateriauxService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/materiaux")
public class MateriauxControlleur {

    private final MateriauxService materiauxService;

    public MateriauxControlleur(MateriauxService materiauxService) {
        this.materiauxService = materiauxService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Materiaux>> getAllClients(){
        List<Materiaux> materiaux =  materiauxService.findAllMateriaux();
        return new ResponseEntity<>(materiaux, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Materiaux> getMateriauxById(@PathVariable("id") Long id){
        Materiaux unMateriaux =  materiauxService.findMateriauxById(id);
        return new ResponseEntity<>(unMateriaux, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Materiaux> addMateriaux(@RequestBody Materiaux client) {
        Materiaux newMateriaux = materiauxService.addMateriaux(client);
        return new ResponseEntity<>(newMateriaux, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Materiaux> updateMateriaux(@RequestBody Materiaux materiaux){

        Materiaux updatedMateriaux = materiauxService.updateMateriaux(materiaux);
        return new ResponseEntity<>(updatedMateriaux,HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMateriaux(@PathVariable("id") Long id){
        materiauxService.deleteMateriaux(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
