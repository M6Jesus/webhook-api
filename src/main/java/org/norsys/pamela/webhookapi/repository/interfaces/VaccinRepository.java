package org.norsys.pamela.webhookapi.repository.interfaces;

import java.util.List;


import org.norsys.pamela.webhookapi.model.Vaccin;

public interface VaccinRepository {
	
	
	/**
	 * 
	 * @return la liste de tous les vaccins
	 */
	List<Vaccin> tousLesVaccins();
		
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
	String vaccinParPays(String nomPays);
	
	
	
}
