import { Klinika } from '../model/klinika';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  };

  @Injectable()
  export class KlinikaService {
      private listaKlinika: string;
  
  constructor(private http: HttpClient) {
      this.listaKlinika = '/server/api/klinika/all';
  }
  
  public getKlinike() {
      
      return this.http.get<Array<Klinika>>(this.listaKlinika, httpOptions);
  }
  
  }
  