import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {Sala} from '../../../../model/sala';
import {MatSort} from '@angular/material/sort';
import {SalaService} from '../../../../service/sala.service';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {AdministratorKlinikeService} from '../../../../service/administratorKlinike.service';
import {AdministratorKlinike} from '../../../../model/administratorKlinike';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {MatPaginator} from '@angular/material/paginator';

@Component({
  selector: 'app-sale-table',
  templateUrl: './sale-table.component.html',
  styleUrls: ['./sale-table.component.css']
})
export class SaleTableComponent implements OnInit {
  salaList: Sala[];
  dataSource: any;
  displayedColumns = ['id', 'naziv'];
  ulogovanKorisnik: AdministratorKlinike;
  dialogData: Sala;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<Sala>;
  constructor(public dialog: MatDialog, private salaService: SalaService, private administratorKlinikeService: AdministratorKlinikeService) {

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
    @Inject(MAT_DIALOG_DATA) public data: Sala) {
    this.naziv = data.naziv;
  }

  onOkClick(): void {
    this.sala.naziv = this.naziv;
    this.dialogRef.close(this.sala);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
