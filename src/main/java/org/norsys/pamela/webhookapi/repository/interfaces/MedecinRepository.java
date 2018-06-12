package org.norsys.pamela.webhookapi.repository.interfaces;

import java.util.List;

import org.norsys.pamela.webhookapi.model.Medecin;

public interface MedecinRepository {
	
	/**
	 * 
	 * @return la liste de tous les medecins
	 */
	List<Medecin> tousLesMedecins();
	
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
	List<String> nomParSpécialité(String specialite);
	
	/**
	 * 
	 * @param hopital
	 * @return les noms des medecin correspondant a l'hopital
	 */
	List<String> nomParHopital(String hopital);
	
	/**
	 * 
	 * @param disponibilité
	 * @return les noms des medecin correspondant a l'etat de leur disponibilité
	 */
	List<String> nomParDisponibilite(Boolean disponibilité);
	
	
}
