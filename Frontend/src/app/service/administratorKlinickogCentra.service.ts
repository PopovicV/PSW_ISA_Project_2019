import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

export class AdministratorKlinickogCentraService {
  private ulogovanUrl: string;

  constructor(private http: HttpClient) {

  }

  public izmeniProfil() {

  }
}
