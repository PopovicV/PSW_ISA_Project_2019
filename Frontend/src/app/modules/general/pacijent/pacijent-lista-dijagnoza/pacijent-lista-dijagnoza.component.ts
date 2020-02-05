import { Component, OnInit, ViewChild } from '@angular/core';
import { Dijagnoza } from 'src/app/model/dijagnoza';
import { MatSort, MatTableDataSource } from '@angular/material';
import { DijagnozaService } from 'src/app/service/dijagnoza.service';
@Component({
  selector: 'app-pacijent-lista-dijagnoza',
  templateUrl: './pacijent-lista-dijagnoza.component.html',
  styleUrls: ['./pacijent-lista-dijagnoza.component.css']
})
export class PacijentListaDijagnozaComponent implements OnInit {

  dijagnoze: Dijagnoza[];
  dataSource: any;
  displayedColumns = ['id', 'nazivDijagnoze', 'sifraDijagnoze'];

  @ViewChild(MatSort, {static: true}) sort: MatSort;

  constructor(private dijagnozaService: DijagnozaService) {
    this.dataSource = new MatTableDataSource<Dijagnoza>(null);
  }

  ngOnInit() {
     this.dijagnozaService.getDijagnozeUlogovan().subscribe(
       data => {
         this.dijagnoze = data;
         this.dataSource = new MatTableDataSource<Dijagnoza>(this.dijagnoze);
         this.dataSource.sort = this.sort;
       });
  }

}
