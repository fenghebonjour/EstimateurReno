package com.renovSolution.renov.controlleur;


import com.renovSolution.renov.model.Adresse;
import com.renovSolution.renov.model.AdresseUtilisateur;
import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Utilisateur;
import com.renovSolution.renov.service.AdresseUtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/adresseUser")
public class AdresseUtilisateurControlleur {

    private final AdresseUtilisateurService adresseUtilisateurService ;

    public AdresseUtilisateurControlleur(AdresseUtilisateurService adresseUtilisateurService) {
        this.adresseUtilisateurService = adresseUtilisateurService;
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<Utilisateur> addAdresseUtilisateur(@RequestBody AdresseUtilisateur adresseUtilisateur, @PathVariable("id") Long id) {
      Utilisateur newUser = adresseUtilisateurService.addAddresseUtilisateur(adresseUtilisateur,id);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<List<AdresseUtilisateur>> getAllAdresseUtilisateurs(){
        List<AdresseUtilisateur> adresseusers = adresseUtilisateurService.findAllAdresseUtilisateur();
        return new ResponseEntity<>(adresseusers, HttpStatus.OK);
    }


}
