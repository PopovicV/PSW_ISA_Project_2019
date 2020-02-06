import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Dijagnoza } from '../model/dijagnoza';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class DijagnozaService {
  private requestUrl: string;

  constructor(private http: HttpClient) { }

  public getDijagnozeUlogovan() {
    this.requestUrl = '/server/api/zdravstveniKarton/dijagnoze';
    return this.http.get<Array<Dijagnoza>>(this.requestUrl, httpOptions);
}
}
