package com.renovSolution.renov.repo;

import com.renovSolution.renov.model.Individus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividuRepo extends JpaRepository<Individus,Long> {
    void deleteIndividusById(Long id);
}
