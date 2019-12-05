import {NgModule} from '@angular/core';
import {PorfilAdministratoraKlinikeComponent} from './porfilAdministratoraKlinike.component';
import {FormsModule} from '@angular/forms';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from '../../../app-routing.module';

@NgModule( {
  declarations: [
    PorfilAdministratoraKlinikeComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule
  ],
  exports: [
    PorfilAdministratoraKlinikeComponent
  ],
  bootstrap: [PorfilAdministratoraKlinikeComponent]
})

export class ProfilAdministratoraKlinikeModule { }
