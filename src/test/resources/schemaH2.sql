CREATE TABLE public.vaccin (
				vaccinId INTEGER NOT NULL auto_increment,
				nomVaccin VARCHAR (100) NOT NULL,
				typeVaccin VARCHAR (1000) NOT NULL,
				pays VARCHAR (100) NOT NULL,
				estObligatoire BOOLEAN NOT NULL,
				CONSTRAINT vaccin_pk PRIMARY KEY (vaccinId)
);


CREATE TABLE public.medecin (
				medecinID INTEGER NOT NULL auto_increment,
				nomMedecin VARCHAR (100) NOT NULL,
				hopital VARCHAR (100) NOT NULL,
				specialite VARCHAR (100) NOT NULL,
				disponibilite BOOLEAN NOT NULL,
				CONSTRAINT medecin_pk PRIMARY KEY (medecinID)
);
