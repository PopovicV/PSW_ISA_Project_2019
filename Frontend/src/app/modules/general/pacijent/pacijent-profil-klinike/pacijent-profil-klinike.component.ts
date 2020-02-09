import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Klinika } from 'src/app/model/klinika';
import { Lekar } from 'src/app/model/lekar';
import { PacijentService } from 'src/app/service/pacijent.service';
import { KlinikaService } from 'src/app/service/klinika.service';
import { LekarService } from 'src/app/service/lekar.service';
import { MatTableDataSource, MatSort } from '@angular/material';

@Component({
  selector: 'app-pacijent-profil-klinike',
  templateUrl: './pacijent-profil-klinike.component.html',
  styleUrls: ['./pacijent-profil-klinike.component.css']
})
export class PacijentProfilKlinikeComponent implements OnInit {

  klinika: Klinika;
  lekari: Lekar[]
  dataSource: any;
  displayedColumns: string[] = ['id', 'ime', 'prezime', 'specijalizacija', 'ocena'];

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private router: Router, private klinikaService: KlinikaService, private lekarService: LekarService) { 
    this.dataSource = new MatTableDataSource<Lekar>(null);
  }

  ngOnInit() {
    let url = this.router.url;
    let splitted = url.split("=");
    let id = splitted[1];
    alert("Id klinike koji mi treba je: "+id);

    this.klinikaService.getKlinika(id).subscribe(
      data => {
        this.klinika = data;
      });

    this.lekarService.getAllFromKlinika(id).subscribe(
      data => {
        alert(JSON.stringify(data));
        console.log(JSON.stringify(data));
        this.lekari = data;
        this.dataSource = new MatTableDataSource<Lekar>(this.lekari);
        this.dataSource.sort = this.sort;
      });
    
  }

  public doFilter(value: string) {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

}
