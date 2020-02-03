import {AfterViewInit, Component, Inject, OnInit, ViewChild} from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable } from '@angular/material/table';
import { KlinikeTableDataSource, KlinikeTableItem } from './klinike-table-datasource';
import {Klinika} from '../model/klinika';
import {KlinikaService} from '../service/klinika.service';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-klinike-table',
  templateUrl: './klinike-table.component.html',
  styleUrls: ['./klinike-table.component.css']
})
export class KlinikeTableComponent implements AfterViewInit, OnInit {
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: false}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<KlinikeTableItem>;
  dataSource: KlinikeTableDataSource;
  klinike: Klinika[];
  dialogData: Klinika;

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'ime', 'adresa', 'opis'];

  constructor(public dialog: MatDialog,  private klinikaService: KlinikaService) {
    this.dataSource = new KlinikeTableDataSource(null);
  }

  ngOnInit() {
    this.klinikaService.getAll().subscribe(
      data => {
        this.klinike = data;
        this.dataSource = new KlinikeTableDataSource(this.klinike);
        alert(JSON.stringify(data));
      }
    );
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddKlinikaDialogComponent, {
      data: {klinika: this.dialogData}
    });

    dialogRef.afterClosed().subscribe(result => {
      alert(JSON.stringify(result));
      this.klinikaService.registerKlinika(result);
      this.klinike.push(result);
      /*this.klinikaService.getAll().subscribe(
        data =>
      )*/
    });
  }
}

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'klinike-table-add-klinika-dialog',
  templateUrl: './add-klinika-dialog.html',
  styleUrls: ['./add-klinika-dialog.css']
})

export class AddKlinikaDialogComponent {
  klinika: Klinika = new Klinika();
  constructor(
    public dialogRef: MatDialogRef<AddKlinikaDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Klinika) {
  }

  onOkClick(): void {
    this.dialogRef.close(this.klinika);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
