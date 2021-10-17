package com.renovSolution.renov.service;


import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.AppelDOffre;
import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.OffreService;
import com.renovSolution.renov.repo.AppelDOffreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AppelDOffreService {
    private final AppelDOffreRepo appelDOffreRepo;

    @Autowired
    public AppelDOffreService(AppelDOffreRepo appelDOffreRepo) {
        this.appelDOffreRepo = appelDOffreRepo;
    }

    public List<AppelDOffre> findAllAppelOffre(){
        return  appelDOffreRepo.findAll();
    }

    public AppelDOffre findAppelOffreById(Long id){
        return  appelDOffreRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Appel D'Offre By ID"+ id +"not found"));
    }

    public AppelDOffre updateAppelOffre(AppelDOffre appelDOffre){

        return  appelDOffreRepo.save(appelDOffre);
    }

    public AppelDOffre addAppelOffre(AppelDOffre appelDOffre){
        return  appelDOffreRepo.save(appelDOffre);
    }

    public void deleteAppelOffre(Long id){

        appelDOffreRepo.deleteAppelDOffreById(id);
    }

    public List<AppelDOffre> findAppelDOffreByClientId(Long id){
        return appelDOffreRepo.findAppelDOffresByClientId(id);
    }


}
