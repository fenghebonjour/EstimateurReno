package com.renovSolution.renov.service;

import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.Adresse;
import com.renovSolution.renov.model.AdresseUtilisateur;
import com.renovSolution.renov.model.AdresseUtilisateurId;
import com.renovSolution.renov.model.Utilisateur;
import com.renovSolution.renov.repo.AdresseRepo;
import com.renovSolution.renov.repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UtilisateurService {
    private final UtilisateurRepo utilisateurRepo;
    private final AdresseRepo adresseRepo;
    @Autowired
    public UtilisateurService(UtilisateurRepo utilisateurRepo,  AdresseRepo adresseRepo) {
        this.utilisateurRepo = utilisateurRepo;
        this.adresseRepo = adresseRepo ;
    }

    public Utilisateur addUtilisateur(Utilisateur utilisateur){
        return  utilisateurRepo.save(utilisateur);
    }

    public List<Utilisateur> findAllUtilisateurs(){
        return  utilisateurRepo.findAll();
    }

    public Utilisateur updateUtilisateur(Utilisateur utilisateur){

        return  utilisateurRepo.save(utilisateur);
    }


    public Utilisateur findUtilisateurById(Long id){
        return  utilisateurRepo.findUtilisateurById(id).orElseThrow(()-> new UserNotFoundException("User By ID"+ id +"not found"));

    }


    public void deleteUtilisateur(Long id){

        utilisateurRepo.deleteUtilisateurById(id);
    }

    public List<Utilisateur> findUtilisateursByUsernameAndPassword(String username, String password){
        return  utilisateurRepo.findUtilisateursByUsernameEqualsAndPasswordEquals(username, password);
    }

/*
    public Utilisateur addAddresseUtilisateur(AdresseUtilisateur adresseUtilisateur, Long id){
        Adresse adr =  new Adresse(adresseUtilisateur.getAdresse().getNumeroCiv() ,
                adresseUtilisateur.getAdresse().getAppartement(),
                adresseUtilisateur.getAdresse().getRue(),
                adresseUtilisateur.getAdresse().getVille(),
                adresseUtilisateur.getAdresse().getProvince(),
                adresseUtilisateur.getAdresse().getPays(),
                adresseUtilisateur.getAdresse().getCodePostal());
        Adresse newAdr = adresseRepo.save(adr);
        Utilisateur user = utilisateurRepo.findUtilisateurById(id).orElseThrow(()-> new UserNotFoundException("Utilisateur By ID"+ id +"not found"));;
        AdresseUtilisateurId adruser1 = new AdresseUtilisateurId(id,newAdr.getId());
        AdresseUtilisateur adrResidanceClient = new AdresseUtilisateur (adruser1,user,newAdr, adresseUtilisateur.getTypeAdresse());
        user.addAdresseToUtilisateur(adrResidanceClient);
        return utilisateurRepo.save(user);
    }
    */

}
