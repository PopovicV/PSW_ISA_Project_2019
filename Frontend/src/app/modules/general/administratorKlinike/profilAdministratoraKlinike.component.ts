import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AdministratorKlinike} from '../../../model/administratorKlinike';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {AdministratorKlinikeService} from '../../../service/administratorKlinike.service';
import {Klinika} from '../../../model/klinika';
import {Pacijent} from '../../../model/pacijent';
import {AdministratorKlinikeNavigationComponent} from '../../navigations/administrator-klinike-navigation/administrator-klinike-navigation.component';

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
  pacijentiUrl: string;
  izmeniProfilForm: FormGroup;
  pacijenti: Array<Pacijent>;

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
    administratorService.getUlogovanKorisnik().subscribe(
      data => {
        this.ulogovanKorisnik = data;
      }
    );
    this.pacijentiUrl = '/server/api/pacijent/all';
    this.http.get<Array<Pacijent>>(this.pacijentiUrl, httpOptions).subscribe(
      data => {
        this.pacijenti = data;
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
