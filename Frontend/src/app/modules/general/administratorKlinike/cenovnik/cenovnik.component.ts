import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {TipPregleda} from '../../../../model/tipPregleda';
import {AdministratorKlinike} from '../../../../model/administratorKlinike';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {AdministratorKlinikeService} from '../../../../service/administratorKlinike.service';
import {TipPregledaService} from '../../../../service/tip-pregleda.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {UpdateSalaDialogComponent} from '../sale-table/sale-table.component';
import {Pregled} from '../../../../model/pregled';
import {PregledService} from '../../../../service/pregled.service';
import {LekarService} from '../../../../service/lekar.service';
import {Lekar} from '../../../../model/lekar';

@Component({
  selector: 'app-cenovnik',
  templateUrl: './cenovnik.component.html',
  styleUrls: ['./cenovnik.component.css']
})
export class CenovnikComponent implements OnInit {
  tipPregledaList: TipPregleda[];
  dataSource: any;
  displayedColumns = ['id', 'naziv', 'cena', 'actions'];
  ulogovanKorisnik: AdministratorKlinike;
  dialogData: TipPregleda;
  specijalizacijeList: string[] = [];

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<TipPregleda>;
  constructor(public dialog: MatDialog, private tipPregledaService: TipPregledaService,
              private pregledService: PregledService,
              private lekarService: LekarService,
              private administratorKlinikeService: AdministratorKlinikeService) { }

  ngOnInit() {
    this.administratorKlinikeService.getUlogovanKorisnik().subscribe(data => {
      this.ulogovanKorisnik = data;
      this.tipPregledaService.getAllFromKlinika(data.klinika).subscribe(data1 => {
        this.tipPregledaList = data1;
        this.dataSource = new MatTableDataSource<TipPregleda>(this.tipPregledaList);
        this.dataSource.sort = this.sort;
      });
      this.lekarService.getAllFromKlinika(this.ulogovanKorisnik.klinika.toString()).subscribe(data1 => {
        this.specijalizacijeList = [];
        for (const lekar of data1) {
          this.specijalizacijeList.push(lekar.specijalizacija);
        }
      });
    });
  }

  public doFilter(value: string) {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  openDialog(): void {
      const dialogRef = this.dialog.open(AddTipPregledaDialogComponent, {
        data: {
          sala: this.dialogData,
          specijalizacijaList: this.specijalizacijeList
        }
      });
      dialogRef.afterClosed().subscribe(result => {
        if (result != null) {
          result.klinikaId = this.ulogovanKorisnik.klinika;
          this.tipPregledaService.addTipPregleda(result).subscribe();
          this.ngOnInit();
        }
      });
  }

  openUpdateDialog(tp: TipPregleda): void {
    const dialogRef = this.dialog.open(UpdateTipPregledaDialogComponent, {
      data: {tipPregleda: tp,
             specijalizacijaList: this.specijalizacijeList}
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        alert(JSON.stringify(result));
        result.klinikaId = this.ulogovanKorisnik.klinika;
        this.tipPregledaService.updateTipPregleda(result).subscribe();
      }
      this.ngOnInit();
    });
  }

  obrisi(id: number) {
    this.pregledService.getAllFromKlinika(this.ulogovanKorisnik.klinika).subscribe(data => {
      const listaPregleda: Pregled[] = data;
      let smesDaObrises = true;
      for (const pregled of listaPregleda) {
        if (pregled.tipPregledaId === id) {
          alert('Nije moguce izbrisati tip pregleda. Postoje pregledi rezervisani za taj tip pregleda.');
          smesDaObrises = false;
          return;
        }
      }
      if (smesDaObrises) {
        this.tipPregledaService.removeTipPregleda(id).subscribe();
        this.ngOnInit();
      }
    });
  }
}

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'add-tip-pregleda-dialog',
  templateUrl: './add-tip-pregleda-dialog.html',
})
export class AddTipPregledaDialogComponent{
  tipPregleda: TipPregleda = new TipPregleda();
  constructor(public dialogRef: MatDialogRef<TipPregleda>,
              @Inject(MAT_DIALOG_DATA) public data) {
  }

  onOkClick(): void {
    this.dialogRef.close(this.tipPregleda);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'update-tip-pregleda-dialog',
  templateUrl: './update-tip-pregleda-dialog.html',
})
export class UpdateTipPregledaDialogComponent {
  tipPregleda: TipPregleda = new TipPregleda();
  constructor(
    public dialogRef: MatDialogRef<TipPregleda>,
    @Inject(MAT_DIALOG_DATA) public data) {
    this.tipPregleda = data.tipPregleda;
  }

  onOkClick(): void {
    this.dialogRef.close(this.tipPregleda);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
