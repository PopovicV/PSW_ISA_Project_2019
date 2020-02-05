import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable } from '@angular/material/table';
import {MatTableDataSource} from '@angular/material';
import { PacijentiTableDataSource } from 'src/app/pacijenti-table/pacijenti-table-datasource';
import { Pacijent } from 'src/app/model/pacijent';
import { KlinikaService } from 'src/app/service/klinika.service';
import { Klinika } from 'src/app/model/klinika';
import { MatFormFieldModule, MatInputModule } from '@angular/material';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pacijent-lista-klinika',
  templateUrl: './pacijent-lista-klinika.component.html',
  styleUrls: ['./pacijent-lista-klinika.component.css']
})
export class PacijentListaKlinikaComponent implements OnInit {
  klinike: Klinika[];
  dataSource: any;
  displayedColumns = ['id', 'ime', 'adresa', 'opis'];

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private klinikaService: KlinikaService, private router: Router) {
    this.dataSource = new MatTableDataSource<Klinika>(null);
  }

  ngOnInit() {
    this.klinikaService.getKlinike().subscribe(
      data => {
        this.klinike = data;
        this.dataSource = new MatTableDataSource<Klinika>(this.klinike);
        this.dataSource.sort = this.sort;
      });
  }

  public doFilter(value: string) {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  public profilKlinike(id: number) {
    this.router.navigate(['profil-pacijenta/pacijentKlinika', {id: id}]);
  }

}
