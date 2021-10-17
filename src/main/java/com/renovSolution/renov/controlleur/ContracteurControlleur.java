package com.renovSolution.renov.controlleur;


import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Contracteur;
import com.renovSolution.renov.model.OffreService;
import com.renovSolution.renov.service.ContracteurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/contracteur")
public class ContracteurControlleur {

    private final ContracteurService contracteurService;

    public ContracteurControlleur(ContracteurService contracteurService) {
        this.contracteurService = contracteurService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contracteur>> getAllContracteurs(){

        List<Contracteur> contracteurs = contracteurService.findAllContracteurs();
        return new ResponseEntity<>(contracteurs, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Contracteur> getContracteurtById(@PathVariable("id") Long id){
        Contracteur unContracteur =  contracteurService.findContracteurById(id);
        return new ResponseEntity<>(unContracteur, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Contracteur> addContracteur(@RequestBody Contracteur contracteur) {
        Contracteur newContracteur = contracteurService.addContracteur(contracteur);
        return new ResponseEntity<>(newContracteur, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Contracteur> updateContracteur(@RequestBody Contracteur contracteur){

        Contracteur updatedContracteur = contracteurService.updateContracteur(contracteur);
        return new ResponseEntity<>(updatedContracteur,HttpStatus.OK);

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContracteur(@PathVariable("id") Long id){
        contracteurService.deleteContracteur(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @PutMapping("/addOffreService/{idCt}/{idAo}")
    public ResponseEntity<Contracteur> updateContracteurOffreService(@RequestBody OffreService offreService,
                                                         @PathVariable("idCt") Long idCt,@PathVariable("idCt") Long idAo){

        Contracteur updatedContracteur = contracteurService.addOffreServiceContracteur(offreService,idCt,idAo);
        return new ResponseEntity<>(updatedContracteur,HttpStatus.OK);

    }


}
