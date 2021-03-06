package org.norsys.pamela.webhookapi.repository.interfaces;

import java.util.List;


/**
 * Interface presentant les methodes repository pour 
 * la table vaccin
 * @author panou
 *
 */
public interface VaccinRepository {
	
	
	/**
	 * 
	 * @return la liste de tous les vaccins
	 */
	List<String> tousLesVaccins();
		
	/**
	 * 
	 * @param nomVaccin
	 * @return oui si obligatoire ou non si pas obligatoire
	 */
	Boolean estObligatoire(String nomVaccin);
		
	
	/**
	 * 
	 * @param nomPays
	 * @return vaccin Par Pays
	 */
	List<String> vaccinParPays(String nomPays);
	
	
	
}
