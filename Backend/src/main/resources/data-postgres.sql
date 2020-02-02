insert into korisnik (email, lozinka, uloga) values ('abuhmiler4@gmail.com', '1111', 'ADMINISTRATOR_KLINICKOG_CENTRA')
insert into administrator_klinickog_centra (id, ime, prezime, kontakt_telefon) values (1, 'Ana-Marija', 'Buhmiler', '0621731170')

insert into korisnik (email, lozinka, uloga) values ('vladimirpopovic@live.com', 'vladimir', 'PACIJENT')
insert into pacijent(id, ime, prezime, kontakt_telefon, adresa, grad, drzava, jbo, admin_aktivirao, pacijent_aktivirao) values (2, 'Vladimir', 'Popovic', '0637200538', 'Glavna 38', 'Novi Karlovci', 'Srbija', '2306997800132', 'DA', 'DA')
insert into korisnik (email, lozinka, uloga) values ('pera@live.com', '1', 'PACIJENT')
insert into pacijent(id, ime, prezime, kontakt_telefon, adresa, grad, drzava, jbo, admin_aktivirao, pacijent_aktivirao) values (3, 'Pera', 'Peric', '0625487563', 'Bulevar Oslobodjenja 65', 'Novi Sad', 'Srbija', '168458536942565', 'DA', 'DA')
insert into korisnik (email, lozinka, uloga) values ('mika@gmail.com', '1', 'PACIJENT')
insert into pacijent(id, ime, prezime, kontakt_telefon, adresa, grad, drzava, jbo, admin_aktivirao, pacijent_aktivirao) values (4, 'Mika', 'Mikic', '06548759945', 'Rumenacka 46', 'Novi Sad', 'Srbija', '14875595554269', 'DA', 'DA')

insert into klinika (ime, adresa, opis) values ('Klinika 1', 'Mite Ruzica 76', 'Klinika za infektivne bolesti.')
insert into klinika (ime, adresa, opis) values ('Klinika 2', 'Rumenacka 475', 'Klinika za kardiovaskularne bolesti.')
insert into klinika (ime, adresa, opis) values ('Klinika 3', 'Bulevar Kralja Petra I 6', 'Klinika za plasticnu hirurgiju.')
insert into klinika (ime, adresa, opis) values ('Klinika 4', 'Sonje Marinkovic 76', 'Klinika za neuropsihijatriju.')

insert into korisnik (email, lozinka, uloga) values ('milan@gmail.com', '1', 'ADMINISTRATOR_KLINIKE')
insert into administrator_klinike (id, ime, prezime, kontakt_telefon, klinika_id) values (5, 'Milan', 'Lukic', '1234567', 1)

insert into korisnik (id, email, lozinka, uloga) values (10, 'random@gmail.com', '1', 'LEKAR')
insert into lekar (id, ime, kontakt_telefon, ocena, prezime, smena, specijalizacija, klinika_id) values(10, 'Milan', '1111111', 5, 'Petrovic', 1, 'Strucnjak', 1)