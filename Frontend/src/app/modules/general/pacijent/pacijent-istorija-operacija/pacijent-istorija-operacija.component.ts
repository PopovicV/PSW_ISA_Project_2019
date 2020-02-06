import { Component, OnInit, ViewChild } from '@angular/core';
import { PacijentService } from 'src/app/service/pacijent.service';
import { OperacijaDTO } from 'src/app/model/operacijaDTO';
import { MatSort, MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-pacijent-istorija-operacija',
  templateUrl: './pacijent-istorija-operacija.component.html',
  styleUrls: ['./pacijent-istorija-operacija.component.css']
})
export class PacijentIstorijaOperacijaComponent implements OnInit {

  operacije: OperacijaDTO[];
  dataSource: any;
  displayedColumns = ['id', 'tipOperacije', 'nazivSale', 'datum', 'trajanje'];

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private pacijentService: PacijentService) { 
    this.dataSource = new MatTableDataSource<OperacijaDTO>(null);
  }

  ngOnInit() {
    this.pacijentService.getIstorijaOperacija().subscribe(
      data => {
        this.operacije = data;
        this.dataSource = new MatTableDataSource<OperacijaDTO>(this.operacije);
        this.dataSource.sort = this.sort;
      }
    )
  }

}
