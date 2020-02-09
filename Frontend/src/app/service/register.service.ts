import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Pacijent} from '../model/pacijent';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};


@Injectable()
export class RegisterService {
  private registerUrl: string;

  constructor(private http: HttpClient) {
    this.registerUrl = '/server/api/register';
  }

  public logIn(pacijent: Pacijent) {
    let podaci = JSON.stringify(pacijent);
    return this.http.post<Pacijent>(this.registerUrl, podaci, httpOptions);
  }
  public verify(token: String) {
    this.registerUrl = '/server/api/register/registrationConfirm?' + token;
    return this.http.get<String>(this.registerUrl, httpOptions)
  } 
}
