import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LekarComponent } from './lekar.component';
import { LekarNavigationComponent } from '../../navigations/lekar-navigation/lekar-navigation.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {RouterModule} from '@angular/router';
import {MatListModule} from '@angular/material/list';
import { LekarProfilComponent } from './lekar-profil/lekar-profil.component';
import {AppRoutingModule} from '../../../app-routing.module';
import {BrowserModule} from '@angular/platform-browser';
import {MatButtonModule} from '@angular/material/button';
import {FormsModule} from '@angular/forms';
import { LekarPacijentiTableComponent } from './pacijenti-table/lekar-pacijenti-table.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTableModule} from '@angular/material/table';
import {MatSortModule} from '@angular/material/sort';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from "@angular/material/input";


@NgModule({
  declarations: [LekarComponent, LekarNavigationComponent, LekarProfilComponent, LekarPacijentiTableComponent],
  imports: [
    AppRoutingModule,
    BrowserModule,
    CommonModule,
    MatSidenavModule,
    MatToolbarModule,
    MatIconModule,
    RouterModule,
    MatListModule,
    MatButtonModule,
    MatButtonModule,
    FormsModule,
    MatPaginatorModule,
    MatTableModule,
    MatSortModule,
    MatFormFieldModule,
    MatInputModule,
  ],
  exports: [
    LekarComponent
  ],
})
export class LekarModule { }
