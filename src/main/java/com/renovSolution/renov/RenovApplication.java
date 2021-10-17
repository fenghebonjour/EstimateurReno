package com.renovSolution.renov;

import com.renovSolution.renov.model.*;
import com.renovSolution.renov.repo.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
	CommandLineRunner commandLineRunner(UtilisateurRepo utilisateurRepo, AdresseRepo adresseRepo, ClientRepo clientRepo,
										IndividuRepo individuRepo, OffreServiceRepo offreServiceRepo) {

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
					"Mark",
					"Mitterand",
					"littirand.mark@itsolution.com",
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


 // créer un contracteur individu
			Individus indiv1 = new Individus(
					"Alain",
					"Alain",
					LocalDate.now(),
					"Individu",
					0,
					0,
					"Peinture",
					"555-555-5555",
					"alain@bell.net",
					"Flouflou",
					"Alain" ,
					"Numero2021AlainPeintre"
			);
// créer offre de service

			OffreService os = new OffreService(LocalDate.now(),LocalDate.now().plusMonths(2),"crée",500);
			OffreService os1 = new OffreService(LocalDate.now(),LocalDate.now().plusMonths(1),"crée",100);
			// creer deux materiaux
			Materiaux mat1 = new Materiaux("peinture Alpha",45);
			Materiaux mat2 = new Materiaux("peinture Beta",33);

			// creer les ID pour la table intermediaire
			OdsMateriauxId odsMatId1 = new OdsMateriauxId(os.getId(), mat1.getId());
			OdsMateriauxId odsMatId2 = new OdsMateriauxId(os.getId(), mat2.getId());


			OdsMateriauxId odsMatId3 = new OdsMateriauxId(os1.getId(), mat1.getId());
// creer les objets Ods-Materaux


			OdsMateriaux odsMat1 = new OdsMateriaux(odsMatId1,os,mat1,5,46);
			OdsMateriaux odsMat2 = new OdsMateriaux(odsMatId2,os,mat2,3,33);



			OdsMateriaux odsMat3 = new OdsMateriaux(odsMatId3,os1,mat1,7,77);


			// ajouter les OdsMateriaux à la liste dans l'offre de service

			os.addMateriauToOffreService(odsMat1);
			os.addMateriauToOffreService(odsMat2);

			os1.addMateriauToOffreService(odsMat3);

			// creer deux main d'ouvre
			MainOeuvre mdo1 = new MainOeuvre("peintre",3,35);
			MainOeuvre mdo2 = new MainOeuvre("plombier",2,40);

			// creer les deux cle composées
			OdsMainOeuvreId odsMdoId1 = new OdsMainOeuvreId(os.getId(),mdo1.getId());
			OdsMainOeuvreId odsMdoId2 = new OdsMainOeuvreId(os.getId(),mdo2.getId());

// créer les objets de la table relation
			OdsMainOeuvre odsMdo1 = new OdsMainOeuvre(odsMdoId1,os,mdo1,10,33);
			OdsMainOeuvre odsMdo2 = new OdsMainOeuvre(odsMdoId2,os,mdo2,8,42);

			// ajouter les OdsMinOeuvre à la liste dans l'offre de service
			os.addMainOeuvreToOffreService(odsMdo1);
			os.addMainOeuvreToOffreService(odsMdo2);

// rajouter l'offre de service au contracteur qui l'a générée
			indiv1.addOffreService(os);
           indiv1.addOffreService(os1);

			// rajouter l'offre de service à l'appel d'offre auquel il répond
			ao.addOffreService(os);

			ao.addOffreService(os1);

			individuRepo.save(indiv1);



			clientRepo.findById(1L).ifPresent(
					c-> {
						System.out.println("Listes des Appels d'offres: ");
						List<AppelDOffre>	listeAO = client.getAppelDOffres();
						listeAO.forEach(uneAO->{
							System.out.println(uneAO);
						});
					});
			/*List<OffreService>  offreServiceList = offreServiceRepo.findOffreServicesByContracteur(indiv1) ;
			offreServiceList.forEach(uneOS->{
				System.out.println("id de offre de service   "+uneOS.getId()+" montant "+uneOS.getMontant());
			});*/
			List<OffreService>  offreServiceList = offreServiceRepo.findOffreServicesByContracteurId(indiv1.getId()) ;
			offreServiceList.forEach(uneOS->{
				System.out.println("id de offre de service   "+uneOS.getId()+" montant "+uneOS.getMontant()+" NOM CONTRACTEUR "+uneOS.getContracteur().getUsername());
			});

		//	System.out.println(client);

		};
	}


}

