package com.renovSolution.renov.service;


import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.Adresse;
import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.repo.AdresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdresseService {

    private final AdresseRepo adresseRepo ;

    @Autowired
    public AdresseService(AdresseRepo adresseRepo) {
        this.adresseRepo = adresseRepo;
    }

    public List<Adresse> findAllAdresses(){
        return  adresseRepo.findAll();
    }

    public Adresse findAdresseById(Long id){
        return  adresseRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Adresse By ID"+ id +"not found"));
    }

    public Adresse updateAdresse(Adresse adresse){

        return  adresseRepo.save(adresse);
    }

    public Adresse addAdresse(Adresse adresse){
        return  adresseRepo.save(adresse);
    }

    public void deleteAdresse(Long id){

        adresseRepo.deleteAdresseById(id);
    }
}
