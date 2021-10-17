package com.renovSolution.renov.service;

import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.*;
import com.renovSolution.renov.repo.ClientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClientService {
    private final ClientRepo clientRepo;


    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> findAllClients(){
        return  clientRepo.findAll();
    }

    public Client findClientById(Long id){
        return  clientRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Client By ID"+ id +"not found"));
    }

    public Client updateClient(Client client){

        return  clientRepo.save(client);
    }

    public Client addClient(Client client){
        return  clientRepo.save(client);
    }

    public void deleteClient(Long id){

        clientRepo.deleteClientById(id);
    }
/*

LocalDate dateDemande, LocalDate dateLimite, LocalDate dateDebutTraveaux,
                       LocalDate dateFinTraveaux, String statut, String type

 */

    public Client addAppelOffreClient(AppelDOffre appelDOffre, Long id){
        AppelDOffre ao = new AppelDOffre(
                appelDOffre.getDateDemande(),
                appelDOffre.getDateLimite(),
                appelDOffre.getDateDebutTraveaux(),
                appelDOffre.getDateFinTraveaux(),
                appelDOffre.getStatut(),
                appelDOffre.getType()
        );  //LocalDate dateOffre, LocalDate dateValide, String statut, double montant
        Client client = clientRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Contracteur By ID"+ id +"not found"));


      client.addAppelDOffre(ao);
        return  clientRepo.save(client);

    }



}
