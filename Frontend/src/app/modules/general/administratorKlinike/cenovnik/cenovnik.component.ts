import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {TipPregleda} from '../../../../model/tipPregleda';
import {AdministratorKlinike} from '../../../../model/administratorKlinike';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {AdministratorKlinikeService} from '../../../../service/administratorKlinike.service';
import {TipPregledaService} from '../../../../service/tip-pregleda.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-cenovnik',
  templateUrl: './cenovnik.component.html',
  styleUrls: ['./cenovnik.component.css']
})
export class CenovnikComponent implements OnInit {
  tipPregledaList: TipPregleda[];
  dataSource: any;
  displayedColumns = ['id', 'naziv', 'cena'];
  ulogovanKorisnik: AdministratorKlinike;
  dialogData: TipPregleda;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<TipPregleda>;
  constructor(public dialog: MatDialog, private tipPregledaService: TipPregledaService,
              private administratorKlinikeService: AdministratorKlinikeService) { }

  ngOnInit() {
    this.administratorKlinikeService.getUlogovanKorisnik().subscribe(data => {
      this.ulogovanKorisnik = data;
      this.tipPregledaService.getAllFromKlinika(data.klinika).subscribe(data1 => {
        this.tipPregledaList = data1;
        this.dataSource = new MatTableDataSource<TipPregleda>(this.tipPregledaList);
        this.dataSource.sort = this.sort;
      });
    });
  }

  public doFilter(value: string) {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddTipPregledaDialogComponent, {
      data: {sala: this.dialogData}
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result != null) {
        result.klinikaId = this.ulogovanKorisnik.klinika;
        this.tipPregledaService.addTipPregleda(result).subscribe();
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
export class AddTipPregledaDialogComponent {
  tipPregleda: TipPregleda = new TipPregleda();
  constructor(
    public dialogRef: MatDialogRef<TipPregleda>,
    @Inject(MAT_DIALOG_DATA) public data) {
  }

  onOkClick(): void {
    this.dialogRef.close(this.tipPregleda);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
