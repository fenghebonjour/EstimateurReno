package com.renovSolution.renov.repo;

import com.renovSolution.renov.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresseRepo extends JpaRepository<Adresse,Long> {
    void deleteAdresseById(Long id);
}
