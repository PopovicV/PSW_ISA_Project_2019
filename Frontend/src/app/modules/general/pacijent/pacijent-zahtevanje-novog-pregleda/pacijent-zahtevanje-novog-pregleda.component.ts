import { Component, OnInit, ViewChild } from '@angular/core';
import { Klinika } from 'src/app/model/klinika';
import { TipPregleda } from 'src/app/model/tipPregleda';
import { Lekar } from 'src/app/model/lekar';
import { KlinikaService } from 'src/app/service/klinika.service';
import { TipPregledaService } from 'src/app/service/tip-pregleda.service';
import { LekarService } from 'src/app/service/lekar.service';
import { FormControl } from '@angular/forms';
import { Zahtev } from 'src/app/model/zahtev';
import { MatStepper } from '@angular/material';
import { ZahtevService } from 'src/app/service/zahtev.service';

@Component({
  selector: 'app-pacijent-zahtevanje-novog-pregleda',
  templateUrl: './pacijent-zahtevanje-novog-pregleda.component.html',
  styleUrls: ['./pacijent-zahtevanje-novog-pregleda.component.css']
})
export class PacijentZahtevanjeNovogPregledaComponent implements OnInit {

  @ViewChild('stepper', {static: true}) stepper: MatStepper;

  klinike: Klinika[];
  selectedKlinika: Klinika = new Klinika;
  tipoviPregleda: TipPregleda[];
  selectedTip: TipPregleda = new TipPregleda;
  lekari: Lekar[];
  selectedLekar: Lekar = new Lekar;
  date: Date = new Date();
  datumZaSlanje: string;
  serializedDate = new FormControl((new Date()).toISOString());
  vreme: string;
  zahtevZaSlanje: Zahtev = new Zahtev();

  constructor(private klinikaService: KlinikaService, private tipPregledaService: TipPregledaService, private lekarService: LekarService, private zahtevService: ZahtevService) { }

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
  

    this.datumZaSlanje = dan + "/" + mesec + "/" + godina + "|" + this.vreme;

    this.zahtevZaSlanje.datum = this.datumZaSlanje;
    this.zahtevZaSlanje.klinikaId = this.selectedKlinika.id;
    this.zahtevZaSlanje.lekarId = this.selectedLekar.id;
    this.zahtevZaSlanje.tipPregledaId = this.selectedTip.id;
    this.zahtevZaSlanje.tip = "PREGLED";

    this.stepper.reset()

    this.zahtevService.pacijentAddZahtev(this.zahtevZaSlanje).subscribe(
      data => {
        alert("Zahtev uspesno poslat.")
      }
    )
  }

}
