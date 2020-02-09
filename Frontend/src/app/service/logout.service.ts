import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Korisnik } from '../model/korisnik';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };

@Injectable()
export class LogoutService {
    private logoutUrl: string;

    constructor(private http: HttpClient) {
        this.logoutUrl = '/server/api/login/logout';
    }

    public logout() {
        return this.http.get<Korisnik>(this.logoutUrl, httpOptions);
    }
}