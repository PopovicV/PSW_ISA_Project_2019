import {Component, OnInit} from '@angular/core';
import {environment} from '../../../../environments/environment';
import {Klinika} from '../../../model/klinika';
import {RegistracijaKlinikeService} from '../../../service/registracijaKlinike.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';


@Component({
  selector: 'app-registracija-klinike',
  templateUrl: './registracijaKlinike.component.html'
})

export class RegistracijaKlinikeComponent {

  name = environment.application.name;
  angular = environment.application.angular;
  bootstrap = environment.application.bootstrap;

  klinika: Klinika;
  forma: FormGroup;

  constructor(private registracijaKlinikeService: RegistracijaKlinikeService) {
    this.klinika = new Klinika();
  }

  ngOnInit() {
    this.forma = new FormGroup({
      ime: new FormControl('', Validators.required),
      adresa: new FormControl('', Validators.required),
      kontaktTelefon: new FormControl('', Validators.required),
      opis: new FormControl('', Validators.required),
    });
  }

}
