package com.renovSolution.renov.repo;

import com.renovSolution.renov.model.Entreprise;
import com.renovSolution.renov.model.Individus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepo extends JpaRepository<Entreprise,Long> {
    void deleteEntrepriseById(Long id);
}
