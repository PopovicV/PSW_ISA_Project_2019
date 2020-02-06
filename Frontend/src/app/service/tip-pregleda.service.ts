import { Injectable } from '@angular/core';
import {TipPregleda} from '../model/tipPregleda';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};


@Injectable({
  providedIn: 'root'
})
export class TipPregledaService {
  requestUrl: string;
  constructor(private http: HttpClient) { }

  getAllFromKlinika(klinikaId: number) {
    this.requestUrl = '/server/api/tipPregleda/allFromKlinika/' + klinikaId;
    return this.http.get<Array<TipPregleda>>(this.requestUrl, httpOptions);
  }

  addTipPregleda(tipPregleda: TipPregleda) {
    this.requestUrl = '/server/api/tipPregleda/addTipPregleda';
    return this.http.post<TipPregleda>(this.requestUrl, JSON.stringify(tipPregleda), httpOptions);
  }
}
