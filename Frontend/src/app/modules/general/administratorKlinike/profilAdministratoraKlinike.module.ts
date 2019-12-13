import {NgModule} from '@angular/core';
import {ProfilAdministratoraKlinikeComponent} from './profilAdministratoraKlinike.component';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from '../../../app-routing.module';

@NgModule( {
  declarations: [
    ProfilAdministratoraKlinikeComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule
  ],
  exports: [
    ProfilAdministratoraKlinikeComponent
  ],
  bootstrap: [ProfilAdministratoraKlinikeComponent]
})

export class ProfilAdministratoraKlinikeModule { }
