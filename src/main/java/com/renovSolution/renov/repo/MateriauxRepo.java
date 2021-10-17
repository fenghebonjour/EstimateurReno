package com.renovSolution.renov.repo;

import com.renovSolution.renov.model.Materiaux;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MateriauxRepo extends JpaRepository<Materiaux,Long> {
    void deleteMateriauxById(Long id);

}
