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

@NgModule( {
  declarations: [
    ProfilAdministratoraKlinikeComponent,
    AdministratorKlinikeNavigationComponent,
    PacijentiTableComponent
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
  ],
  exports: [
    ProfilAdministratoraKlinikeComponent
  ],
  bootstrap: [ProfilAdministratoraKlinikeComponent]
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
