package org.norsys.pamela.webhookapi.controller;

import java.util.List;

import org.norsys.pamela.webhookapi.repository.interfaces.MedecinRepository;
import org.norsys.pamela.webhookapi.repository.interfaces.VaccinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ApiController {
	
	private final MedecinRepository medecinRepository;
	
	private final VaccinRepository vaccinRepository;
	
	@Autowired
	public ApiController(final MedecinRepository medecinRepositoryImpl, final VaccinRepository vaccinRepositoryImpl) {
		this.medecinRepository = medecinRepositoryImpl;
		this.vaccinRepository = vaccinRepositoryImpl;
	}

	/**
	 * 
	 * @return la liste de tous les medecins present dans la base de donnée
	 */
	@GetMapping("/tousLesMedecins")
	@ResponseBody
	public List<String> tousLesMedecins() {
		return medecinRepository.tousLesMedecins();
	}
	
	/**
	 * 
	 * @param nomMedecin le nom du medecin
	 * @return true ou false selon que le medecin est disponible ou pas
	 */
	@GetMapping("/estDisponible")
	@ResponseBody
	public Boolean estDisponible(@RequestParam("nomMedecin") final String nomMedecin) {
		return medecinRepository.estDisponible(nomMedecin);
	}
	
	/**
	 * 
	 * @param nomMedecin le nom du medecin
	 * @return la specialité du medecin
	 */
	@GetMapping("/specialite")
	@ResponseBody
	public String specialite(@RequestParam("nomMedecin") final String nomMedecin) {
		return medecinRepository.specialite(nomMedecin);
	}
	
	/**
	 * 
	 * @param nomMedecin le nom du medecin
	 * @return le nom de l'hopital ou travaille le medecin 
	 */
	@GetMapping("/hopital")
	@ResponseBody
	public String hopital(@RequestParam("nomMedecin") final String nomMedecin) {
		return medecinRepository.hopital(nomMedecin);
	}
	
	/**
	 * 
	 * @param specialite: la sepcialité du medecin
	 * @return les nom des medecins ayant cette specialité
	 */
	@GetMapping("/nomParSpecialite")
	@ResponseBody
	public List<String> nomParSpecialite(@RequestParam("specialite") final String specialite) {
		return medecinRepository.nomParSpecialite(specialite);
	}
	
	/**
	 * 
	 * @param hopital nom e l'hopital
	 * @return une liste de nom des medecins travaillant dans cet hopital
	 */
	@GetMapping("/nomParHopital")
	@ResponseBody
	public List<String> nomParHopital(@RequestParam("hopital") final String hopital) {
		return medecinRepository.nomParHopital(hopital);
	}
	
	/**
	 * 
	 * @return tous le nom de tous les medecins qui sont disponible
	 */
	@GetMapping("/nomParDisponibilite")
	@ResponseBody
	public List<String> nomParDisponibilite() {
		return medecinRepository.nomParDisponibilite();
	}
	
	/**
	 * 
	 * @return la liste de tous les vaccins de la base de donnée
	 */
	@GetMapping("/tousLesVacins")
	@ResponseBody
	public List<String> tousLesVacins() {
		return vaccinRepository.tousLesVaccins();
	}
	
	/**
	 * 
	 * @param nomVaccin le nom du vaccin 
	 * @return true ou false selon que le vaccin est obligatoire ou pas
	 */
	@GetMapping("/estObligatoire")
	@ResponseBody
	public Boolean estObligatoire(@RequestParam("nomVaccin") final String nomVaccin) {
		return vaccinRepository.estObligatoire(nomVaccin);
	}
	
	/**
	 * 
	 * @param Pays nom du pays
	 * @return la liste de tous les vaccins en fonction du pays
	 */
	@GetMapping("/vaccinParPays")
	@ResponseBody
	public List<String> vaccinParPays(@RequestParam("Pays") final String Pays) {
		return vaccinRepository.vaccinParPays(Pays);
	}
	
	
}
