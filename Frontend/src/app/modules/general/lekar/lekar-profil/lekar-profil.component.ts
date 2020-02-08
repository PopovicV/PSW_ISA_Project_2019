import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {LekarService} from '../../../../service/lekar.service';
import {Lekar} from '../../../../model/lekar';

@Component({
  selector: 'app-lekar-profil',
  templateUrl: './lekar-profil.component.html',
  styleUrls: ['./lekar-profil.component.css']
})
export class LekarProfilComponent implements OnInit {
  ulogovanKorisnik: Lekar;
  izmeniProfilForm: FormGroup;
  izmenjenLekar: Lekar;
  constructor(private lekarService: LekarService) { }

  ngOnInit() {
    this.lekarService.getUlogovanKorisnik().subscribe( data => {
      this.ulogovanKorisnik = data;
      this.izmenjenLekar = data;
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
      this.lekarService.izmeniProfil(this.izmenjenLekar).subscribe(
        data => {
          this.izmeniProfilForm.reset();
          this.ulogovanKorisnik = this.izmenjenLekar;
          return true;
        },
      );
    } else {
      alert('Lozinke se ne poklapaju!');
    }
  }

  public onCancel() {
    this.izmenjenLekar = this.ulogovanKorisnik;
    this.izmeniProfilForm.reset();
  }
}
