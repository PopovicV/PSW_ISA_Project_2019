import {NgModule} from '@angular/core';
import {ProfilAdministratoraKlinikeComponent} from './profilAdministratoraKlinike.component';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from '../../../app-routing.module';
import {AdministratorKlinikeNavigationComponent} from '../../navigations/administrator-klinike-navigation/administrator-klinike-navigation.component';
import {LayoutModule} from '@angular/cdk/layout';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import {MatDrawerContent, MatSidenavModule} from '@angular/material/sidenav';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {LogoutService} from '../../../service/logout.service';
import {Router} from '@angular/router';
import { PacijentiTableComponent } from '../../../pacijenti-table/pacijenti-table.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import {PacijentService} from '../../../service/pacijent.service';
import {MatTreeModule} from '@angular/material/tree';
import {MatExpansionModule} from '@angular/material/expansion';
import { ProfilKlinikeComponent } from '../profilKlinike/profilKlinike.component';
import {KlinikaService} from '../../../service/klinika.service';
import { LekariTableComponent } from '../../../lekari-table/lekari-table/lekari-table.component';
import {MatDialogModule} from '@angular/material/dialog';
import {AddLekarDialogComponent} from '../../../lekari-table/lekari-table/lekari-table.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {LekarService} from '../../../service/lekar.service';
import {MatSelectModule} from "@angular/material/select";
import { AdministratorKlinikeProfilPageComponent } from './profil/administrator-klinike-profil-page/administrator-klinike-profil-page.component';


@NgModule( {
  declarations: [
    ProfilAdministratoraKlinikeComponent,
    AdministratorKlinikeNavigationComponent,
    PacijentiTableComponent,
    ProfilKlinikeComponent,
    LekariTableComponent,
    AddLekarDialogComponent,
    AdministratorKlinikeProfilPageComponent,
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatTreeModule,
    MatExpansionModule,
    MatDialogModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
  ],
  exports: [
    ProfilAdministratoraKlinikeComponent
  ],
  bootstrap: [ProfilAdministratoraKlinikeComponent],
  providers: [PacijentService, KlinikaService, LekarService],
  entryComponents: [AddLekarDialogComponent]
})

export class ProfilAdministratoraKlinikeModule {
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
