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
	
	@GetMapping("/tousLesMedecins")
	@ResponseBody
	public List<String> tousLesMedecins() {
		return medecinRepositoryImpl.tousLesMedecins();
	}
	
	
	@GetMapping("/estDisponible")
	@ResponseBody
	public Boolean estDisponible(@RequestParam("nomMedecin") String nomMedecin) {
		return medecinRepositoryImpl.estDisponible(nomMedecin);
	}
	
	
	@GetMapping("/specialite")
	@ResponseBody
	public String specialite(@RequestParam("nomMedecin") String nomMedecin) {
		return medecinRepositoryImpl.specialite(nomMedecin);
	}
	
	
	@GetMapping("/hopital")
	@ResponseBody
	public String hopital(@RequestParam("nomMedecin") String nomMedecin) {
		return medecinRepositoryImpl.hopital(nomMedecin);
	}
	

	@GetMapping("/nomParSpecialite")
	@ResponseBody
	public List<String> nomParSpecialite(@RequestParam("specialite") String specialite) {
		return medecinRepositoryImpl.nomParSpecialite(specialite);
	}

	@GetMapping("/nomParHopital")
	@ResponseBody
	public List<String> nomParHopital(@RequestParam("hopital") String hopital) {
		return medecinRepositoryImpl.nomParHopital(hopital);
	}
	
	
	@GetMapping("/nomParDisponibilite")
	@ResponseBody
	public List<String> nomParDisponibilite() {
		return medecinRepositoryImpl.nomParDisponibilite();
	}

	@GetMapping("/tousLesVacins")
	@ResponseBody
	public List<String> tousLesVacins() {
		return vaccinRepositoryImpl.tousLesVaccins();
	}
	
	
	@GetMapping("/estObligatoire")
	@ResponseBody
	public Boolean estObligatoire(@RequestParam("nomVaccin") String nomVaccin) {
		return vaccinRepositoryImpl.estObligatoire(nomVaccin);
	}
	
	
	@GetMapping("/vaccinParPays")
	@ResponseBody
	public List<String> vaccinParPays(@RequestParam("Pays") String Pays) {
		return vaccinRepositoryImpl.vaccinParPays(Pays);
	}
	
	
}
