package com.renovSolution.renov.repo;

import com.renovSolution.renov.model.Contracteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContracteurRepo extends JpaRepository<Contracteur,Long> {
    void deleteClientById(Long id);
}
