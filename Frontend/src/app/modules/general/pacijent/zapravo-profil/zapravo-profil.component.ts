import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Pacijent } from 'src/app/model/pacijent';
import { FormGroup } from '@angular/forms';
import { Klinika } from 'src/app/model/klinika';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { PacijentService } from 'src/app/service/pacijent.service';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Component({
  selector: 'app-zapravo-profil',
  templateUrl: './zapravo-profil.component.html',
  styleUrls: ['./zapravo-profil.component.css']
})
export class ZapravoProfilComponent implements OnInit {

    name = environment.application.name;
    angular = environment.application.angular;
    bootstrap = environment.application.bootstrap;

    ulogovanUrl: string;
    klinikeUrl: string;
    ulogovanKorisnik: Pacijent;
    izmenaForm: FormGroup;
    klinike: Array<Klinika>;


    constructor(private http: HttpClient, private pacijentService: PacijentService) {
        this.ulogovanUrl = '/server/api/pacijent/ulogovanKorisnik';
        this.http.get<Pacijent>(this.ulogovanUrl, httpOptions).subscribe(
          data => {
            this.ulogovanKorisnik = data;
          }
        );
        
        this.klinikeUrl = '/server/api/klinika/all';
        this.http.get<Array<Klinika>>(this.klinikeUrl, httpOptions).subscribe(
          data => {
            this.klinike = data;
          }
        )

      }

      onSubmit() {
        const lozinka = (document.getElementById('lozinka') as HTMLInputElement).value;
        const lozinkaConfirm = (document.getElementById('lozinkaConfirm') as HTMLInputElement).value;
    
        if (lozinka === lozinkaConfirm) {
          this.pacijentService.izmeniProfil(this.ulogovanKorisnik).subscribe(
            data => {
              this.izmenaForm.reset();
              return true;
            },
          );
        }
      }

  ngOnInit() {
  }

}
