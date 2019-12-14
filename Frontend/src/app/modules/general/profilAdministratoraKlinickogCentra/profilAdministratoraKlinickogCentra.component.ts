import {Component, OnInit} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {Korisnik} from '../../../model/korisnik';
import {FormGroup} from '@angular/forms';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AdministratorKlinickogCentra} from '../../../model/administratorKlinickogCentra';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Component({
  selector: 'app-profil-administratora-klinickog-centra',
  templateUrl: './profilAdministratoraKlinickogCentra.component.html'
})

export class ProfilAdministratoraKlinickogCentraComponent {

  name = environment.application.name;
  angular = environment.application.angular;
  bootstrap = environment.application.bootstrap;

  ulogovanUrl: string;
  ulogovanKorisnik: AdministratorKlinickogCentra;
  izmenaForm: FormGroup;

  constructor(private http: HttpClient) {
    this.ulogovanUrl = 'server/api/ulogovanKorisnik';
  }

  OnInit() {
    const ulogovanKorisnik = this.http.get<AdministratorKlinickogCentra>(this.ulogovanUrl, httpOptions);
  }
}
