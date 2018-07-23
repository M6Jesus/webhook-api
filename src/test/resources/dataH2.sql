--- ================================================================================
--- vaccin
--- ================================================================================
	INSERT INTO public.vaccin (vaccinId, nomVaccin, typeVaccin, pays, estObligatoire) VALUES (1	, 'BCG tuberculose', 'Vaccin BCG SSI', 'cameroun',  TRUE);
	INSERT INTO public.vaccin (vaccinId, nomVaccin, typeVaccin, pays, estObligatoire) VALUES (2	, 'Diphtérie', 'Vaccin non commercialisé mais disponible sur demande du médecin auprès du fabricant', 'cameroun', TRUE);
	INSERT INTO public.vaccin (vaccinId, nomVaccin, typeVaccin, pays, estObligatoire) VALUES (3	, 'Tétanos', 'Revaxis', 'france', TRUE);
	INSERT INTO public.vaccin (vaccinId, nomVaccin, typeVaccin, pays, estObligatoire) VALUES (4	, 'Poliomyélite', 'Revaxis', 'espagne', TRUE);
	INSERT INTO public.vaccin (vaccinId, nomVaccin, typeVaccin, pays, estObligatoire) VALUES (5	, 'Coqueluche', 'Infanrix Tetra pour les enfants et Boostrixtetra pour les adultes et adolescents', 'italie', FALSE);
	INSERT INTO public.vaccin (vaccinId, nomVaccin, typeVaccin, pays, estObligatoire) VALUES (6	, 'Haemophilus influenzae b', 'Infanrix Quinta', 'chine', TRUE);
	INSERT INTO public.vaccin (vaccinId, nomVaccin, typeVaccin, pays, estObligatoire) VALUES (7	, 'Fièvre jaune', 'Stamaril', 'japon',	TRUE);
	INSERT INTO public.vaccin (vaccinId, nomVaccin, typeVaccin, pays, estObligatoire) VALUES (8	, 'Gastro-entérite à rotavirus', 'Rotarix', 'cameroun', FALSE);
	INSERT INTO public.vaccin (vaccinId, nomVaccin, typeVaccin, pays, estObligatoire) VALUES (9	, 'Grippe saisonnière', 'Immugrip', 'congo',  FALSE);
	INSERT INTO public.vaccin (vaccinId, nomVaccin, typeVaccin, pays, estObligatoire) VALUES (10, 'Hépatite A', 'Havrix 720 pour enfants de 12 a 15 ans , Avaxim 160 U pour Adolescents et adultes à partir de 16 ans', 'gabon',  TRUE);
	INSERT INTO public.vaccin (vaccinId, nomVaccin, typeVaccin, pays, estObligatoire) VALUES (11, 'Hépatite B', ' Engerix B10 μg pour enfants et  Vaccin Genhevac B Pasteur 20 μg pour Adolescents et adultes', 'cameroun', TRUE);
	
--- ================================================================================
--- message
--- ================================================================================
	INSERT INTO public.medecin (medecinID, nomMedecin, hopital, specialite, disponibilite) VALUES (1	, 'professeur dupuis', 'hopital lyon-sud', 'gynécologue', TRUE);
	INSERT INTO public.medecin (medecinID, nomMedecin, hopital, specialite, disponibilite) VALUES (2	, 'Docteur anne eyouk', 'hopital edouard heriot', 'generaliste',  TRUE);
	INSERT INTO public.medecin (medecinID, nomMedecin, hopital, specialite, disponibilite) VALUES (3	, 'Docteur dupont', 'Clinique natecia', 'ophtalmologue', TRUE);
	INSERT INTO public.medecin (medecinID, nomMedecin, hopital, specialite, disponibilite) VALUES (4	, 'Docteur OBEN', 'hopital lyon-sud', 'nutritioniste',  TRUE);
	INSERT INTO public.medecin (medecinID, nomMedecin, hopital, specialite, disponibilite) VALUES (5	, 'Docteur grace', 'hopital gratte ciel', 'gynécologue',  TRUE);
	INSERT INTO public.medecin (medecinID, nomMedecin, hopital, specialite, disponibilite) VALUES (6	, 'Docteur ansen', 'hopital lyon-sud', 'gastro-enterologue',  FALSE);
	INSERT INTO public.medecin (medecinID, nomMedecin, hopital, specialite, disponibilite) VALUES (7	, 'Docteur chance', 'hopital mere et enfant', 'generaliste',  TRUE);
	INSERT INTO public.medecin (medecinID, nomMedecin, hopital, specialite, disponibilite) VALUES (8	, 'professeur soigne', 'hopital lyon-sud', 'generaliste',  FALSE);
	INSERT INTO public.medecin (medecinID, nomMedecin, hopital, specialite, disponibilite) VALUES (9	, 'Docteur legrand', 'hopital lyon-sud', 'dentiste',  TRUE);
	INSERT INTO public.medecin (medecinID, nomMedecin, hopital, specialite, disponibilite) VALUES (10	, 'professeur lefin', 'hopital lyon-sud', 'chirurgien opthtalmologue',  FALSE);
	
	



	