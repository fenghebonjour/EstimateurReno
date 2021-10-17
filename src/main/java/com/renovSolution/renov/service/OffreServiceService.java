package com.renovSolution.renov.service;


import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.*;
import com.renovSolution.renov.repo.MateriauxRepo;
import com.renovSolution.renov.repo.OffreServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@Transactional
public class OffreServiceService {

    private final OffreServiceRepo offreServiceRepo ;
    private  final MateriauxRepo materiauxRepo;



    @Autowired
    public OffreServiceService(OffreServiceRepo offreServiceRepo,MateriauxRepo materiauxRepo) {
        this.offreServiceRepo = offreServiceRepo;
       this.materiauxRepo = materiauxRepo;
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


    public OffreService addMteriaux(OdsMateriaux odsMateriaux, Long id){
        Materiaux materiaux = materiauxRepo.findById(odsMateriaux.getMateriaux().getId()).orElseThrow(()-> new UserNotFoundException("Mteriaux not found"));



        OffreService offreService = offreServiceRepo.findOffreServiceById(id).orElseThrow(()-> new UserNotFoundException("offreService By ID"+ id +"not found"));
        OdsMateriaux newMat = new  OdsMateriaux(offreService,materiaux, odsMateriaux.getQuantite(), odsMateriaux.getPrixUnitaire());
        OdsMateriauxId matId = new OdsMateriauxId(id,odsMateriaux.getMateriaux().getId());
        newMat.setId(matId);
        offreService.addMateriauToOffreService(newMat);
        return offreServiceRepo.save(offreService);
    }






}
