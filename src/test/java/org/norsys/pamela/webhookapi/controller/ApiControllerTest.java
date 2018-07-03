package org.norsys.pamela.webhookapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;
import org.norsys.pamela.webhookapi.fixture.MedecinFixture;
import org.norsys.pamela.webhookapi.repository.interfaces.MedecinRepository;
import org.norsys.pamela.webhookapi.repository.interfaces.VaccinRepository;

public class ApiControllerTest {

	@Test
	public void devrais_retourner_la_liste_de_tous_lesMedecin() {
		// Arrange : préparation du test
		MedecinRepository repoMedecin = Mockito.mock(MedecinRepository.class);
		Mockito.when(repoMedecin.tousLesMedecins()).thenReturn(MedecinFixture.lesMedecins());

		ApiController controller = new ApiController(repoMedecin, null);

		// Act : action unique du test
		List<String> medecins = controller.tousLesMedecins();
		// assert
		Assertions.assertThat(medecins).hasSize(10).containsAll(MedecinFixture.lesMedecins());
	}

	@Test
	public void devrais_renvoyer_vrai_ou_faux_si_medecin_dispo() {
		// Arrange : préparation du test
		MedecinRepository repoMedecin = Mockito.mock(MedecinRepository.class);
		Mockito.when(repoMedecin.estDisponible(Mockito.anyString())).thenReturn(Boolean.TRUE);
		Mockito.when(repoMedecin.estDisponible(Mockito.matches("professeur lefin"))).thenReturn(Boolean.FALSE);

		ApiController controller = new ApiController(repoMedecin, null);

		// Act : action unique du test
		Boolean medecins = controller.estDisponible("professeur lefin");
		// assert
		Assertions.assertThat(medecins).isFalse();
	}

	@Test
	public void devrais_renvoyer_la_specialite_du_medecin() {
		// Arrange : préparation du test
		MedecinRepository repoMedecin = Mockito.mock(MedecinRepository.class);
		String nomMedecin = "professeur lefin";
		Mockito.when(repoMedecin.specialite(Mockito.matches("professeur lefin")))
				.thenReturn("chirurgien opthtalmologue");
		String expected = "chirurgien opthtalmologue";

		ApiController controller = new ApiController(repoMedecin, null);

		// Act : action unique du test
		String specialite = controller.specialite(nomMedecin);

		// assert
		Assertions.assertThat(specialite).isEqualTo(expected);
	}

	@Test
	public void devrais_renvoyer_lhopital_du_medecin() {
		// Arrange : préparation du test
		MedecinRepository repoMedecin = Mockito.mock(MedecinRepository.class);
		String nomMedecin = "professeur lefin";
		Mockito.when(repoMedecin.hopital(Mockito.matches("professeur lefin"))).thenReturn("hopital lyon-sud");
		ApiController controller = new ApiController(repoMedecin, null);
		String expected = "hopital lyon-sud";
		// Act : action unique du test
		String hopital = controller.hopital(nomMedecin);

		// assert
		Assertions.assertThat(hopital).isEqualTo(expected);
	}

	@Test
	public void devrais_renvoyer_nommedecin_par_specialite() {

		// Arrange : préparation du test
		MedecinRepository repoMedecin = Mockito.mock(MedecinRepository.class);
		String specialite = "chirurgien opthtalmologue";
		List<String> resultat = new ArrayList<>();
		resultat.add("professeur lefin");
		Mockito.when(repoMedecin.nomParSpecialite(Mockito.matches(specialite))).thenReturn(resultat);
		ApiController controller = new ApiController(repoMedecin, null);

		// Act : action unique du test
		List<String> nom = controller.nomParSpecialite(specialite);

		// assert
		Assertions.assertThat(nom).isSameAs(resultat);
	}

	@Test
	public void devrais_renvoyer_nommedecin_par_hopital() {

		// Arrange : préparation du test
		MedecinRepository repoMedecin = Mockito.mock(MedecinRepository.class);
		String hopital = "hopital mere et enfant";
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("Docteur chance");
		Mockito.when(repoMedecin.nomParHopital(Mockito.matches(hopital))).thenReturn(expectedResult);
		ApiController controller = new ApiController(repoMedecin, null);
		// act
		List<String> noms = controller.nomParHopital(hopital);
		// assert
		Assertions.assertThat(noms).isSameAs(expectedResult);

	}

	@Test
	public void devrais_renvoyer_liste_tous_medecins_dispo() {

		// Arrange : préparation du test
		MedecinRepository repoMedecin = Mockito.mock(MedecinRepository.class);

		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("professeur dupuis");
		expectedResult.add("Docteur anne eyouk");
		expectedResult.add("Docteur dupont");
		expectedResult.add("Docteur OBEN");
		expectedResult.add("Docteur grace");
		expectedResult.add("Docteur chance");
		expectedResult.add("Docteur legrand");

		Mockito.when(repoMedecin.nomParDisponibilite()).thenReturn(expectedResult);
		ApiController controller = new ApiController(repoMedecin, null);

		// Act
		List<String> medecins = controller.nomParDisponibilite();

		// assert
		Assertions.assertThat(medecins).isSameAs(expectedResult);
	}

	@Test
	public void devrais_renvoyer_liste_tous_vaccins() {
		// Arrange
		VaccinRepository repoVaccin = Mockito.mock(VaccinRepository.class);

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

		Mockito.when(repoVaccin.tousLesVaccins()).thenReturn(resultat);
		ApiController controller = new ApiController(null, repoVaccin);
		// Act
		List<String> vaccins = controller.tousLesVacins();

		// Assert
		Assertions.assertThat(vaccins).isSameAs(resultat);
	}

	@Test
	public void devrais_retourner_oui_ou_non_siVaccin_obligatoire() {
		// Arrange
		VaccinRepository repoVaccin = Mockito.mock(VaccinRepository.class);
		String vaccin = "Tétanos";
		Boolean expectedResult = true;
		Mockito.when(repoVaccin.estObligatoire(Mockito.matches(vaccin))).thenReturn(expectedResult);
		ApiController controller = new ApiController(null, repoVaccin);
		// act
		Boolean reponse = controller.estObligatoire(vaccin);
		// assert
		Assertions.assertThat(reponse).isSameAs(expectedResult);
	}

	@Test
	public void devrais_retourner_la_liste_vaccin_parPays() {
		// Arrange
		VaccinRepository repoVaccin = Mockito.mock(VaccinRepository.class);
		String pays = "congo";
		List<String> expectedResult = new ArrayList<>();
		expectedResult.add("Grippe saisonnière");
		Mockito.when(repoVaccin.vaccinParPays(Mockito.matches(pays))).thenReturn(expectedResult);
		ApiController controller = new ApiController(null, repoVaccin);
		// Act
		List<String> vaccins = controller.vaccinParPays(pays);

		// Assert
		Assertions.assertThat(vaccins).isSameAs(expectedResult);
	}
}
