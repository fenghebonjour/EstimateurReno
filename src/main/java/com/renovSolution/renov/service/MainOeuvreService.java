package com.renovSolution.renov.service;

import com.renovSolution.renov.exception.UserNotFoundException;
import com.renovSolution.renov.model.Client;
import com.renovSolution.renov.model.MainOeuvre;
import com.renovSolution.renov.repo.MainOeuvreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MainOeuvreService {

    private final MainOeuvreRepo mainOeuvreRepo;


    @Autowired
    public MainOeuvreService(MainOeuvreRepo mainOeuvreRepo) {
        this.mainOeuvreRepo = mainOeuvreRepo;
    }

    public List<MainOeuvre> findAllMainOeuvres(){
        return  mainOeuvreRepo.findAll();
    }

    public MainOeuvre findMainOeuvreById(Long id){
        return  mainOeuvreRepo.findById(id).orElseThrow(()-> new UserNotFoundException("MainOeuvre By ID"+ id +"not found"));
    }

    public MainOeuvre updateMainOeuvre(MainOeuvre mainOeuvre){

        return  mainOeuvreRepo.save(mainOeuvre);
    }

    public MainOeuvre addMainOeuvre(MainOeuvre mainOeuvre){
        return  mainOeuvreRepo.save(mainOeuvre);
    }

    public void deleteMainOeuvre(Long id){

        mainOeuvreRepo.deleteMainOeuvreById(id);
    }

}
