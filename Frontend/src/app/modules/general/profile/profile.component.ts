import {Component} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Korisnik} from '../../../model/korisnik';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html'
})

export class ProfileComponent {
  ulogovanKorisnik: Korisnik;
  ulogovanUrl: string;

  constructor(private http: HttpClient) {
    this.ulogovanUrl = '/server/api/ulogovanKorisnik';
    this.http.get<Korisnik>(this.ulogovanUrl, httpOptions).subscribe(
      data => {
        this.ulogovanKorisnik = data;
      }
    );
  }

}
