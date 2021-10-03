package com.renovSolution.renov.repo;

import com.renovSolution.renov.model.AppelDOffre;
import com.renovSolution.renov.model.Contracteur;
import com.renovSolution.renov.model.OffreService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OffreServiceRepo extends JpaRepository<OffreService,Long> {

    Optional<OffreService> findOffreServiceById(Long id);

    List<OffreService> findOffreServicesByContracteur(Contracteur contracteur);

    List<OffreService> findOffreServicesByContracteurId(Long id);

    List<OffreService> findOffreServicesByAppelDOffreId(Long id);

}
