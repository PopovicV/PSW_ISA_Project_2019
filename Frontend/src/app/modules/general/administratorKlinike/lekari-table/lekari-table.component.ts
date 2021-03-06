import {AfterViewInit, Component, Inject, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {LekarService} from '../../../../service/lekar.service';
import {AdministratorKlinikeService} from '../../../../service/administratorKlinike.service';
import {Lekar} from '../../../../model/lekar';
import {MatSort} from '@angular/material/sort';
import {LekariTableDataSource} from './lekari-table-data-source';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {AdministratorKlinike} from '../../../../model/administratorKlinike';
import {stringify} from 'querystring';
import {PregledService} from '../../../../service/pregled.service';

@Component({
  selector: 'app-lekari-table',
  templateUrl: './lekari-table.component.html',
  styleUrls: ['./lekari-table.component.css']
})

export class LekariTableComponent implements OnInit {
  displayedColumns: string[] = ['id', 'ime', 'prezime', 'actions'];
  dataSource: any;
  lekarList: Lekar[];
  dialogData: Lekar;
  ulogovanAdministratorKlinike: AdministratorKlinike;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<Lekar>;
  constructor(public dialog: MatDialog, private lekarService: LekarService,
              private pregledService: PregledService,
              private administratorKlinikeService: AdministratorKlinikeService) {
  }

  ngOnInit(): void {
    this.administratorKlinikeService.getUlogovanKorisnik().subscribe(
      data => {
        this.ulogovanAdministratorKlinike = data;
        this.lekarService.getAllFromKlinika(data.klinika.toString()).subscribe(
          data1 => {
            this.lekarList = data1;
            this.dataSource = new MatTableDataSource<Lekar>(this.lekarList);
            this.dataSource.sort = this.sort;
            this.dataSource.paginator = this.paginator;
            this.table.dataSource = this.dataSource;
          }
        );
      }
    );
  }


  public doFilter(value: string) {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddLekarDialogComponent, {
      data: {lekar: this.dialogData}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result != null) {
        result.klinikaId = this.ulogovanAdministratorKlinike.klinika;
        this.lekarService.registerLekar(result).subscribe();
        this.ngOnInit();
      }
    });
  }

  obrisi(id: number): void {
    this.pregledService.getAllFromKlinika(id).subscribe(data => {
      if (data.length === 0) {
        this.lekarService.remove(id).subscribe();
        this.ngOnInit();
      } else {
        alert('Lekar ima rezervisane termine pregleda ili operacija i nije ga moguce izbrisati!');
      }
    });
  }
}

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'lekar-table-add-dialog',
  templateUrl: './add-lekar-dialog.html',
  styleUrls: ['./add-lekar-dialog.css']
})
export class AddLekarDialogComponent {
  lekar: Lekar = new Lekar();
  ime: string;
  prezime: string;
  email: string;
  smena: string;
  specijalizacija: string;
  kontaktTelefon: string;
  constructor(
    public dialogRef: MatDialogRef<AddLekarDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Lekar) {
    this.ime = data.ime;
    this.prezime = data.prezime;
    this.email = data.email;
    this.smena = stringify(data.smena);
    this.specijalizacija = data.specijalizacija;
    this.kontaktTelefon = data.kontaktTelefon;
  }

  onOkClick(): void {
    this.lekar.ime = this.ime;
    this.lekar.prezime = this.prezime;
    this.lekar.email = this.email;
    this.lekar.specijalizacija = this.specijalizacija;
    this.lekar.kontaktTelefon = this.kontaktTelefon;
    this.lekar.smena = Number(this.smena);
    this.dialogRef.close(this.lekar);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
