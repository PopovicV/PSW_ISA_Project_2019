import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Pregled} from '../model/pregled';
import { TipPregleda } from '../model/tipPregleda';
import { PregledDTO } from '../model/pregledDTO';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class PregledService {
  private requestUrl: string;
  constructor(private http: HttpClient) { }

  public getAllFromKlinika(klinikaId: number) {
    this.requestUrl = '/server/api/pregled/allFromKlinika/' + klinikaId;
    return this.http.get<Array<Pregled>>(this.requestUrl, httpOptions);
  }

  public addPregeled(pregled: Pregled) {
    this.requestUrl = '/server/api/pregled/addPregled';
    alert(JSON.stringify(pregled));
    return this.http.post<Pregled>(this.requestUrl, JSON.stringify(pregled), httpOptions);
  }

  getAllFromSala(id: number) {
    this.requestUrl = '/server/api/pregled/allFromSala/' + id;
    return this.http.get<Array<Pregled>>(this.requestUrl, httpOptions);
  }

  getPredefinisaniSaTipom(id: number) {
    this.requestUrl = '/server/api/pregled/predefinisaniSaTipom/' + id;
    return this.http.get<Array<PregledDTO>>(this.requestUrl, httpOptions);
  }

  zakaziPredefinisan(id: number) {
    this.requestUrl = '/server/api/pregled//zakaziPredefinisan/' + id;
    return this.http.get<PregledDTO>(this.requestUrl, httpOptions);
  }
}
