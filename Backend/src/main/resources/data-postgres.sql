insert into korisnik (email, lozinka, uloga) values ('abuhmiler4@gmail.com', '1111', 'ADMINISTRATOR_KLINICKOG_CENTRA')
insert into administrator_klinickog_centra (id, ime, prezime, kontakt_telefon) values (1, 'Ana-Marija', 'Buhmiler', '0621731170')

insert into korisnik (email, lozinka, uloga) values ('milan@gmail.com', '1', 'ADMINISTRATOR_KLINIKE')

insert into korisnik (email, lozinka, uloga) values ('vladimirpopovic@live.com', 'vladimir', 'PACIJENT')
insert into pacijent(id, ime, prezime, kontakt_telefon, adresa, grad, drzava, jbo, admin_aktivirao, pacijent_aktivirao) values (3, 'Vladimir', 'Popovic', '0637200538', 'Glavna 38', 'Novi Karlovci', 'Srbija', '2306997800132', 'DA', 'DA')

insert into klinika (id, ime, adresa, opis) values (1, 'Klinika', 'adresa', 'random opis')
insert into administrator_klinike (id, ime, prezime, kontakt_telefon, klinika_id) values (2, 'Milan', 'Lukic', '1234567', 1)
