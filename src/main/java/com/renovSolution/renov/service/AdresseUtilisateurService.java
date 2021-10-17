package com.renovSolution.renov.service;


import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.*;
import com.renovSolution.renov.repo.AdresseRepo;
import com.renovSolution.renov.repo.AdresseUtilisateurRepo;
import com.renovSolution.renov.repo.ClientRepo;
import com.renovSolution.renov.repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdresseUtilisateurService  {

    private final UtilisateurRepo utilisateurRepo;
    private final AdresseUtilisateurRepo adresseUtilisateurRepo;
    private final AdresseRepo adresseRepo;
    @Autowired
    public AdresseUtilisateurService(UtilisateurRepo utilisateurRepo,
                                     AdresseUtilisateurRepo adresseUtilisateurRepo,
                                     AdresseRepo adresseRepo) {
        this.utilisateurRepo = utilisateurRepo;
        this.adresseUtilisateurRepo = adresseUtilisateurRepo;
       this.adresseRepo =adresseRepo;
    }
/*
    public Utilisateur addAddresseUtilisateur(Adresse adresse, Long id,String type){
        Adresse adr =  new Adresse(adresse.getNumeroCiv() , adresse.getAppartement(), adresse.getRue(), adresse.getVille(),
                adresse.getProvince(), adresse.getPays(), adresse.getCodePostal());

     Utilisateur user = utilisateurRepo.findUtilisateurById(id).orElseThrow(()-> new UserNotFoundException("Utilisateur By ID"+ id +"not found"));;
        AdresseUtilisateurId adruser1 = new AdresseUtilisateurId(id,adresse.getId());
        AdresseUtilisateur adrResidanceClient = new AdresseUtilisateur (adruser1,user,adresse,type);
        user.addAdresseToUtilisateur(adrResidanceClient);
        return utilisateurRepo.save(user);
    }
*/

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

        adrResidanceClient.setId(adruser1);


        user.addAdresseToUtilisateur(adrResidanceClient);
        return utilisateurRepo.save(user);
    }



    public List<AdresseUtilisateur> findAllAdresseUtilisateur() {
       return adresseUtilisateurRepo.findAll();
    }
}
