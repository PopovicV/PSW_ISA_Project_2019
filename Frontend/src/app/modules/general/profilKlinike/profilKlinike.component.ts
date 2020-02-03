import {Component, Input} from '@angular/core';
import {Klinika} from '../../../model/klinika';
import {AdministratorKlinike} from '../../../model/administratorKlinike';
import {AdministratorKlinikeService} from '../../../service/administratorKlinike.service';
import {KlinikaService} from '../../../service/klinika.service';

@Component({
  selector: 'app-profil-klinike',
  templateUrl: './profilKlinike.component.html'
})

export class ProfilKlinikeComponent {
  klinika: Klinika;

  constructor(private administratorKlinikeService: AdministratorKlinikeService, private klinikaService: KlinikaService) {
    administratorKlinikeService.getUlogovanKorisnik().subscribe(
      data => {
        klinikaService.getKlinika(data.klinika.toString()).subscribe(
          data1 => {
            this.klinika = data1;
            alert(JSON.stringify(data1));
          }
        );
      }
    );
  }
}
