import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort, MatTableDataSource } from '@angular/material';
import { PregledDTO } from 'src/app/model/pregledDTO';
import { TipPregledaService } from 'src/app/service/tip-pregleda.service';
import { TipPregleda } from 'src/app/model/tipPregleda';
import { PregledService } from 'src/app/service/pregled.service';


@Component({
  selector: 'app-pacijent-predefinisani-pregledi',
  templateUrl: './pacijent-predefinisani-pregledi.component.html',
  styleUrls: ['./pacijent-predefinisani-pregledi.component.css']
})
export class PacijentPredefinisaniPreglediComponent implements OnInit {

  pregledi: PregledDTO[] = [];
  dataSource: any;
  tipoviPregleda: TipPregleda[];
  displayedColumns = ['id', 'datum', 'salaNaziv', 'lekarIme', 'lekarPrezime', 'tipPregledaNaziv', 'cenaPregleda', 'actions'];
  selectedTip: TipPregleda = new TipPregleda;

  @ViewChild(MatSort, {static: true}) sort: MatSort;
  
  constructor(private tipPregledService: TipPregledaService, private pregledService: PregledService) {
    this.dataSource = new MatTableDataSource<PregledDTO>(null)
   }

  ngOnInit() {
    this.tipPregledService.getAllTipPregleda().subscribe(
      data => {
        this.tipoviPregleda = data;
      }
    )
  }



  public zakazi(id: number) {
    this.pregledService.zakaziPredefinisan(id).subscribe(
      data => {
        alert("Uspesno ste zakazali pregled, uskoro ce vam stici mejl sa svim podacima.");
        this.next();
      }
    )
  }

  public next() {
    this.pregledi = [];
    this.pregledService.getPredefinisaniSaTipom(this.selectedTip.id).subscribe(
      data => {
      this.pregledi = data;
      this.dataSource = new MatTableDataSource<PregledDTO>(this.pregledi);
      this.dataSource.sort = this.sort;
      }
    )
  }

}
