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
insert into lekar (id, ime, kontakt_telefon, ocena, prezime, smena, specijalizacija, klinika_id, promenio_sifru) values(10, 'Milan', '1111111', 5, 'Petrovic', 1, 'Strucnjak', 1, false)

insert into zdravstveni_karton(id, id_pacijenta) values (1, 2)
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (1, 'Šizofrenija', 'F20')
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (2, 'Bipolarni poremećaj', 'F31')
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (3, 'Depresija', 'F32')

insert into zdravstveni_karton_dijagnoze(id, dijagnoza_id) values (1, 1)
insert into zdravstveni_karton_dijagnoze(id, dijagnoza_id) values (1, 2)
insert into zdravstveni_karton_dijagnoze(id, dijagnoza_id) values (1, 3)

insert into sala(id, naziv, klinika_id) values (1, 'VelikSala', 1)
insert into sala(id, naziv, klinika_id) values (2, 'MalaSala', 1)

insert into operacija(id, cena, datum, tip_operacije, trajanje, pacijent_id, sala_id) values (1, 3999, '04/02/2020|09:30', 'Uklanjanje kurjeg oka', 30, 2, 2)
insert into operacija(id, cena, datum, tip_operacije, trajanje, pacijent_id, sala_id) values (2, 8000, '01/01/2020|04:15', 'Vadjenje zucne kese', 90, 2, 1)

insert into operacija_lekari(id, lekar_id) values (1, 10)
insert into operacija_lekari(id, lekar_id) values (2, 10)

insert into tip_pregleda(id, cena_pregleda, naziv, specijalizacija, trajanje, klinika_id) values (1, 1000, 'EKG', 'Kardiologija', 30, 1)

insert into pregled(id, datum, rezervisan, lekar_id, pacijent_id, sala_id, tip_pregleda_id) values (1, '19/06/2019|12:00', true, 10, 2, 1, 1)


