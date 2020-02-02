import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable } from '@angular/material/table';
import { KlinikeTableDataSource, KlinikeTableItem } from './klinike-table-datasource';
import {Klinika} from '../model/klinika';
import {KlinikaService} from '../service/klinika.service';

@Component({
  selector: 'app-klinike-table',
  templateUrl: './klinike-table.component.html',
  styleUrls: ['./klinike-table.component.css']
})
export class KlinikeTableComponent implements AfterViewInit, OnInit {
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<KlinikeTableItem>;
  dataSource: KlinikeTableDataSource;
  klinike: Klinika[] = new Array();

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'ime', 'adresa', 'opis'];

  constructor(private klinikaService: KlinikaService) {
    this.dataSource = new KlinikeTableDataSource(null);
  }

  ngOnInit() {
    this.klinikaService.getAll().subscribe(
      data => {
        this.klinike = data;
        this.dataSource = new KlinikeTableDataSource(this.klinike);
        alert(JSON.stringify(data));
      }
    );
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }
}
