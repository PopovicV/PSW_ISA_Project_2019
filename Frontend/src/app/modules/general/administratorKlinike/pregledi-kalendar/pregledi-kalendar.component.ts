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
import {stringify} from 'querystring';
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
  displayedColumns = ['id', 'naziv'];
  tableOpened = false;
  calendarOpened = false;
  salaList: Sala[];
  selectedSala: Sala;
  ulogovanAdministrator: AdministratorKlinike;
  selectedDate: string;
  lekarList: Lekar[];
  tipPregledaList: TipPregleda[];

  constructor(public dialog: MatDialog,
              private salaService: SalaService,
              private administratorKlinikeService: AdministratorKlinikeService,
              private pregledService: PregledService,
              private lekarService: LekarService,
              private tipPregledaService: TipPregledaService
              ) {
    this.administratorKlinikeService.getUlogovanKorisnik().subscribe(data => {
      this.ulogovanAdministrator = data;
      this.salaService.getAllFromKlinika(data.klinika).subscribe(data1 => {
        this.salaList = data1;
      });
    });
  }

  dateClass = (d: Date) => {
    const date = d.getDate();
    return (date === 1 || date === 20) ? 'example-custom-date-class' : undefined;
  }

  ngOnInit(): void {
    this.lekarService.getAllFromKlinika(stringify(this.selectedSala.klinikaId)).subscribe(data => {
      this.lekarList = data;
      this.tipPregledaService.getAllFromKlinika(this.selectedSala.klinikaId).subscribe(data1 => {
        this.tipPregledaList = data1;
      });
    });
  }

  selectDate(e) {
    this.selectedDate = e.getDate() + '/' + e.getMonth() + '/' + (1900 + e.getYear());
    this.tableOpened = true;
  }

  salaSelected() {
    this.pregledService.getAllFromSala(this.selectedSala.id).subscribe(data => {
      this.dataSource = data;
    });
    this.calendarOpened = true;
    this.tableOpened = false;
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
        this.pregledService.addPregeled(result).subscribe();
        this.ngOnInit();
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
  constructor(
    public dialogRef: MatDialogRef<Pregled>,
    private lekarService: LekarService,
    @Inject(MAT_DIALOG_DATA) public data) {
  }

  ngOnInit(): void {

  }

  onOkClick(): void {
    this.dialogRef.close(this.pregled);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
