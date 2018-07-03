package org.norsys.pamela.webhookapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.norsys.pamela.webhookapi.fixture.MedecinFixture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ApiControllerTestIT {

	@Autowired
	ApiController controller;

	@Test
	public void devrais_retourner_la_liste_de_tous_lesMedecin() {

		// Act : action unique du test
		List<String> medecins = controller.tousLesMedecins();
		// Assert : tests
		Assertions.assertThat(medecins).hasSize(10).containsAll(MedecinFixture.lesMedecins());
	}

	@Test
	public void devrais_renvoyer_vrai_ou_faux_si_medecin_dispo() {
		// arrange
		String nomMedecin = "professeur lefin";
		// act
		Boolean medecins = controller.estDisponible(nomMedecin);
		// assert
		Assertions.assertThat(medecins).isFalse();
	}

	@Test
	public void devrais_renvoyer_la_specialite_du_medecin() {
		// arrange
		String nomMedecin = "professeur lefin";
		String expected = "chirurgien opthtalmologue";
		// act
		String specialite = controller.specialite(nomMedecin);
		// assert
		Assertions.assertThat(specialite).isEqualTo(expected);
	}

	@Test
	public void devrais_renvoyer_lhopital_du_medecin() {
		// arange
		String nomMedecin = "professeur lefin";
		String expected = "hopital lyon-sud";
		// Act : action unique du test
		String hopital = controller.hopital(nomMedecin);
		// assert
		Assertions.assertThat(hopital).isEqualTo(expected);
	}

	@Test
	public void devrais_renvoyer_nommedecin_par_specialite() {
		// arrange
		String specialite = "chirurgien opthtalmologue";
		List<String> resultat = new ArrayList<>();
		resultat.add("professeur lefin");
		// Act : action unique du test
		List<String> nom = controller.nomParSpecialite(specialite);
		// assert
		Assertions.assertThat(nom).isEqualTo(resultat);
	}

	@Test
	public void devrais_renvoyer_nommedecin_par_hopital() {
		// arrange
		String hopital = "hopital mere et enfant";
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("Docteur chance");
		// act
		List<String> noms = controller.nomParHopital(hopital);
		// assert
		Assertions.assertThat(noms).isEqualTo(expectedResult);
	}

	@Test
	public void devrais_renvoyer_liste_tous_medecins_dispo() {
		// arrange
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("professeur dupuis");
		expectedResult.add("Docteur anne eyouk");
		expectedResult.add("Docteur dupont");
		expectedResult.add("Docteur OBEN");
		expectedResult.add("Docteur grace");
		expectedResult.add("Docteur chance");
		expectedResult.add("Docteur legrand");
		// Act
		List<String> medecins = controller.nomParDisponibilite();
		// assert
		Assertions.assertThat(medecins).isEqualTo(expectedResult);
	}

	@Test
	public void devrais_renvoyer_liste_tous_vaccins() {
		// Arrange
		List<String> resultat = new ArrayList<>();
		resultat.add("BCG tuberculose");
		resultat.add("Diphtérie");
		resultat.add("Tétanos");
		resultat.add("Poliomyélite");
		resultat.add("Coqueluche");
		resultat.add("Haemophilus influenzae b");
		resultat.add("Fièvre jaune");
		resultat.add("Gastro-entérite à rotavirus");
		resultat.add("Grippe saisonnière");
		resultat.add("Hépatite A");
		resultat.add("Hépatite B");
		// Act
		List<String> vaccins = controller.tousLesVacins();
		// Assert
		Assertions.assertThat(vaccins).isEqualTo(resultat);
	}

	@Test
	public void devrais_retourner_oui_ou_non_siVaccin_obligatoire() {
		// Arrange
		String vaccin = "Tétanos";
		Boolean expectedResult = true;
		// act
		Boolean reponse = controller.estObligatoire(vaccin);
		// assert
		Assertions.assertThat(reponse).isEqualTo(expectedResult);
	}

	@Test
	public void devrais_retourner_la_liste_vaccin_parPays() {
		// Arrange
		String pays = "congo";
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("Grippe saisonnière");
		// Act
		List<String> vaccins = controller.vaccinParPays(pays);
		// Assert
		Assertions.assertThat(vaccins).isEqualTo(expectedResult);
	}

}
