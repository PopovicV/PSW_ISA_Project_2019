import { Korisnik } from '../model/korisnik';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };
  
@Injectable()
export class LoginService {
    private loginUrl: string;

constructor(private http: HttpClient) {
    this.loginUrl = '/server/api/login';
}

public logIn(korisnik: Korisnik) {
    let podaci = JSON.stringify(korisnik);
    console.log(podaci);
    return this.http.post<Korisnik>(this.loginUrl, podaci, httpOptions)
}

}