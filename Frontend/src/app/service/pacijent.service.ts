import { Pacijent } from '../model/pacijent';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { OperacijaDTO } from '../model/operacijaDTO';
import { Pregled } from '../model/pregled';
import { PregledDTO } from '../model/pregledDTO';


const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };

  @Injectable()
export class PacijentService {
  private requestUrl: string;

  constructor(private http: HttpClient) {

  }

  public izmeniProfil(pacijent: Pacijent) {
    this.requestUrl = '/server/api/pacijent/update';
    const podaci = JSON.stringify(pacijent);
    return this.http.post<Pacijent>(this.requestUrl, podaci, httpOptions);
  }

  public getAll() {
    this.requestUrl = '/server/api/pacijent/all';
    return this.http.get<Array<Pacijent>>(this.requestUrl, httpOptions);
  }

  public getIstorijaOperacija() {
    this.requestUrl = '/server/api/operacija/pacijentOperacije';
    return this.http.get<Array<OperacijaDTO>>(this.requestUrl, httpOptions);
  }

  public getIstorijaPregleda() {
    this.requestUrl = '/server/api/pregled/pacijentPregledi';
    return this.http.get<Array<PregledDTO>>(this.requestUrl, httpOptions);
  }
}
