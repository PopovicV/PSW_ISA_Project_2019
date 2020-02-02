import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Klinika} from '../model/klinika';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class KlinikaService {
  private requestUrl: string;
  constructor(private http: HttpClient) { }

   public update(klinika: Klinika) {
    this.requestUrl = '/server/api/klinika/update';
    const podaci = JSON.stringify(klinika);
    return this.http.post<Klinika>(this.requestUrl, podaci, httpOptions);
  }

  public getAll() {
    this.requestUrl = 'server/api/klinika/all';
    return this.http.get<Array<Klinika>>(this.requestUrl, httpOptions);
  }
  
  public getKlinika(id: string) {
    this.requestUrl = '/server/api/klinika/' + id;
    return this.http.get<Klinika>(this.requestUrl, httpOptions);
  }
}
