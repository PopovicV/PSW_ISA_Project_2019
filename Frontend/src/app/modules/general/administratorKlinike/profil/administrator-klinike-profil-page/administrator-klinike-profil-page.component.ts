import { Component, OnInit } from '@angular/core';
import {AdministratorKlinike} from '../../../../../model/administratorKlinike';
import {AdministratorKlinikeService} from '../../../../../service/administratorKlinike.service';

@Component({
  selector: 'app-administrator-klinike-profil-page',
  templateUrl: './administrator-klinike-profil-page.component.html',
  styleUrls: ['./administrator-klinike-profil-page.component.css']
})
export class AdministratorKlinikeProfilPageComponent implements OnInit {
  ulogovanKorisnik: AdministratorKlinike;
  constructor(private administratorKlinikeService: AdministratorKlinikeService) { }

  ngOnInit() {
    this.administratorKlinikeService.getUlogovanKorisnik().subscribe( data => {
      this.ulogovanKorisnik = data;
    });
  }

}
