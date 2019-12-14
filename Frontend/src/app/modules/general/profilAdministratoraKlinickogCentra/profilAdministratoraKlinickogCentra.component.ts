import {Component, OnInit} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import { AdministratorKlinickogCentra } from 'src/app/model/administratorKlinickogCentra';
import {AdministratorKlinickogCentraService} from '../../../service/administratorKlinickogCentra.service';

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

  ngOnInit(): void {
    this.izmenaForm = new FormGroup({
      ime: new FormControl('', Validators.required),
      prezime: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      lozinka: new FormControl('', Validators.required),
      kontaktTelefon: new FormControl('', Validators.required),
    });
  }

  constructor(private http: HttpClient, private administratorKlinickogCentraService: AdministratorKlinickogCentraService) {
    this.ulogovanUrl = '/server/api/administratorKlinickogCentra/ulogovanAdministratorKlinickogCentra';
    this.http.get<AdministratorKlinickogCentra>(this.ulogovanUrl, httpOptions).subscribe(
      data => {
        this.ulogovanKorisnik = data;
      }
    );

  onSubmit() {
    const lozinka = (document.getElementById('lozinka') as HTMLInputElement).value;
    const lozinkaConfirm = (document.getElementById('lozinkaConfirm') as HTMLInputElement).value;

    if (lozinka === lozinkaConfirm) {
      this.administratorKlinickogCentraService.izmeniProfil(this.ulogovanKorisnik).subscribe(
        data => {
          this.izmenaForm.reset();
          return true;
        },
      );
    }
  }


}
