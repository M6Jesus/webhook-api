package org.norsys.pamela.webhookapi.controller;

import java.util.List;

import org.norsys.pamela.webhookapi.repository.impl.MedecinRepositoryImpl;
import org.norsys.pamela.webhookapi.repository.impl.VaccinRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ApiController {
	
	@Autowired
	private MedecinRepositoryImpl medecinRepositoryImpl;
	
	@Autowired
	private VaccinRepositoryImpl vaccinRepositoryImpl;
	
	/**
	 * 
	 * @return la liste de tous les medecins present dans la base de donnée
	 */
	@GetMapping("/tousLesMedecins")
	@ResponseBody
	public List<String> tousLesMedecins() {
		return medecinRepositoryImpl.tousLesMedecins();
	}
	
	/**
	 * 
	 * @param nomMedecin le nom du medecin
	 * @return true ou false selon que le medecin est disponible ou pas
	 */
	@GetMapping("/estDisponible")
	@ResponseBody
	public Boolean estDisponible(@RequestParam("nomMedecin") String nomMedecin) {
		return medecinRepositoryImpl.estDisponible(nomMedecin);
	}
	
	/**
	 * 
	 * @param nomMedecin le nom du medecin
	 * @return la specialité du medecin
	 */
	@GetMapping("/specialite")
	@ResponseBody
	public String specialite(@RequestParam("nomMedecin") String nomMedecin) {
		return medecinRepositoryImpl.specialite(nomMedecin);
	}
	
	/**
	 * 
	 * @param nomMedecin le nom du medecin
	 * @return le nom de l'hopital ou travaille le medecin 
	 */
	@GetMapping("/hopital")
	@ResponseBody
	public String hopital(@RequestParam("nomMedecin") String nomMedecin) {
		return medecinRepositoryImpl.hopital(nomMedecin);
	}
	
	/**
	 * 
	 * @param specialite: la sepcialité du medecin
	 * @return les nom des medecins ayant cette specialité
	 */
	@GetMapping("/nomParSpecialite")
	@ResponseBody
	public List<String> nomParSpecialite(@RequestParam("specialite") String specialite) {
		return medecinRepositoryImpl.nomParSpecialite(specialite);
	}
	
	/**
	 * 
	 * @param hopital nom e l'hopital
	 * @return une liste de nom des medecins travaillant dans cet hopital
	 */
	@GetMapping("/nomParHopital")
	@ResponseBody
	public List<String> nomParHopital(@RequestParam("hopital") String hopital) {
		return medecinRepositoryImpl.nomParHopital(hopital);
	}
	
	/**
	 * 
	 * @return tous le nom de tous les medecins qui sont disponible
	 */
	@GetMapping("/nomParDisponibilite")
	@ResponseBody
	public List<String> nomParDisponibilite() {
		return medecinRepositoryImpl.nomParDisponibilite();
	}
	
	/**
	 * 
	 * @return la liste de tous les vaccins de la base de donnée
	 */
	@GetMapping("/tousLesVacins")
	@ResponseBody
	public List<String> tousLesVacins() {
		return vaccinRepositoryImpl.tousLesVaccins();
	}
	
	/**
	 * 
	 * @param nomVaccin le nom du vaccin 
	 * @return true ou false selon que le vaccin est obligatoire ou pas
	 */
	@GetMapping("/estObligatoire")
	@ResponseBody
	public Boolean estObligatoire(@RequestParam("nomVaccin") String nomVaccin) {
		return vaccinRepositoryImpl.estObligatoire(nomVaccin);
	}
	
	/**
	 * 
	 * @param Pays nom du pays
	 * @return la liste de tous les vaccins en fonction du pays
	 */
	@GetMapping("/vaccinParPays")
	@ResponseBody
	public List<String> vaccinParPays(@RequestParam("Pays") String Pays) {
		return vaccinRepositoryImpl.vaccinParPays(Pays);
	}
	
	
}
