package com.renovSolution.renov.service;

import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Entreprise;
import com.renovSolution.renov.repo.EntrepriseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EntrepriseService {

    private final EntrepriseRepo entrepriseRepo ;


    @Autowired
    public EntrepriseService(EntrepriseRepo entrepriseRepo) {
        this.entrepriseRepo = entrepriseRepo;
    }

    public List<Entreprise> findAllEntreprises(){
        return  entrepriseRepo.findAll();
    }

    public Entreprise findEntrepriseById(Long id){
        return  entrepriseRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Entreprise By ID"+ id +"not found"));
    }

    public Entreprise updateEntreprise(Entreprise entreprise){

        return  entrepriseRepo.save(entreprise);
    }

    public Entreprise addEntreprise(Entreprise entreprise){
        return  entrepriseRepo.save(entreprise);
    }

    public void deleteEntreprise(Long id){

        entrepriseRepo.deleteEntrepriseById(id);
    }


}
