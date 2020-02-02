import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {LekarService} from '../../service/lekar.service';
import {PacijentiTableDataSource, PacijentiTableItem} from '../../pacijenti-table/pacijenti-table-datasource';
import {AdministratorKlinikeService} from '../../service/administratorKlinike.service';
import {Lekar} from '../../model/lekar';
import {MatSort} from '@angular/material/sort';
import {LekariTableDataSource} from './lekari-table-data-source';

@Component({
  selector: 'app-lekari-table',
  templateUrl: './lekari-table.component.html',
  styleUrls: ['./lekari-table.component.css']
})

export class LekariTableComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['ime', 'prezime'];
  dataSource: LekariTableDataSource;
  lekarList: Lekar[];
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<Lekar>;

  constructor(private lekarService: LekarService, private administratorKlinikeService: AdministratorKlinikeService) {
    this.dataSource = new LekariTableDataSource(null);
  }

  ngOnInit(): void {
    this.dataSource.paginator = this.paginator;
    this.administratorKlinikeService.getUlogovanKorisnik().subscribe(
      data => {
        this.lekarService.getAllFromKlinika(data.klinika.toString()).subscribe(
          data1 => {
            this.lekarList = data1;
            this.dataSource = new LekariTableDataSource(this.lekarList);
          }
        );
      }
    );
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }
}
