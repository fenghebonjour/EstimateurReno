package com.renovSolution.renov.service;

import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.Materiaux;
import com.renovSolution.renov.repo.MateriauxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MateriauxService {

    private final MateriauxRepo materiauxRepo ;


    @Autowired
    public MateriauxService(MateriauxRepo materiauxRepo) {
        this.materiauxRepo = materiauxRepo;
    }

    public List<Materiaux> findAllMateriaux(){
        return  materiauxRepo.findAll();
    }

    public Materiaux findMateriauxById(Long id){
        return  materiauxRepo.findById(id).orElseThrow(()-> new UserNotFoundException("Materiaux By ID"+ id +"not found"));
    }

    public Materiaux updateMateriaux(Materiaux materiaux){

        return  materiauxRepo.save(materiaux);
    }

    public Materiaux addMateriaux(Materiaux materiaux){
        return  materiauxRepo.save(materiaux);
    }

    public void deleteMateriaux(Long id){

        materiauxRepo.deleteMateriauxById(id);
    }

}
