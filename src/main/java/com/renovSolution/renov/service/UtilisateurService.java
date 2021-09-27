package com.renovSolution.renov.service;

import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.Utilisateur;
import com.renovSolution.renov.repo.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    private final UtilisateurRepo utilisateurRepo;

    @Autowired
    public UtilisateurService(UtilisateurRepo utilisateurRepo) {
        this.utilisateurRepo = utilisateurRepo;
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

}
