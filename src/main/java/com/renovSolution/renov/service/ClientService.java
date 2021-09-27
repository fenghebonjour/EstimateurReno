package com.renovSolution.renov.service;

import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Utilisateur;
import com.renovSolution.renov.repo.ClientRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClientService {
    private final ClientRepo clientRepo;


    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> findAllClients(){
        return  clientRepo.findAll();
    }
}
