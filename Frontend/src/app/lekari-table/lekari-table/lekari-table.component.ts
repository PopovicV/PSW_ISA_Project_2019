import {AfterViewInit, Component, Inject, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {LekarService} from '../../service/lekar.service';
import {AdministratorKlinikeService} from '../../service/administratorKlinike.service';
import {Lekar} from '../../model/lekar';
import {MatSort} from '@angular/material/sort';
import {LekariTableDataSource} from './lekari-table-data-source';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {AdministratorKlinike} from '../../model/administratorKlinike';


@Component({
  selector: 'app-lekari-table',
  templateUrl: './lekari-table.component.html',
  styleUrls: ['./lekari-table.component.css']
})

export class LekariTableComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['ime', 'prezime'];
  dataSource: LekariTableDataSource;
  lekarList: Lekar[];
  dialogData: Lekar;
  ulogovanAdministratorKlinike: AdministratorKlinike;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<Lekar>;

  // tslint:disable-next-line:max-line-length
  constructor(public dialog: MatDialog, private lekarService: LekarService, private administratorKlinikeService: AdministratorKlinikeService) {
    this.dataSource = new LekariTableDataSource(null);
  }

  ngOnInit(): void {
    this.dataSource.paginator = this.paginator;
    this.administratorKlinikeService.getUlogovanKorisnik().subscribe(
      data => {
        this.ulogovanAdministratorKlinike = data;
        this.lekarService.getAllFromKlinika(data.klinika.toString()).subscribe(
          data1 => {
            this.lekarList = data1;
            this.dataSource = new LekariTableDataSource(this.lekarList);
            alert(JSON.stringify(data1));
          }
        );
      }
    );
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddLekarDialogComponent, {
      data: {lekar: this.dialogData}
    });

    dialogRef.afterClosed().subscribe(result => {
      alert(JSON.stringify(result));
      result.klinikaId = this.ulogovanAdministratorKlinike.klinika;
      this.lekarService.registerLekar(result);
      this.lekarList.push(result);
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
  constructor(
    public dialogRef: MatDialogRef<AddLekarDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Lekar) {
  }

  onOkClick(): void {
    this.dialogRef.close(this.lekar);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
