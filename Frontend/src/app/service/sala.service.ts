import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Sala} from '../model/sala';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class SalaService {
  private requestUrl: string;

  constructor(private http: HttpClient) { }

  public getAllFromKlinika(klinikaId: number) {
    this.requestUrl = '/server/api/sala/allFromKlinika/' + klinikaId;
    return this.http.get<Array<Sala>>(this.requestUrl, httpOptions);
  }

  public addSala(sala: Sala) {
    this.requestUrl = '/server/api/sala/addSala';
    return this.http.post<Sala>(this.requestUrl, JSON.stringify(sala), httpOptions);
  }

  public remove(id: number) {
    this.requestUrl =  '/server/api/sala/removeSala/' + id;
    return this.http.post(this.requestUrl, httpOptions);
  }

  public updateSala(sala: Sala) {
    this.requestUrl = '/server/api/sala/updateSala';
    return this.http.post(this.requestUrl, JSON.stringify(sala), httpOptions);
  }
}
