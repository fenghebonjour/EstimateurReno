package com.renovSolution.renov.controlleur;


import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.MainOeuvre;
import com.renovSolution.renov.service.MainOeuvreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/mainOeuvre")
public class MainOeuvreControlleur {

    private final MainOeuvreService mainOeuvreService ;

    public MainOeuvreControlleur(MainOeuvreService mainOeuvreService) {
        this.mainOeuvreService = mainOeuvreService;
    }



    @GetMapping("/all")
    public ResponseEntity<List<MainOeuvre>> getAllMainOeuvres(){
        List<MainOeuvre> mainOeuvres =  mainOeuvreService.findAllMainOeuvres();
        return new ResponseEntity<>(mainOeuvres, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<MainOeuvre> getMainOeuvreById(@PathVariable("id") Long id){
        MainOeuvre unMainOeuvre =  mainOeuvreService.findMainOeuvreById(id);
        return new ResponseEntity<>(unMainOeuvre, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MainOeuvre> addMainOeuvre(@RequestBody MainOeuvre mainOeuvre) {
        MainOeuvre newMainOeuvre = mainOeuvreService.addMainOeuvre(mainOeuvre);
        return new ResponseEntity<>(newMainOeuvre, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<MainOeuvre> updateMainOeuvre(@RequestBody MainOeuvre mainOeuvres){

        MainOeuvre updatedMainOeuvre = mainOeuvreService.updateMainOeuvre(mainOeuvres);
        return new ResponseEntity<>(updatedMainOeuvre,HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMainOeuvre(@PathVariable("id") Long id){
        mainOeuvreService.deleteMainOeuvre(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }



}
