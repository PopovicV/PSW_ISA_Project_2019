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
    /*any x = this.http.get<Array<Pacijent>>(this.requestUrl, httpOptions);
    */
    return this.http.get<Array<Pacijent>>(this.requestUrl, httpOptions);
  }

  public getPacijent(id: number) {
    this.requestUrl = 'server/api/pacijent/' + id;
    return this.http.get<Pacijent>(this.requestUrl, httpOptions);
  }

  public getIstorijaOperacija() {
    this.requestUrl = '/server/api/operacija/pacijentOperacije';
    return this.http.get<Array<OperacijaDTO>>(this.requestUrl, httpOptions);
  }

  public getIstorijaPregleda() {
    this.requestUrl = '/server/api/pregled/pacijentPregledi';
    return this.http.get<Array<PregledDTO>>(this.requestUrl, httpOptions);
  }

  public getAllFromKlinika(id: number) {
    this.requestUrl = '/server/api/pacijent/allFromKlinika/' + id;
    return this.http.get<Array<Pacijent>>(this.requestUrl, httpOptions);
  }
}
