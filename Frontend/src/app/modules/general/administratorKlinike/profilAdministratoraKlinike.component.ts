import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AdministratorKlinike} from '../../../model/administratorKlinike';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AdministratorKlinikeService} from '../../../service/administratorKlinike.service';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'profil-administratora-klinike',
  templateUrl: '/profilAdministratoraKlinike.html',
})

export class ProfilAdministratoraKlinikeComponent implements OnInit {

  ulogovanKorisnik: AdministratorKlinike;
  ulogovanUrl: string;
  izmeniProfilForm: FormGroup;

  ngOnInit(): void {
    this.izmeniProfilForm = new FormGroup({
      ime: new FormControl('', Validators.required),
      prezime: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      lozinka: new FormControl('', Validators.required),
      kontaktTelefon: new FormControl('', Validators.required),
    });
  }

  constructor(private http: HttpClient, private administratorService: AdministratorKlinikeService) {
    this.ulogovanUrl = '/server/api/administratorKlinike/ulogovanAdministratorKlinike';
    this.http.get<AdministratorKlinike>(this.ulogovanUrl, httpOptions).subscribe(
      data => {
        this.ulogovanKorisnik = data;
      }
    );
  }

  onSubmit() {
    const lozinka = (document.getElementById('lozinka') as HTMLInputElement).value;
    const lozinkaConfirm = (document.getElementById('lozinkaConfirm') as HTMLInputElement).value;

    if (lozinka === lozinkaConfirm) {
      this.administratorService.izmeniProfil(this.ulogovanKorisnik).subscribe(
        data => {
          this.izmeniProfilForm.reset();
          return true;
        },
      );
    }
  }
}
