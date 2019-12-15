import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AdministratorKlinickogCentra} from '../model/administratorKlinickogCentra';
import {Injectable} from '@angular/core';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable()
export class AdministratorKlinickogCentraService {

  private ulogovanUrl: string;
  private requestUrl: string;


  constructor(private http: HttpClient) {

  }

  public izmeniProfil(administratorKlinickogCentra: AdministratorKlinickogCentra) {
    this.ulogovanUrl = '/server/api/administratorKlinickogCentra/update';
    const podaci = JSON.stringify(administratorKlinickogCentra);
    return this.http.post<AdministratorKlinickogCentra>(this.ulogovanUrl, podaci, httpOptions);
  }

  public getUlogovanKorisnik() {
    this.requestUrl = '/server/api/administratorKlinickogCentra/ulogovanKorisnik';
    return this.http.get<AdministratorKlinickogCentra>(this.requestUrl, httpOptions);
  }
}
