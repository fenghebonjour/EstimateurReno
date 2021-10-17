package com.renovSolution.renov.controlleur;

import com.renovSolution.renov.model.AppelDOffre;
import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.OffreService;
import com.renovSolution.renov.service.AppelDOffreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/appelOffre")
public class AppelDOffreControlleur {

    private final AppelDOffreService appelDOffreService ;

    public AppelDOffreControlleur(AppelDOffreService appelDOffreService) {
        this.appelDOffreService = appelDOffreService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<AppelDOffre>> getAllAppelOffres(){
        List<AppelDOffre> appelOffres =  appelDOffreService.findAllAppelOffre();
        return new ResponseEntity<>(appelOffres, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<AppelDOffre> getClientById(@PathVariable("id") Long id){
        AppelDOffre unClient =  appelDOffreService.findAppelOffreById(id);
        return new ResponseEntity<>(unClient, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AppelDOffre> addClient(@RequestBody AppelDOffre appelDOffre) {
        AppelDOffre newClient = appelDOffreService.addAppelOffre(appelDOffre);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<AppelDOffre> updateClient(@RequestBody AppelDOffre appelDOffre){

        AppelDOffre updatedClient = appelDOffreService.updateAppelOffre(appelDOffre);
        return new ResponseEntity<>(updatedClient,HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppelOffre(@PathVariable("id") Long id){
        appelDOffreService.deleteAppelOffre(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<AppelDOffre>> getAppelDOffreByClientId(@PathVariable("id") Long id){
        List<AppelDOffre> appelDOffres =   appelDOffreService.findAppelDOffreByClientId(id);
        return new ResponseEntity<>(appelDOffres, HttpStatus.OK);
    }




}
