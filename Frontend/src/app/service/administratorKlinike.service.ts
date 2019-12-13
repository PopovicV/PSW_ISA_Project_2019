import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {AdministratorKlinike} from '../model/administratorKlinike';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable()
export class AdministratorKlinikeService {
  private requestUrl: string;

  constructor(private http: HttpClient) {

  }

  public izmeniProfil(administratorKlinike: AdministratorKlinike) {
    this.requestUrl = '/server/api/administratorKlinike/update';
    const podaci = JSON.stringify(administratorKlinike);
    return this.http.post<AdministratorKlinike>(this.requestUrl, podaci, httpOptions);
  }
}