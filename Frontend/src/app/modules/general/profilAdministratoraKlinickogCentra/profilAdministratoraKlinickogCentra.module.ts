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
import { KlinikeTableComponent } from '../administratorKlinike/klinike-table/klinike-table.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { KlinikaService} from '../../../service/klinika.service';

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
  ],
  declarations: [
    ProfilAdministratoraKlinickogCentraComponent,
    AdministratorKlinickogCentraNavigationComponent,
    KlinikeTableComponent
  ],
  providers: [
    KlinikaService
  ]
})

export class ProfilAdministratoraKlinickogCentraModule {

}
