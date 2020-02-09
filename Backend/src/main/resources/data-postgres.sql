--ADMINISTRATOR KLINICKOG CENTRA
insert into korisnik (email, lozinka, uloga) values ('adminklinickogcentra@mailsac.com', 'sifrazasajt', 'ADMINISTRATOR_KLINICKOG_CENTRA')
insert into administrator_klinickog_centra (id, ime, prezime, kontakt_telefon) values (1, 'Ana-Marija', 'Buhmiler', '0634578119')
--PACIJENTI
insert into korisnik (email, lozinka, uloga) values ('pacijent1@mailsac.com', 'sifrazasajt', 'PACIJENT')
insert into pacijent(id, ime, prezime, kontakt_telefon, adresa, grad, drzava, jbo, admin_aktivirao, pacijent_aktivirao) values (2, 'Goran', 'Popovic', '0635380072', 'Sremska', 'Indjija', 'Srbija', '2306997800132', 'DA', 'DA')

insert into korisnik (email, lozinka, uloga) values ('pacijent2@mailsac.com', 'sifrazasajt', 'PACIJENT')
insert into pacijent(id, ime, prezime, kontakt_telefon, adresa, grad, drzava, jbo, admin_aktivirao, pacijent_aktivirao) values (3, 'Pera', 'Peric', '0625487563', 'Bulevar Oslobodjenja 65', 'Novi Sad', 'Srbija', '168458536942565', 'DA', 'DA')

insert into korisnik (email, lozinka, uloga) values ('pacijent3@mailsac.com', 'sifrazasajt', 'PACIJENT')
insert into pacijent(id, ime, prezime, kontakt_telefon, adresa, grad, drzava, jbo, admin_aktivirao, pacijent_aktivirao) values (4, 'Mika', 'Mikic', '06548759945', 'Rumenacka 46', 'Novi Sad', 'Srbija', '14875595554269', 'DA', 'DA')

insert into korisnik (email, lozinka, uloga) values ('pacijent4@mailsac.com', 'sifrazasajt', 'PACIJENT')
insert into pacijent(id, ime, prezime, kontakt_telefon, adresa, grad, drzava, jbo, admin_aktivirao, pacijent_aktivirao) values (5, 'Isidor', 'Lukic', '0625487563', 'Bulevar Oslobodjenja 20', 'Novi Sad', 'Srbija', '168458536942565', 'DA', 'DA')

insert into korisnik (email, lozinka, uloga) values ('pacijent5@mailsac.com', 'sifrazasajt', 'PACIJENT')
insert into pacijent(id, ime, prezime, kontakt_telefon, adresa, grad, drzava, jbo, admin_aktivirao, pacijent_aktivirao) values (6, 'Andrija', 'Velimirovic', '06113759945', 'Lukaceva 46', 'Backa Topola', 'Srbija', '14875595554269', 'NE', 'DA')

--KLINIKE
insert into klinika (ime, adresa, opis) values ('Klinika 1', 'Mite Ruzica 76', 'Klinika za infektivne bolesti.')
insert into klinika (ime, adresa, opis) values ('Klinika 2', 'Rumenacka 475', 'Klinika za kardiovaskularne bolesti.')
insert into klinika (ime, adresa, opis) values ('Klinika 3', 'Bulevar Kralja Petra I 6', 'Klinika za plasticnu hirurgiju.')
insert into klinika (ime, adresa, opis) values ('Klinika 4', 'Sonje Marinkovic 76', 'Klinika za neuropsihijatriju.')

--ADMINISTRATORI KLINIKE
insert into korisnik (email, lozinka, uloga) values ('administratorklinike1@mailsac.com', 'sifrazasajt', 'ADMINISTRATOR_KLINIKE')
insert into administrator_klinike (id, ime, prezime, kontakt_telefon, klinika_id) values (7, 'Petar', 'Lukic', '1234567', 1)

insert into korisnik (email, lozinka, uloga) values ('administratorklinike2@mailsac.com', 'sifrazasajt', 'ADMINISTRATOR_KLINIKE')
insert into administrator_klinike (id, ime, prezime, kontakt_telefon, klinika_id) values (8, 'Milos', 'Djordjevic', '1234567', 2)

insert into korisnik (email, lozinka, uloga) values ('administratorklinike3@mailsac.com', 'sifrazasajt', 'ADMINISTRATOR_KLINIKE')
insert into administrator_klinike (id, ime, prezime, kontakt_telefon, klinika_id) values (9, 'Aleksandar', 'Lazarevic', '1234567', 3)

insert into korisnik (email, lozinka, uloga) values ('administratorklinike4@mailsac.com', 'sifrazasajt', 'ADMINISTRATOR_KLINIKE')
insert into administrator_klinike (id, ime, prezime, kontakt_telefon, klinika_id) values (10, 'Milan', 'Milosevic', '1234567', 4)

--LEKARI
insert into korisnik (id, email, lozinka, uloga) values (11, 'lekar1@mailsac.com', 'sifrazasajt', 'LEKAR')
insert into lekar (id, ime, kontakt_telefon, ocena, prezime, smena, specijalizacija, klinika_id, promenio_sifru) values(11, 'Zoran', '0611234567', 5, 'Jovanovic', 1, 'Pedijatrija', 1, true)

insert into korisnik (id, email, lozinka, uloga) values (12, 'lekar2@mailsac.com', 'sifrazasajt', 'LEKAR')
insert into lekar (id, ime, kontakt_telefon, ocena, prezime, smena, specijalizacija, klinika_id, promenio_sifru) values(12, 'Milan', '0617654321', 4, 'Petrovic', 2, 'Kardiologija', 1, true)

insert into korisnik (id, email, lozinka, uloga) values (13, 'lekar3@mailsac.com', 'sifrazasajt', 'LEKAR')
insert into lekar (id, ime, kontakt_telefon, ocena, prezime, smena, specijalizacija, klinika_id, promenio_sifru) values(13, 'Ivana', '0647799327', 5, 'Jankovic', 1, 'Nefrologija', 2, true)


insert into korisnik (id, email, lozinka, uloga) values (14, 'lekar4@mailsac.com', 'sifrazasajt', 'LEKAR')
insert into lekar (id, ime, kontakt_telefon, ocena, prezime, smena, specijalizacija, klinika_id, promenio_sifru) values(14, 'Milan', '0617654321', 4, 'Petrovic', 3, 'Infektologija', 2, true)

insert into korisnik (id, email, lozinka, uloga) values (15, 'lekar5@mailsac.com', 'sifrazasajt', 'LEKAR')
insert into lekar (id, ime, kontakt_telefon, ocena, prezime, smena, specijalizacija, klinika_id, promenio_sifru) values(15, 'Igor', '0611234567', 5, 'Jovicic', 1, 'Endokrinologija', 3, true)

insert into korisnik (id, email, lozinka, uloga) values (16, 'lekar6@mailsac.com', 'sifrazasajt', 'LEKAR')
insert into lekar (id, ime, kontakt_telefon, ocena, prezime, smena, specijalizacija, klinika_id, promenio_sifru) values(16, 'Anastasija', '0617654321', 4, 'Obradovic', 2, 'Hematologija', 3, true)

insert into korisnik (id, email, lozinka, uloga) values (17, 'lekar7@mailsac.com', 'sifrazasajt', 'LEKAR')
insert into lekar (id, ime, kontakt_telefon, ocena, prezime, smena, specijalizacija, klinika_id, promenio_sifru) values(17, 'Vesna', '0647799327', 5, 'Filipovic', 1, 'Nefrologija', 4, true)

insert into korisnik (id, email, lozinka, uloga) values (18, 'lekar8@mailsac.com', 'sifrazasajt', 'LEKAR')
insert into lekar (id, ime, kontakt_telefon, ocena, prezime, smena, specijalizacija, klinika_id, promenio_sifru) values(18, 'Marija', '0617654321', 4, 'Dimic', 3, 'Kardiologija', 4, true)



--ZDRAVSTVENI KARTONI
insert into zdravstveni_karton(id, id_pacijenta) values (1, 2)
insert into zdravstveni_karton(id, id_pacijenta) values (2, 3)
insert into zdravstveni_karton(id, id_pacijenta) values (3, 4)
insert into zdravstveni_karton(id, id_pacijenta) values (4, 5)
insert into zdravstveni_karton(id, id_pacijenta) values (5, 6)

--DIJAGNOZE
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (1, 'Šizofrenija', 'F20')
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (2, 'Bipolarni poremećaj', 'F31')
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (3, 'Depresija', 'F32')
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (4, 'Upala pluća', 'P11')
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (5, 'Visoka temperatura', 'T10')
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (6, 'Povišen krvni pritisak', 'K05')
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (7, 'Kamen u bubregu', 'N23')
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (8, 'Male boginje', 'M01')
insert into dijagnoza(id, naziv, sifra_dijagnoze) values (9, 'Skolioza', 'S61')

--POPUNJAVANJE ZDRAVSTVENIH KARTONA
insert into zdravstveni_karton_dijagnoze(id, dijagnoza_id) values (1, 2)
insert into zdravstveni_karton_dijagnoze(id, dijagnoza_id) values (2, 1)
insert into zdravstveni_karton_dijagnoze(id, dijagnoza_id) values (3, 5)
insert into zdravstveni_karton_dijagnoze(id, dijagnoza_id) values (4, 7)
insert into zdravstveni_karton_dijagnoze(id, dijagnoza_id) values (5, 4)
insert into zdravstveni_karton_dijagnoze(id, dijagnoza_id) values (3, 1)
insert into zdravstveni_karton_dijagnoze(id, dijagnoza_id) values (1, 3)

--SALE
insert into sala(id, naziv, klinika_id) values (1, 'A1', 1)
insert into sala(id, naziv, klinika_id) values (2, 'B3', 1)
insert into sala(id, naziv, klinika_id) values (3, 'G1', 1)
insert into sala(id, naziv, klinika_id) values (4, 'G2', 2)
insert into sala(id, naziv, klinika_id) values (5, 'A2', 2)
insert into sala(id, naziv, klinika_id) values (6, 'B1', 3)
insert into sala(id, naziv, klinika_id) values (7, 'B10', 3)
insert into sala(id, naziv, klinika_id) values (8, 'M8', 4)
insert into sala(id, naziv, klinika_id) values (9, 'T11', 4)
insert into sala(id, naziv, klinika_id) values (10, 'C4', 4)

--OPERACIJE
insert into operacija(id, cena, datum, tip_operacije, trajanje, pacijent_id, sala_id) values (1, 3999, '04/02/2020|09:30', 'Uklanjanje kurjeg oka', 30, 2, 2)
insert into operacija(id, cena, datum, tip_operacije, trajanje, pacijent_id, sala_id) values (2, 8000, '01/01/2020|04:15', 'Vadjenje zucne kese', 90, 2, 1)

insert into operacija_lekari(id, lekar_id) values (1, 11)
insert into operacija_lekari(id, lekar_id) values (2, 12)

--TIPOVI PREGLEDA
insert into tip_pregleda(id, cena_pregleda, naziv, specijalizacija, trajanje, klinika_id) values (1, 1000, 'EKG', 'Kardiologija', 30, 1)
insert into tip_pregleda(id, cena_pregleda, naziv, specijalizacija, trajanje, klinika_id) values (2, 600, 'Pregled deteta', 'Pedijatrija', 30, 1)

insert into tip_pregleda(id, cena_pregleda, naziv, specijalizacija, trajanje, klinika_id) values (3, 1500, 'Ultrazvuk bubrega', 'Nefrologija', 30, 2)
insert into tip_pregleda(id, cena_pregleda, naziv, specijalizacija, trajanje, klinika_id) values (4, 4500, 'Lumbalna punkcija', 'Infektologija', 30, 2)

insert into tip_pregleda(id, cena_pregleda, naziv, specijalizacija, trajanje, klinika_id) values (5, 1500, 'Ultrazvuk', 'Endokrinologija', 30, 3)
insert into tip_pregleda(id, cena_pregleda, naziv, specijalizacija, trajanje, klinika_id) values (6, 1000, 'Analiza krvi', 'Hematologija', 30, 3)

insert into tip_pregleda(id, cena_pregleda, naziv, specijalizacija, trajanje, klinika_id) values (7, 1800, 'Ultrazvuk bubrega', 'Nefrologija', 30, 4)
insert into tip_pregleda(id, cena_pregleda, naziv, specijalizacija, trajanje, klinika_id) values (8, 1000, 'EKG', 'Kardiologija', 30, 4)

--PREGLEDI
insert into pregled(id, datum, rezervisan, lekar_id, pacijent_id, sala_id, tip_pregleda_id) values (1, '19/06/2019|12:00', true, 17, 5, 9, 7)
insert into pregled(id, datum, rezervisan, lekar_id, sala_id, tip_pregleda_id) values (2, '9/02/2020|12:00', false, 16, 6, 6)

insert into zahtev_za_godisnji(id, korisnik_id, pocetak, kraj, klinika_id) values (1, 10, '10/03/2020', '20/03/2020', 1)


