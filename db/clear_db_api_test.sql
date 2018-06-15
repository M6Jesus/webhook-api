BEGIN TRANSACTION;

--- ===== Purge des tables
DELETE FROM public.vaccin
DELETE FROM public.medecin;



--- ===== Réinitialisation des séquences
SELECT setval('public.vaccin_id_seq', 1, false);
SELECT setval('public.medecin_id_seq', 1, false);



COMMIT;