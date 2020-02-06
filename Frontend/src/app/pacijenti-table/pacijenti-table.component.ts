import {AfterViewInit, Component, Input, OnInit, ViewChild} from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable } from '@angular/material/table';
import { PacijentiTableDataSource, PacijentiTableItem } from './pacijenti-table-datasource';
import {Pacijent} from '../model/pacijent';
import {PacijentService} from '../service/pacijent.service';
import {AdministratorKlinickogCentraService} from '../service/administratorKlinickogCentra.service';

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
  pacijenti: Pacijent[] = [];
  lista: Pacijent[] = [];
  pacijent: Pacijent;
  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['Id', 'ime', 'prezime', 'email', 'akcije'];

  constructor(private pacijentService: PacijentService, private administratorKlinickogCentraService: AdministratorKlinickogCentraService) {
    this.dataSource = new PacijentiTableDataSource(null);
  }

  ngOnInit() {
    this.pacijentService.getAll().subscribe(
      data => {
        this.lista = data;
        this.pacijenti = [];
        for (const p of this.lista) {
          if (p.adminAktiviraoNalog === 'NE') {
            this.pacijenti.push(p);
          }
        }

        this.dataSource = new PacijentiTableDataSource(this.pacijenti);
      }
    );
  }

  odobriZahtev(id: number) {
    this.pacijentService.getPacijent(id).subscribe(
      data => {
        this.administratorKlinickogCentraService.odobriZahtev(data).subscribe();
      }
    );
    this.ngOnInit();
  }

  ngAfterViewInit() {
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
      this.table.dataSource = this.dataSource;
  }
}
