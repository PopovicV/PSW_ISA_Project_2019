import { Component } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Pacijent } from 'src/app/model/pacijent';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { PacijentService } from 'src/app/service/pacijent.service';
import { Klinika } from 'src/app/model/klinika';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
}

@Component({
    selector: 'app-profil-pacijenta',
    templateUrl: './profilPacijenta.component.html'
})

export class ProfilPacijentaComponent {

    name = environment.application.name;
    angular = environment.application.angular;
    bootstrap = environment.application.bootstrap;

    ulogovanUrl: string;
    klinikeUrl: string;
    ulogovanKorisnik: Pacijent;
    izmenaForm: FormGroup;
    klinike: Array<Klinika>;

    ngOnInit(): void {
        this.izmenaForm = new FormGroup({
            ime: new FormControl('', Validators.required),
            prezime: new FormControl('', Validators.required),
            email: new FormControl('', Validators.required),
            lozinka: new FormControl('', Validators.required),
            kontaktTelefon: new FormControl('', Validators.required),
            adresa: new FormControl('', Validators.required),
            grad: new FormControl('', Validators.required),
            drzava: new FormControl('', Validators.required),
        })
    }

    // constructor(private http: HttpClient, private pacijentService: PacijentService) {
    //     this.ulogovanUrl = '/server/api/pacijent/ulogovanKorisnik';
    //     this.http.get<Pacijent>(this.ulogovanUrl, httpOptions).subscribe(
    //       data => {
    //         this.ulogovanKorisnik = data;
    //       }
    //     );
        
      //   this.klinikeUrl = '/server/api/klinika/all';
      //   this.http.get<Array<Klinika>>(this.klinikeUrl, httpOptions).subscribe(
      //     data => {
      //       this.klinike = data;
      //     }
      //   )

      // }

      // onSubmit() {
      //   const lozinka = (document.getElementById('lozinka') as HTMLInputElement).value;
      //   const lozinkaConfirm = (document.getElementById('lozinkaConfirm') as HTMLInputElement).value;
    
      //   if (lozinka === lozinkaConfirm) {
      //     this.pacijentService.izmeniProfil(this.ulogovanKorisnik).subscribe(
      //       data => {
      //         this.izmenaForm.reset();
      //         return true;
      //       },
      //     );
      //   }
      // }
}