package com.renovSolution.renov.service;


import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.AppelDOffre;
import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Contracteur;
import com.renovSolution.renov.model.OffreService;
import com.renovSolution.renov.repo.OffreServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class OffreServiceService {

    private final OffreServiceRepo offreServiceRepo ;
    @Autowired
    public OffreServiceService(OffreServiceRepo offreServiceRepo) {
        this.offreServiceRepo = offreServiceRepo;
    }

    public List<OffreService> findAllOffreService(){
        return offreServiceRepo.findAll();
    }


    public List<OffreService> findOffreServiceByContracteurId(Long id){
        return offreServiceRepo.findOffreServicesByContracteurId(id);
    }

    public List<OffreService> findOffreServiceByAppelDOffre(Long id){
        return offreServiceRepo.findOffreServicesByAppelDOffreId(id);
    }

    public OffreService findOffreServiceById(Long id){
        return offreServiceRepo.findOffreServiceById(id).orElseThrow(()-> new UserNotFoundException("User By ID"+ id +"not found"));
    }


    public OffreService updateOffreService(OffreService offreService){

        return  offreServiceRepo.save(offreService);
    }

    public OffreService addOffreService(OffreService offreService){
        return  offreServiceRepo.save(offreService);
    }

    public void deleteOffreService(Long id){

        offreServiceRepo.deleteOffreServiceById(id);
    }









}
