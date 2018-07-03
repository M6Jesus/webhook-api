package org.norsys.pamela.webhookapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.norsys.pamela.webhookapi.repository.interfaces.VaccinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VaccinRepositoryImplTest {

	@Autowired
	private VaccinRepository vaccinRepository;
	
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
		List<String> vaccins = vaccinRepository.tousLesVaccins();
		// Assert
		Assertions.assertThat(vaccins).isEqualTo(resultat);
	}
	
	@Test
	public void devrais_retourner_oui_ou_non_siVaccin_obligatoire() {
		// Arrange
		String vaccin = "Tétanos";
		Boolean expectedResult = true;
		// act
		Boolean reponse = vaccinRepository.estObligatoire(vaccin);
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
		List<String> vaccins = vaccinRepository.vaccinParPays(pays);
		// Assert
		Assertions.assertThat(vaccins).isEqualTo(expectedResult);
	}
}
