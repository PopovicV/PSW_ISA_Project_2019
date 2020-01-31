import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable } from '@angular/material/table';
import { PacijentiTableDataSource, PacijentiTableItem } from './pacijenti-table-datasource';
import {Pacijent} from '../model/pacijent';
import {PacijentService} from '../service/pacijent.service';

@Component({
  selector: 'app-pacijenti-table',
  templateUrl: './pacijenti-table.component.html',
  styleUrls: ['./pacijenti-table.component.css']
})
export class PacijentiTableComponent implements AfterViewInit, OnInit {
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<PacijentiTableItem>;
  dataSource: PacijentiTableDataSource;
  pacijenti: Pacijent[];
  temp: Pacijent[] = new Array();
  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'ime'];

  constructor(private pacijentService: PacijentService) {
    this.dataSource = new PacijentiTableDataSource(null);
  }

  ngOnInit() {
    this.pacijentService.getAll().subscribe(
      data => {
        this.pacijenti = data;
        this.dataSource = new PacijentiTableDataSource(this.pacijenti);
      }
    );
  }

  ngAfterViewInit() {
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
      this.table.dataSource = this.dataSource;
  }
}
