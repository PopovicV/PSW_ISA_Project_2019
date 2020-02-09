import {Component, OnInit, ViewChild} from '@angular/core';
import {Lekar} from '../../../../model/lekar';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {LekarService} from '../../../../service/lekar.service';
import {Pacijent} from '../../../../model/pacijent';
import {PacijentService} from '../../../../service/pacijent.service';
import {Route, Router} from '@angular/router';

@Component({
  selector: 'app-pacijenti-table',
  templateUrl: './lekar-pacijenti-table.component.html',
  styleUrls: ['./lekar-pacijenti-table.component.css']
})
export class LekarPacijentiTableComponent implements OnInit {
  dataSource: any;
  displayedColumns = ['id', 'ime', 'prezime', 'jbo', 'akcije'];
  ulogovanKorisnik: Lekar;
  pacijentiKlinike: Pacijent[] = [];

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<Pacijent>;
  constructor(private lekarService: LekarService,
              private pacijentService: PacijentService,
              private router: Router) { }

  ngOnInit() {
    this.lekarService.getUlogovanKorisnik().subscribe(data => {
      this.ulogovanKorisnik = data;
      this.pacijentService.getAllFromKlinika(this.ulogovanKorisnik.klinikaId).subscribe(data1 => {
        this.pacijentiKlinike = data1;
        this.dataSource = new MatTableDataSource<Pacijent>(this.pacijentiKlinike);
        this.dataSource.sort = this.sort;
      });
    });
  }

  public doFilter(value: string) {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  otvoriProfil(id: any) {
    this.router.navigate(['lekar/pacijentProfil', {id: id}]);
  }
}
