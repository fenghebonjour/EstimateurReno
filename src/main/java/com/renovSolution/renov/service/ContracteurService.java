package com.renovSolution.renov.service;


import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.AppelDOffre;
import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Contracteur;
import com.renovSolution.renov.model.OffreService;
import com.renovSolution.renov.repo.AppelDOffreRepo;
import com.renovSolution.renov.repo.ContracteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContracteurService {
    private final ContracteurRepo contracteurRepo;
    private final AppelDOffreRepo appelDOffreRepo;

    @Autowired
    public ContracteurService(ContracteurRepo contracteurRepo, AppelDOffreRepo appelDOffreRepo) {
        this.contracteurRepo = contracteurRepo;
        this.appelDOffreRepo = appelDOffreRepo;
    }

    public List<Contracteur> findAllContracteurs(){
        return  contracteurRepo.findAll();
    }

    public Contracteur findContracteurById(Long id){
        return  contracteurRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Contracteur By ID"+ id +"not found"));
    }

    public Contracteur updateContracteur(Contracteur contracteur){

        return  contracteurRepo.save(contracteur);
    }

    public Contracteur addContracteur(Contracteur contracteur){
        return  contracteurRepo.save(contracteur);
    }

    public void deleteContracteur(Long id){

        contracteurRepo.deleteClientById(id);
    }


    public Contracteur  addOffreServiceContracteur(OffreService offreService,Long idCt,Long idAo){
        OffreService os = new OffreService(
                offreService.getDateOffre(),
                offreService.getDateValide(),
                offreService.getStatut(),
                offreService.getMontant()
                  );  //LocalDate dateOffre, LocalDate dateValide, String statut, double montant
        Contracteur contracteur = contracteurRepo.findById(idCt).orElseThrow(()-> new UserNotFoundException("Contracteur By ID"+ idCt +"not found"));
        AppelDOffre appelDoffre =  appelDOffreRepo.findById(idAo).orElseThrow(()-> new UserNotFoundException("Appel D'offre By ID"+ idAo +"not found"));

        appelDoffre.addOffreService(os);
        contracteur.addOffreService(os);
        return  contracteurRepo.save(contracteur);

    }



}
