import {Component, Inject} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {LogoutService} from '../../../service/logout.service';
import {Router} from '@angular/router';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {AdministratorKlinickogCentra} from '../../../model/administratorKlinickogCentra';
import {AdministratorKlinickogCentraService} from '../../../service/administratorKlinickogCentra.service';

@Component({
  selector: 'app-administrator-klinickog-centra-navigation',
  templateUrl: './administrator-klinickog-centra-navigation.component.html',
  styleUrls: ['./administrator-klinickog-centra-navigation.component.css']
})
export class AdministratorKlinickogCentraNavigationComponent {

  dialogData: AdministratorKlinickogCentra;
  administratorKlinickogCentra: AdministratorKlinickogCentra;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  // tslint:disable-next-line:max-line-length
  constructor(public dialog: MatDialog, private administratorKlinickogCentraService: AdministratorKlinickogCentraService, private logoutService: LogoutService, private router: Router , private breakpointObserver: BreakpointObserver) {}

  public logout() {
    this.logoutService.logout().subscribe(
      data => {
        return true;
      }
    );
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(AddAdministratorKlinickogCentraDialogComponent, {
      data: {administratorKlinickogCentra: this.dialogData}
    });

    dialogRef.afterClosed().subscribe(result => {
      alert(JSON.stringify(result));
      this.administratorKlinickogCentraService.registerAdministratorKlinickogCentra(result).subscribe(data => {
      });
    });
  }
}


@Component({
  // tslint:disable-next-line:component-selector
  selector: 'app-add-administrator-klinickog-centra-dialog',
  templateUrl: './add-administrator-klinickog-centra-dialog.html',
  styleUrls: ['./add-administrator-klinickog-centra-dialog.css']
})

export class AddAdministratorKlinickogCentraDialogComponent {
  akc: AdministratorKlinickogCentra = new AdministratorKlinickogCentra();
  constructor(
    public dialogRef: MatDialogRef<AddAdministratorKlinickogCentraDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: AdministratorKlinickogCentra) {
    this.akc = data;
  }

  onOkClick(): void {
    this.dialogRef.close(this.akc);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }
}


