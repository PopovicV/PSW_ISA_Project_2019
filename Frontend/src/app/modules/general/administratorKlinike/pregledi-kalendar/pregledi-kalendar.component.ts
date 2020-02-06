import {ChangeDetectionStrategy, Component, Inject, OnInit, ViewEncapsulation} from '@angular/core';
import {Sala} from '../../../../model/sala';
import {SalaService} from '../../../../service/sala.service';
import {AdministratorKlinike} from '../../../../model/administratorKlinike';
import {AdministratorKlinikeService} from '../../../../service/administratorKlinike.service';
import {PregledService} from '../../../../service/pregled.service';
import {Pregled} from '../../../../model/pregled';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {LekarService} from '../../../../service/lekar.service';
import {Lekar} from '../../../../model/lekar';
import {TipPregleda} from '../../../../model/tipPregleda';
import {TipPregledaService} from '../../../../service/tip-pregleda.service';


@Component({
  selector: 'app-pregledi-kalendar',
  changeDetection: ChangeDetectionStrategy.OnPush,
  templateUrl: './pregledi-kalendar.component.html',
  styleUrls: ['./pregledi-kalendar.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class PreglediKalendarComponent implements OnInit {
  dataSource: any;
  displayedColumns = ['id', 'datum', 'tip'];
  tableOpened = false;
  calendarOpened = false;
  salaList: Sala[];
  selectedSala: Sala;
  ulogovanAdministrator: AdministratorKlinike;
  selectedDate: string;
  lekarList: Lekar[];
  tipPregledaList: TipPregleda[];
  preglediAll: Pregled[];

  constructor(public dialog: MatDialog,
              private salaService: SalaService,
              private administratorKlinikeService: AdministratorKlinikeService,
              private pregledService: PregledService,
              private lekarService: LekarService,
              private tipPregledaService: TipPregledaService
              ) {
  }

  dateClass = (e: Date) => {
    const anyDate = `${(e.getDate() >= 1 && e.getDate() <= 9) ? '0' + e.getDate().toString() : e.getDate().toString()}/${(e.getMonth() >= 1 && e.getMonth() <= 9) ? '0' + e.getMonth().toString() : e.getMonth().toString()}/${e.getFullYear()}`;
    for (const pregled of this.preglediAll) {
      if (pregled.datum.split('|')[0] === anyDate) {
        return 'example-custom-date-class';
      }
    }
    return undefined;
  }

  ngOnInit(): void {
    this.administratorKlinikeService.getUlogovanKorisnik().subscribe(data => {
      this.ulogovanAdministrator = data;
      this.salaService.getAllFromKlinika(data.klinika).subscribe(data1 => {
          this.salaList = data1;
          this.lekarService.getAllFromKlinika(data.klinika.toString()).subscribe(data2 => {
            this.lekarList = data2;
            this.tipPregledaService.getAllFromKlinika(this.ulogovanAdministrator.klinika).subscribe(data3 => {
              this.tipPregledaList = data3;
          });
        });
      });
    });
  }

  selectDate(e) {
    this.selectedDate = `${(e.getDate() >= 1 && e.getDate() <= 9) ? '0' + e.getDate().toString() : e.getDate().toString()}/${(e.getMonth() >= 1 && e.getMonth() <= 9) ? '0' + e.getMonth().toString() : e.getMonth().toString()}/${1900 + e.getYear()}`;
    this.dataSource = [];
    this.loadDataSource();
    this.tableOpened = true;
  }

  loadDataSource() {
    this.pregledService.getAllFromSala(this.selectedSala.id).subscribe(data => {
      this.preglediAll = data;
      this.dataSource = [];
      for (const pregled of this.preglediAll) {
        const date = pregled.datum;
        if (this.selectedDate === date.split('|')[0]) {
          this.dataSource.push(pregled);
        }
      }
    });
  }

  salaSelected() {
    this.pregledService.getAllFromSala(this.selectedSala.id).subscribe(data => {
      this.preglediAll = data;
      this.calendarOpened = true;
      this.tableOpened = false;
    });
  }
  dodajPregled(): void {
    const dialogRef = this.dialog.open(AddPregledDialogComponent, {
      data: {lekarList: this.lekarList,
        sala: this.selectedSala,
        tipPregledaList: this.tipPregledaList,
        date: this.selectedDate}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result != null) {
        this.pregledService.addPregeled(result).subscribe(data => {
          this.loadDataSource();
          alert(JSON.stringify(this.dataSource));
        });
      }
    });
  }
}

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'add-pregled-dialog',
  templateUrl: './add-pregled-dialog.html',
})
export class AddPregledDialogComponent implements OnInit {
  pregled: Pregled = new Pregled();
  selectedLekar: Lekar = new Lekar();
  lekarListFiltered: Lekar[] = [];
  tipPregledaSelected1: TipPregleda = new TipPregleda();
  tipPregledaList: TipPregleda[] = [];
  selectedSat: number;
  selectedMin: number;
  selectedSatKraj: number;
  selectedMinKraj: number;

  constructor(
    public dialogRef: MatDialogRef<Pregled>,
    @Inject(MAT_DIALOG_DATA) public data) {
  }

  ngOnInit(): void {
  }

  onOkClick(): void {
    this.pregled.tipPregledaId = this.tipPregledaSelected1.id;
    this.pregled.tipPregledaNaziv = this.tipPregledaSelected1.naziv;
    this.pregled.lekarId = this.selectedLekar.id;
    this.pregled.salaId = this.data.sala.id;
    this.pregled.salaNaziv = this.data.sala.naziv;
    this.pregled.rezervisan = false;

    // tslint:disable-next-line:max-line-length
    this.pregled.datum = this.data.date + '|' + ((this.selectedSat >= 0 && this.selectedSat <= 9) ? ('0' + this.selectedSat.toString()) : this.selectedSat.toString())
    + ':' + ((this.selectedMin >= 0 && this.selectedMin <= 9) ? ('0' + this.selectedMin.toString()) : this.selectedMin.toString());

    this.dialogRef.close(this.pregled);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

  tipPregledaSelected() {
    this.lekarListFiltered = [];
    for (const lekar of this.data.lekarList) {
      if (lekar.specijalizacija === this.tipPregledaSelected1.specijalizacija) {
        this.lekarListFiltered.push(lekar);
      }
    }
  }

  onInputChange() {
    if (this.selectedMin != null && this.selectedSat != null) {
      this.selectedSatKraj = this.selectedSat + Math.trunc((this.selectedMin + this.tipPregledaSelected1.trajanje ) / 60);
      this.selectedMinKraj = (this.selectedMin + this.tipPregledaSelected1.trajanje) % 60;
    }
  }
}
