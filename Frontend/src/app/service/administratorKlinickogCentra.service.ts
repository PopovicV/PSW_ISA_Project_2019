import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {AdministratorKlinickogCentra} from '../model/administratorKlinickogCentra';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable()
export class AdministratorKlinickogCentraService {
  private requestUrl: string;

  constructor(private http: HttpClient) {

  }

  public getUlogovanKorisnik() {
    this.requestUrl = '/server/api/administratorKlinickogCentra/ulogovanKorisnik';
    return this.http.get<AdministratorKlinickogCentra>(this.requestUrl, httpOptions);
  }
}
