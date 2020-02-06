import { Component, OnInit } from '@angular/core';
import {AdministratorKlinike} from '../../../../model/administratorKlinike';
import {AdministratorKlinikeService} from '../../../../service/administratorKlinike.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-administrator-klinike-profil-page',
  templateUrl: './administrator-klinike-profil-page.component.html',
  styleUrls: ['./administrator-klinike-profil-page.component.css']
})
export class AdministratorKlinikeProfilPageComponent implements OnInit {
  ulogovanKorisnik: AdministratorKlinike;
  izmeniProfilForm: FormGroup;
  izmenjenAdmin: AdministratorKlinike;
  constructor(private administratorKlinikeService: AdministratorKlinikeService) { }

  ngOnInit() {
    this.administratorKlinikeService.getUlogovanKorisnik().subscribe( data => {
      this.ulogovanKorisnik = data;
      this.izmenjenAdmin = data;
    });
    this.izmeniProfilForm = new FormGroup({
      ime: new FormControl('', Validators.required),
      prezime: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      lozinka: new FormControl('', Validators.required),
      kontaktTelefon: new FormControl('', Validators.required),
    });
  }

  public onSubmit() {
    const lozinka = (document.getElementById('lozinka') as HTMLInputElement).value;
    const lozinkaConfirm = (document.getElementById('lozinkaConfirm') as HTMLInputElement).value;

    if (lozinka === lozinkaConfirm) {
      this.administratorKlinikeService.izmeniProfil(this.izmenjenAdmin).subscribe(
        data => {
          this.izmeniProfilForm.reset();
          this.ulogovanKorisnik = this.izmenjenAdmin;
          return true;
        },
      );
    } else {
      alert('Lozinke se ne poklapaju!');
    }
  }

  public onCancel() {
    this.izmenjenAdmin = this.ulogovanKorisnik;
    this.izmeniProfilForm.reset();
  }
}
