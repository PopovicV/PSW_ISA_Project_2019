import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Klinika} from '../model/klinika';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type' : 'application/json'})
};

@Injectable()
export class KlinikaService {
  private requestUrl: string;
  klinike: Array<Klinika>;
  constructor(private http: HttpClient) {}

  public update(klinika: Klinika) {
    this.requestUrl = '/server/api/klinika/update';
    const podaci = JSON.stringify(klinika);
    return this.http.post<Klinika>(this.requestUrl, podaci, httpOptions);
  }

  public getAll() {
    this.requestUrl = 'server/api/klinika/all';
    return this.http.get<Array<Klinika>>(this.requestUrl, httpOptions);
  }

}
