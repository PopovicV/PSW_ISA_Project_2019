import { Component, OnInit, ViewChild } from '@angular/core';
import { Pregled } from 'src/app/model/pregled';
import { MatSort, MatTableDataSource } from '@angular/material';
import { PacijentService } from 'src/app/service/pacijent.service';
import { PregledDTO } from 'src/app/model/pregledDTO';

@Component({
  selector: 'app-pacijent-istorija-pregleda',
  templateUrl: './pacijent-istorija-pregleda.component.html',
  styleUrls: ['./pacijent-istorija-pregleda.component.css']
})
export class PacijentIstorijaPregledaComponent implements OnInit {

  pregledi: PregledDTO[];
  dataSource: any;
  displayedColumns = ['id', 'tipPregledaNaziv', 'salaNaziv', 'datum'];

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private pacijentService: PacijentService) {
    this.dataSource = new MatTableDataSource<PregledDTO>(null);
   }

  ngOnInit() {
    this.pacijentService.getIstorijaPregleda().subscribe(
      data => {
        this.pregledi = data;
        this.dataSource = new MatTableDataSource<PregledDTO>(this.pregledi);
        this.dataSource.sort = this.sort;
      }
    )
  }

}
