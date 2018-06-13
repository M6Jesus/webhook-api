package org.norsys.pamela.webhookapi.repository.interfaces;

import java.util.List;

public interface MedecinRepository {
	
	/**
	 * 
	 * @return la liste de tous les medecins
	 */
	List<String> tousLesMedecins();
	
	/**
	 * 
	 * @param nomMedecin
	 * @return vrai ou faux
	 */
	Boolean estDisponible(String nomMedecin);
	
	/**
	 * 
	 * @param nomMedecin
	 * @return la specialité du medecin
	 */
	String specialite(String nomMedecin);
	
	
	/**
	 * 
	 * @param nomMedecin
	 * @return le nom de l'hopital du medecin
	 */
	String hopital(String nomMedecin);
	
	
	/**
	 * 
	 * @param nomMedecin
	 * @return les noms des medecin correspondant a la specialité
	 */
	List<String> nomParSpecialite(String specialite);
	
	/**
	 * 
	 * @param hopital
	 * @return les noms des medecin correspondant a l'hopital
	 */
	List<String> nomParHopital(String hopital);
	
	/**
	 * 
	 * @param disponibilité
	 * @return les noms des medecin dispo
	 */
	List<String> nomParDisponibilite();
	
	
}
