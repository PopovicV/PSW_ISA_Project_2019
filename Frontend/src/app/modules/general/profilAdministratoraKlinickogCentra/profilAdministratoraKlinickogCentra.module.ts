import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from '../../../app-routing.module';
import {ProfilAdministratoraKlinickogCentraComponent} from './profilAdministratoraKlinickogCentra.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RegistracijaKlinikeModule} from '../registracijaKlinike/registracijaKlinike.module';
import { AdministratorKlinickogCentraNavigationComponent } from '../../navigations/administrator-klinickog-centra-navigation/administrator-klinickog-centra-navigation.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import {
  AddAdministratorKlinikeDialogComponent,
  AddKlinikaDialogComponent,
  KlinikeTableComponent
} from '../administratorKlinike/klinike-table/klinike-table.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { KlinikaService} from '../../../service/klinika.service';
import {MatDialogModule} from '@angular/material/dialog';
import {MatFormFieldModule} from '@angular/material/form-field';
import {LogoutService} from '../../../service/logout.service';
import {Router} from '@angular/router';

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RegistracijaKlinikeModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatDialogModule,
    MatFormFieldModule,
  ],
  declarations: [
    ProfilAdministratoraKlinickogCentraComponent,
    AdministratorKlinickogCentraNavigationComponent,
    KlinikeTableComponent,
    AddKlinikaDialogComponent,
    AddAdministratorKlinikeDialogComponent
  ],
  providers: [
    KlinikaService
  ]
})

export class ProfilAdministratoraKlinickogCentraModule {
  constructor(private logoutService: LogoutService, private router: Router ) {

  }

  public logout() {
    this.logoutService.logout().subscribe(
      data => {
        return true;
      }
    );
  }
}
