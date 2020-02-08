import { Component, OnInit } from '@angular/core';
import {Zahtev} from '../../../../model/zahtev';
import {LekarService} from '../../../../service/lekar.service';
import {Lekar} from '../../../../model/lekar';
import {Pacijent} from '../../../../model/pacijent';
import {PacijentService} from '../../../../service/pacijent.service';
import {SalaService} from '../../../../service/sala.service';
import {Sala} from '../../../../model/sala';
import {TipPregleda} from '../../../../model/tipPregleda';
import {TipPregledaService} from '../../../../service/tip-pregleda.service';
import {ZahtevService} from '../../../../service/zahtev.service';

@Component({
  selector: 'app-lekar-zakazivanje-pregleda',
  templateUrl: './lekar-zakazivanje-pregleda.component.html',
  styleUrls: ['./lekar-zakazivanje-pregleda.component.css']
})
export class LekarZakazivanjePregledaComponent implements OnInit {
  zahtev: Zahtev = new Zahtev();
  ulogovanKorisnik: Lekar;
  pacijentList: Pacijent[] = [];
  dataSource: any;
  displayedColumns = ['id', 'imePrezime', 'JBO', 'actions'];
  salaList: Sala[] = [];
  selectedSat: number;
  selectedMin: number;
  selectedSatKraj: number;
  selectedMinKraj: number;
  selectedDay: number;
  selectedMonth: number;
  selectedYear: number;
  tipPregedaList: TipPregleda[] = [];
  tipPregledSelected: TipPregleda;
  selectedDate: string;

  constructor(private lekarService: LekarService,
              private pacijentService: PacijentService,
              private salaService: SalaService,
              private tipPregledaService: TipPregledaService,
              private zahtevService: ZahtevService) {
    this.lekarService.getUlogovanKorisnik().subscribe(data => {
      this.ulogovanKorisnik = data;
      this.pacijentService.getAllFromKlinika(data.klinikaId).subscribe(data1 => {
        this.pacijentList = data1;
        this.dataSource = data1;
      });
      this.salaService.getAllFromKlinika(data.klinikaId).subscribe(data1 => {
        this.salaList =  data1;
      });
      this.tipPregledaService.getAllFromKlinika(data.klinikaId).subscribe(data1 => {
        this.tipPregedaList = [];
        for (const tip of data1) {
          if (tip.specijalizacija === this.ulogovanKorisnik.specijalizacija) {
            this.tipPregedaList.push(tip);
          }
        }
      });
    });
  }

  ngOnInit() {
  }

  next() {

  }

  odaberiPacijenta(id: any) {
    this.zahtev.pacijentId = id;
  }

  proslediZahtev() {
    if (this.selectedDay != null && this.selectedMonth != null && this.selectedYear != null) {
      const date = `${(this.selectedDay >= 1 && this.selectedDay <= 9) ? '0' + this.selectedDay.toString() : this.selectedDay.toString()}/${(this.selectedMonth >= 1 && this.selectedMonth <= 9) ? '0' + this.selectedMonth.toString() : this.selectedMonth.toString()}/${this.selectedYear.toString()}`;
      // tslint:disable-next-line:max-line-length
      this.zahtev.datum = date + '|' + ((this.selectedSat >= 0 && this.selectedSat <= 9) ? ('0' + this.selectedSat.toString()) : this.selectedSat.toString())
        + ':' + ((this.selectedMin >= 0 && this.selectedMin <= 9) ? ('0' + this.selectedMin.toString()) : this.selectedMin.toString());

      if (this.zahtev.tip === 'OPERACIJA') {
        this.zahtev.trajanje = (this.selectedSatKraj - this.selectedSat) * 60 + this.selectedMinKraj - this.selectedMin;
        alert(this.zahtev.trajanje);
      } else {
        this.zahtev.trajanje = this.tipPregledSelected.trajanje;
      }

      this.zahtev.lekarId = this.ulogovanKorisnik.id;
      this.zahtev.klinikaId = this.ulogovanKorisnik.klinikaId;
      this.zahtevService.addZahtev(this.zahtev).subscribe(data => {
        alert('Zahtev uspesno prosledjen administratoru. O odobravanju/odbijanju zahteva bicete obavesteni mejlom.');
      });
    } else {
      alert('Neispravno uneseni podaci!');
    }
  }

  onInputChange() {
    if (this.selectedMin != null && this.selectedSat != null && this.zahtev.tip === 'PREGLED') {
      this.selectedSatKraj = this.selectedSat + Math.trunc((this.selectedMin + this.tipPregledSelected.trajanje ) / 60);
      this.selectedMinKraj = (this.selectedMin + this.tipPregledSelected.trajanje) % 60;
    }
  }

  tipPregledaSelectionConfirm() {
    this.zahtev.tipPregledaId = this.tipPregledSelected.id;
  }
}
