package com.renovSolution.renov.repo;

import com.renovSolution.renov.model.AppelDOffre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppelDOffreRepo extends JpaRepository<AppelDOffre,Long> {
    void deleteAppelDOffreById(Long id);

    List<AppelDOffre> findAppelDOffresByClientId(Long id);
}
