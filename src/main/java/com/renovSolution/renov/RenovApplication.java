package com.renovSolution.renov;

import com.renovSolution.renov.model.*;
import com.renovSolution.renov.repo.AdresseRepo;
import com.renovSolution.renov.repo.ClientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.renovSolution.renov.repo.UtilisateurRepo;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RenovApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenovApplication.class, args);

	}

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

	@Bean
	CommandLineRunner commandLineRunner(UtilisateurRepo utilisateurRepo, AdresseRepo adresseRepo,ClientRepo clientRepo) {

		return args -> {



			// Créer deux adresses

			Adresse  adr1 = new Adresse(
					"7595",
					"06",
					"Des ormeaux",
					"Anjou",
					"QC",
					"Canada",
					"H1K 2X8"
			);
			Adresse  adr2 = new Adresse(
					"12000",
					"04",
					"Morfin",
					"Lava",
					"QC",
					"Canada",
					"H1H 2X2"
			);

			// Créer un client qui herite d'un utilisateur

			Client client = new Client(
					"client",
					"client",
					LocalDate.now(),
					"client",
					"Francois",
					"Moffat",
					"francois.moffat@itsolution.com",
					"514 514 2222"
			);

			// Crééer Un appel d'Offre

			AppelDOffre ao = new AppelDOffre(
					LocalDate.now(),
					LocalDate.now().plusMonths(2),

					LocalDate.now().plusMonths(4),
					LocalDate.now().plusMonths(5),
					"Ouvert",
					"Peinture"
			);

			AppelDOffre ao1 = new AppelDOffre(
					LocalDate.now(),
					LocalDate.now().plusMonths(3),

					LocalDate.now().plusMonths(4),
					LocalDate.now().plusMonths(6),
					"Ouvert",
					"Platre"
			);
			AppelDOffre ao2 = new AppelDOffre(
					LocalDate.now(),
					LocalDate.now().plusMonths(3),

					LocalDate.now().plusMonths(4),
					LocalDate.now().plusMonths(6),
					"Ouvert",
					"Charpente"
			);



			// perssister le client

			//utilisateurRepo.save(c);

			// créer un objet pour la clé composé
			AdresseUtilisateurId adruser1 = new AdresseUtilisateurId(client.getId(), adr1.getId());
			//System.out.println(adruser1);
			// créer un élement de la relation
			AdresseUtilisateur adrResidanceClient = new AdresseUtilisateur (adruser1,client,adr1,"residence" );


			AdresseUtilisateurId adruser2 = new AdresseUtilisateurId(client.getId(), adr2.getId());
			//System.out.println(adruser2);
			AdresseUtilisateur adrTraveauxClient = new AdresseUtilisateur (adruser2,client,adr2,"traveaux" );


		// Ajouter l'Appel d'offre au Client

			//c.addAppelDOffre(ao);
			//System.out.println(adrResidanceClient);
			//System.out.println(adrResidanceClient);
			//  Ajouter les deux Adresses Aux Client

		// un client est un utilisateur
			client.addAdresseToUtilisateur(adrResidanceClient);
			client.addAdresseToUtilisateur(adrTraveauxClient);
			client.addAppelDOffre(ao);
			client.addAppelDOffre(ao1);
			client.addAppelDOffre(ao2);
			clientRepo.save(client);

			clientRepo.findById(1L).ifPresent(
					c-> {
						System.out.println("Listes des Appels d'offres: ");
						List<AppelDOffre>	listeAO = client.getAppelDOffres();
						listeAO.forEach(uneAO->{
							System.out.println(uneAO);
						});
					});


		//	System.out.println(client);

		};
	}


}

