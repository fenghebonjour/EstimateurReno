package com.renovSolution.renov.service;


import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Contracteur;
import com.renovSolution.renov.model.Individus;
import com.renovSolution.renov.repo.ContracteurRepo;

import com.renovSolution.renov.repo.IndividuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividuService {

    private final IndividuRepo individuRepo;
@Autowired
    public IndividuService(IndividuRepo individuRepo) {
        this.individuRepo = individuRepo;
    }

    public List<Individus> findAllIndividus(){
        return individuRepo.findAll();
    }
}
