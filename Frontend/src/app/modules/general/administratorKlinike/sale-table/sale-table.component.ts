import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {Sala} from '../../../../model/sala';
import {MatSort} from '@angular/material/sort';
import {SalaService} from '../../../../service/sala.service';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {AdministratorKlinikeService} from '../../../../service/administratorKlinike.service';
import {AdministratorKlinike} from '../../../../model/administratorKlinike';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';
import {PregledService} from '../../../../service/pregled.service';

@Component({
  selector: 'app-sale-table',
  templateUrl: './sale-table.component.html',
  styleUrls: ['./sale-table.component.css']
})
export class SaleTableComponent implements OnInit {
  salaList: Sala[];
  dataSource: any;
  displayedColumns = ['id', 'naziv', 'actions'];
  ulogovanKorisnik: AdministratorKlinike;
  dialogData: Sala;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<Sala>;
  constructor(public dialog: MatDialog, private salaService: SalaService,
              private pregledService: PregledService,
              private administratorKlinikeService: AdministratorKlinikeService) {
  }

  ngOnInit() {
    this.administratorKlinikeService.getUlogovanKorisnik().subscribe(data => {
      this.ulogovanKorisnik = data;
      this.salaService.getAllFromKlinika(data.klinika).subscribe(data1 => {
        this.salaList = data1;
        this.dataSource = new MatTableDataSource<Sala>(this.salaList);
        this.dataSource.sort = this.sort;
      });
    });
  }

  public doFilter(value: string) {
    this.dataSource.filter = value.trim().toLocaleLowerCase();
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddSalaDialogComponent, {
      data: {sala: this.dialogData}
    });
    dialogRef.afterClosed().subscribe(result => {
      if (result != null) {
        result.klinikaId = this.ulogovanKorisnik.klinika;
        this.salaService.addSala(result).subscribe();
        this.ngOnInit();
      }
    });
  }

  obrisi(id: number): void {
    this.pregledService.getAllFromSala(id).subscribe(data => {
      for (const pregled of data) {
        if (pregled.salaId === id) {
          alert('Sala ne moze biti izbrisana jer ima zakazanih pregleda.');
          return;
        }
      }
      this.salaService.remove(id).subscribe();
      this.ngOnInit();
    });
  }

  izmeni(currSala: Sala): void {
    this.pregledService.getAllFromSala(currSala.id).subscribe(data => {
        for (const pregled of data) {
          if (pregled.salaId === currSala.id) {
            alert('Sala ne moze biti izmenjena jer ima zakazanih pregleda.');
            return;
          }
        }
        const dialogRef = this.dialog.open(UpdateSalaDialogComponent, {
          data: {sala: currSala}
        });
        dialogRef.afterClosed().subscribe(result => {
          if (result != null) {
            this.salaService.updateSala(result).subscribe( data1 => {
              this.ngOnInit();
            });
          }
        });
    });
  }
}

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'add-sala-dialog',
  templateUrl: './add-sala-dialog.html',
  styleUrls: ['./add-sala-dialog.css']
})
export class AddSalaDialogComponent {
  sala: Sala = new Sala();
  naziv: string;
  constructor(
      public dialogRef: MatDialogRef<Sala>,
      @Inject(MAT_DIALOG_DATA) public data) {
  }

  onOkClick(): void {
    this.sala.naziv = this.naziv;
    this.dialogRef.close(this.sala);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}

@Component({
  selector: 'app-update-sala-dialog',
  templateUrl: './update-sala-dialog.html',
  styleUrls: ['./update-sala-dialog.css']
})
export class UpdateSalaDialogComponent {
  newSala: Sala;

  constructor(
    public dialogRef: MatDialogRef<Sala>,
    @Inject(MAT_DIALOG_DATA) public data) {
    this.newSala = data.sala;
  }

  onOkClick(): void {
    this.dialogRef.close(this.newSala);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
