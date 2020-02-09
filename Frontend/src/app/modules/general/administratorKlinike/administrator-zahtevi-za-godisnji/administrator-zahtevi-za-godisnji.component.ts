import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {AdministratorKlinike} from '../../../../model/administratorKlinike';
import {AdministratorKlinikeService} from '../../../../service/administratorKlinike.service';
import {ZahtevZaGodisnji} from '../../../../model/zahtevZaGodisnji';
import {LekarService} from '../../../../service/lekar.service';
import {ZahtevZaGodisnjiService} from '../../../../service/zahtev-za-godisnji.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTable, MatTableDataSource} from '@angular/material/table';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {Odbijenica} from '../../../../model/odbijenica';
import {AddSalaDialogComponent} from "../sale-table/sale-table.component";
import {Sala} from "../../../../model/sala";

@Component({
  selector: 'app-administrator-zahtevi-za-godisnji',
  templateUrl: './administrator-zahtevi-za-godisnji.component.html',
  styleUrls: ['./administrator-zahtevi-za-godisnji.component.css']
})
export class AdministratorZahteviZaGodisnjiComponent implements OnInit {
  ulogovanKorisnik: AdministratorKlinike;
  zahtevZaGodisnjiList: ZahtevZaGodisnji[];
  dataSource: any;
  displayedColumns = ['id', 'zaposleni', 'pocetak', 'kraj', 'akcije'];
  napomena: string;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatTable, {static: false}) table: MatTable<ZahtevZaGodisnji>;
  constructor(public dialog: MatDialog, private administratorKlinikeService: AdministratorKlinikeService,
              private lekarService: LekarService,
              private zahtevZaGodisnjiService: ZahtevZaGodisnjiService) { }

  ngOnInit() {
    this.administratorKlinikeService.getUlogovanKorisnik().subscribe(data => {
      this.ulogovanKorisnik = data;
      this.zahtevZaGodisnjiService.getAllFromKlinika(data.klinika).subscribe(data1 => {
        this.zahtevZaGodisnjiList = data1;
        for (const zahtev of this.zahtevZaGodisnjiList) {
          this.lekarService.getOneById(zahtev.korisnikId).subscribe(data2 => {
            zahtev.korisnikIme = data2.ime;
            zahtev.korisnikPrezime = data2.prezime;
          });
        }
        this.dataSource = new MatTableDataSource<ZahtevZaGodisnji>(this.zahtevZaGodisnjiList);
        this.dataSource.sort = this.sort;
      });
    });
  }

  odbij(row: any) {
    this.openDialog(row);
    this.ngOnInit();
  }

  odobri(row: any) {
    this.zahtevZaGodisnjiService.prihvatiZahtev(row.id).subscribe();
    this.ngOnInit();
  }

  openDialog(row: any): void {
    const dialogRef = this.dialog.open(OdbijZahtevDialogComponent);
    dialogRef.afterClosed().subscribe(napomena => {
      let odbijenica: Odbijenica = new Odbijenica();
      odbijenica.zahtevZaGodisni = row;
      odbijenica.napomena = napomena;
      this.zahtevZaGodisnjiService.odbijZahtev(odbijenica).subscribe();
    });
  }
}

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'odbij-zahtev-dialog',
  templateUrl: './odbij-zahtev-dialog.html',
  styleUrls: ['./odbij-zahtev-dialog.css']
})
export class OdbijZahtevDialogComponent {
  napomena: string;
  constructor(
    public dialogRef: MatDialogRef<Sala>,
    @Inject(MAT_DIALOG_DATA) public data) {
  }

  onOkClick(): void {
    this.dialogRef.close(this.napomena);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}
