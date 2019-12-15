import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from '../../../app-routing.module';
import {ProfilAdministratoraKlinickogCentraComponent} from './profilAdministratoraKlinickogCentra.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RegistracijaKlinikeModule} from '../registracijaKlinike/registracijaKlinike.module';


@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RegistracijaKlinikeModule
  ],
  declarations: [
    ProfilAdministratoraKlinickogCentraComponent
  ]
})

export class ProfilAdministratoraKlinickogCentraModule {

}
