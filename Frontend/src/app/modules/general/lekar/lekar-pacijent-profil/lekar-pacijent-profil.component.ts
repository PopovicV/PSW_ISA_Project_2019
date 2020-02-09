import { Component, OnInit } from '@angular/core';
import {environment} from '../../../../../environments/environment';
import {Pacijent} from '../../../../model/pacijent';
import {PacijentService} from '../../../../service/pacijent.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-lekar-pacijent-profil',
  templateUrl: './lekar-pacijent-profil.component.html',
  styleUrls: ['./lekar-pacijent-profil.component.css']
})
export class LekarPacijentProfilComponent implements OnInit {
  name = environment.application.name;
  angular = environment.application.angular;
  bootstrap = environment.application.bootstrap;
  id: number;

  pacijent: Pacijent = new Pacijent();
  constructor(private pacijentSrevice: PacijentService,
              private router: Router) {
  }

  ngOnInit() {
    const url = this.router.url;
    const splitted = url.split('=');
    this.id = parseInt(splitted[1], 10);
    this.pacijentSrevice.getPacijent(this.id).subscribe(data => {
      this.pacijent = data;
    });
  }

  openZdravstveniKarton() {
    this.router.navigate(['lekar/zdravstveniKarton', {id: this.id}]);
  }

  openZapocniPregled() {
    this.router.navigate(['lekar/zapocniPregled', {id: this.id}]);
  }
}
