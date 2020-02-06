import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Lekar } from '../model/lekar';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class LekarService {
  private requestUrl: string;

  constructor(private http: HttpClient) { }

  public getAllFromKlinika(idKlinike: string) {
    this.requestUrl = '/server/api/lekar/allFromKlinika/' + idKlinike;
    return this.http.get<Array<Lekar>>(this.requestUrl, httpOptions);
  }

  public registerLekar(lekar: Lekar) {
    this.requestUrl = '/server/api/lekar/addLekar';
    return this.http.post<Lekar>(this.requestUrl, JSON.stringify(lekar), httpOptions);
  }

  public remove(id: number) {
    this.requestUrl =  '/server/api/lekar/removeLekar/' + id;
    return this.http.post(this.requestUrl, httpOptions);
  }
}
