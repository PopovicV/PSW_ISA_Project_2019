import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ZahtevZaGodisnji} from '../model/zahtevZaGodisnji';
import {Odbijenica} from '../model/odbijenica';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};
@Injectable({
  providedIn: 'root'
})
export class ZahtevZaGodisnjiService {
  private requestUrl: string;
  constructor(private http: HttpClient) { }

  public getAllFromKlinika(idKlinike: number) {
    this.requestUrl = '/server/api/zahtevZaGodisnji/allFromKlinika/' + idKlinike;
    return this.http.get<Array<ZahtevZaGodisnji>>(this.requestUrl, httpOptions);
  }

  public prihvatiZahtev(id: number) {
    this.requestUrl = '/server/api/zahtevZaGodisnji/' + id;
    return this.http.post(this.requestUrl, httpOptions);
  }

  public odbijZahtev(odbijenica: Odbijenica) {
    this.requestUrl = '/server/api/zahtevZaGodisnji/odbij';
    alert(JSON.stringify(odbijenica));
    return this.http.post(this.requestUrl, JSON.stringify(odbijenica), httpOptions);
  }
}
