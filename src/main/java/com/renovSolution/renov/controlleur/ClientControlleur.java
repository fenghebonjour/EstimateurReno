package com.renovSolution.renov.controlleur;


import com.renovSolution.renov.model.Client;

import com.renovSolution.renov.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/client")
public class ClientControlleur {
    private final ClientService clientService ;

    public ClientControlleur(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients =  clientService.findAllClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }


}
