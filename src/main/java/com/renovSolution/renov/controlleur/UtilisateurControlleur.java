package com.renovSolution.renov.controlleur;

import com.renovSolution.renov.model.AdresseUtilisateur;
import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Utilisateur;
import com.renovSolution.renov.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/utilisateur")
public class UtilisateurControlleur {
    private final UtilisateurService utilisateurService;

    public UtilisateurControlleur(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }
@GetMapping("/all")
public  ResponseEntity<List<Utilisateur>> getAllUtilisateurs(){
    List<Utilisateur> utilisateurs =  utilisateurService.findAllUtilisateurs();
    return new ResponseEntity<>(utilisateurs,HttpStatus.OK);
}


    @GetMapping("/find/{id}")
    public  ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("id") Long id){
        Utilisateur utilisateur =  utilisateurService.findUtilisateurById(id);
        return new ResponseEntity<>(utilisateur,HttpStatus.OK);
    }


@PostMapping("/add")
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur){
        Utilisateur newUtilisateur = utilisateurService.addUtilisateur(utilisateur);
        return new ResponseEntity<>(newUtilisateur,HttpStatus.CREATED);

}



    @PostMapping("/update")
    public ResponseEntity<Utilisateur> updateUtilisateur(@RequestBody Utilisateur utilisateur){

        Utilisateur updatedUtilisateur = utilisateurService.updateUtilisateur(utilisateur);
        return new ResponseEntity<>(updatedUtilisateur,HttpStatus.OK);

    }


    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUtilisateur(@PathVariable("id") Long id){
         utilisateurService.deleteUtilisateur(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

/*
    @PutMapping("/addAdresse/{id}")
    public ResponseEntity<Utilisateur> addAdresseUtilisateur(@RequestBody AdresseUtilisateur adresseUtilisateur, @PathVariable("id") Long id) {
        Utilisateur newUser =utilisateurService.addAddresseUtilisateur(adresseUtilisateur,id);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }
*/


}
