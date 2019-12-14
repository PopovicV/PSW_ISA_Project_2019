import { Pacijent } from '../model/pacijent';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';


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
    console.log(podaci)
    return this.http.post<Pacijent>(this.requestUrl, podaci, httpOptions);
  }
}