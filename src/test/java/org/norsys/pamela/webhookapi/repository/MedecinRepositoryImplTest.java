package org.norsys.pamela.webhookapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.norsys.pamela.webhookapi.fixture.MedecinFixture;
import org.norsys.pamela.webhookapi.repository.interfaces.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MedecinRepositoryImplTest {

	@Autowired
	private MedecinRepository medecinRepository;

	@Test
	public void devrais_retourner_la_liste_de_tous_lesMedecin() {
		List<String> medecin = medecinRepository.tousLesMedecins();
		Assertions.assertThat(medecin).hasSize(10).containsAll(MedecinFixture.lesMedecins());
	}

	@Test
	public void devrais_renvoyer_vrai_ou_faux_si_medecin_dispo() {
		// arrange
		String nomMedecin = "professeur lefin";
		// act
		Boolean medecins = medecinRepository.estDisponible(nomMedecin);
		// assert
		Assertions.assertThat(medecins).isFalse();

	}

	@Test
	public void devrais_renvoyer_la_specialite_du_medecin() {
		// arrange
		String nomMedecin = "professeur lefin";
		String expected = "chirurgien opthtalmologue";
		// act
		String specialite = medecinRepository.specialite(nomMedecin);
		// assert
		Assertions.assertThat(specialite).isEqualTo(expected);
	}

	@Test
	public void devrais_renvoyer_lhopital_du_medecin() {
		// arange
		String nomMedecin = "professeur lefin";
		String expected = "hopital lyon-sud";
		// Act : action unique du test
		String hopital = medecinRepository.hopital(nomMedecin);
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
		List<String> nom = medecinRepository.nomParSpecialite(specialite);
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
		List<String> noms = medecinRepository.nomParHopital(hopital);
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
		List<String> medecins = medecinRepository.nomParDisponibilite();
		// assert
		Assertions.assertThat(medecins).isEqualTo(expectedResult);
	}
}
