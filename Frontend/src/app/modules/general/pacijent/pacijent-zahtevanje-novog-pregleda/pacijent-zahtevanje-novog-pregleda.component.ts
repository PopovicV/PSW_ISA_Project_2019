import { Component, OnInit } from '@angular/core';
import { Klinika } from 'src/app/model/klinika';
import { TipPregleda } from 'src/app/model/tipPregleda';
import { Lekar } from 'src/app/model/lekar';
import { KlinikaService } from 'src/app/service/klinika.service';
import { TipPregledaService } from 'src/app/service/tip-pregleda.service';
import { LekarService } from 'src/app/service/lekar.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-pacijent-zahtevanje-novog-pregleda',
  templateUrl: './pacijent-zahtevanje-novog-pregleda.component.html',
  styleUrls: ['./pacijent-zahtevanje-novog-pregleda.component.css']
})
export class PacijentZahtevanjeNovogPregledaComponent implements OnInit {

  klinike: Klinika[];
  selectedKlinika: Klinika = new Klinika;
  tipoviPregleda: TipPregleda[];
  selectedTip: TipPregleda = new TipPregleda;
  lekari: Lekar[];
  selectedLekar: Lekar = new Lekar;
  date: Date = new Date();
  datumZaSlanje: String;
  serializedDate = new FormControl((new Date()).toISOString());
  vreme: String;

  constructor(private klinikaService: KlinikaService, private tipPregledaService: TipPregledaService, private lekarService: LekarService) { }

  ngOnInit() {
    this.klinikaService.getKlinike().subscribe(
      data => {
        this.klinike = data;
      }
    )
  }

  public next1() {
    this.tipoviPregleda = [];
    this.tipPregledaService.getAllFromKlinika(this.selectedKlinika.id).subscribe(
      data => {
        this.tipoviPregleda = data;
        alert(JSON.stringify(data));
      }
    )
  }

  public next2() {
    this.lekari = []
    this.lekarService.lekariKlinikaTip(this.selectedTip.id).subscribe(
      data => {
        this.lekari = data;
      }
    )
    alert(JSON.stringify(this.selectedTip))
  }

  onSubmit() {
    let datum = this.date.toLocaleString();
    let splitovano = datum.split(",")
    let samoDatum = splitovano[0];
    let splitovano1 = samoDatum.split("/");
    let godina = splitovano1[2];
    let mesec = splitovano1[0];
    let dan = splitovano1 [1];
    if(Number(mesec) < 10) {
      mesec = "0"+mesec;
    }
    if(Number(dan) < 10) {
      dan = "0"+dan;
    }
    alert("Dan: " + dan + " mesec: " + mesec + "  i vreme: " + this.vreme)


  }

}
