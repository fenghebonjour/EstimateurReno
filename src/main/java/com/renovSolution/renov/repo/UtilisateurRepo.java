package com.renovSolution.renov.repo;

import com.renovSolution.renov.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UtilisateurRepo extends JpaRepository<Utilisateur,Long> {
     void deleteUtilisateurById(Long id);

     Optional<Utilisateur> findUtilisateurById(Long id);
     List<Utilisateur>  findUtilisateursByUsernameEqualsAndPasswordEquals(String username, String password);
}
