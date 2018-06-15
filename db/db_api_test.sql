CREATE SEQUENCE public.vaccin_id_seq;
CREATE TABLE public.vaccin (
				vaccinId INTEGER NOT NULL DEFAULT nexval('public.vaccin_id_seq'),
				nomVaccin VARCHAR (100) NOT NULL,
				typeVaccin VARCHAR (1000) NOT NULL,
				pays VARCHAR (100) NOT NULL,
				estObligatoire BOOLEAN NOT NULL,
				CONSTRAINT vaccin_pk PRIMARY KEY (vaccinId)
);
ALTER SEQUENCE public.vaccin_id_seq OWNED BY public.vaccin.vaccinId;


CREATE SEQUENCE public.medecin_id_seq;
CREATE TABLE public.medecin (
				medecinID INTEGER NOT NULL DEFAULT nexval ('public.medecin_id_seq'),
				nomMedecin VARCHAR (100) NOT NULL,
				hopital VARCHAR (100) NOT NULL,
				specialite VARCHAR (100) NOT NULL,
				disponibilite BOOLEAN NOT NULL,
				CONSTRAINT medecin_pk PRIMARY KEY (medecinID)
);
ALTER SEQUENCE public.medecin_id_seq OWNED BY public.medecin.medecinID;




