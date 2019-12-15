import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from '../../../app-routing.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RegistracijaKlinikeComponent} from './registracijaKlinike.component';
import {ProfilAdministratoraKlinickogCentraModule} from '../profilAdministratoraKlinickogCentra/profilAdministratoraKlinickogCentra.module';


@NgModule( {
  declarations: [
    RegistracijaKlinikeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports : [
    RegistracijaKlinikeComponent
  ]
})

export class RegistracijaKlinikeModule {

}
