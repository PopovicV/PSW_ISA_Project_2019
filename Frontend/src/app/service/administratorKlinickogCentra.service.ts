import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AdministratorKlinickogCentra} from '../model/administratorKlinickogCentra';
import {Injectable} from '@angular/core';
import {Pacijent} from '../model/pacijent';



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

  public odobriZahtev(pacijent: Pacijent) {
    this.requestUrl = 'server/api/administratorKlinickogCentra/odobriZahtev';
    const podaci = JSON.stringify(pacijent);
    return this.http.post<Pacijent>(this.requestUrl, podaci, httpOptions);
  }

  public registerAdministratorKlinickogCentra(akc: AdministratorKlinickogCentra) {
    this.requestUrl = 'server/api/administratorKlinickogCentra/add-administrator-klinickog-centra';
    const podaci = JSON.stringify(akc);
    return this.http.post<AdministratorKlinickogCentra>(this.requestUrl, podaci, httpOptions);
  }

}
