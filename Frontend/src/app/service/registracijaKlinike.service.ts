import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Klinika} from '../model/klinika';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable()
export class RegistracijaKlinikeService {
  private registracijaKlinikeUrl: string;

  constructor(private http: HttpClient) {
    this.registracijaKlinikeUrl = '/server/api/registracija-klinike';
  }

  public registrujKliniku(klinika: Klinika) {
    const podaci = JSON.stringify(klinika);
    return this.http.post<Klinika>(this.registracijaKlinikeUrl, podaci, httpOptions);
  }

}

