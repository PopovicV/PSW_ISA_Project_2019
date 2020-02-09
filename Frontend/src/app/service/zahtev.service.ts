import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Zahtev} from '../model/zahtev';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class ZahtevService {
  private requestUrl: string;

  constructor(private http: HttpClient) { }

  public getAllFromKlinika(idKlinike: string) {
    this.requestUrl = '/server/api/zahtev/allFromKlinika/' + idKlinike;
    return this.http.get<Array<Zahtev>>(this.requestUrl, httpOptions);
  }

  public addZahtev(zahtev: Zahtev) {
    this.requestUrl = '/server/api/zahtev/addZahtev';
    return this.http.post<Zahtev>(this.requestUrl, JSON.stringify(zahtev), httpOptions);
  }
}
