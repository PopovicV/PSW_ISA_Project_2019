import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from '../../../app-routing.module';
import {ProfilAdministratoraKlinickogCentraComponent} from './profilAdministratoraKlinickogCentra.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  declarations: [
    ProfilAdministratoraKlinickogCentraComponent
  ]
})

export class ProfilAdministratoraKlinickogCentraModule {

}
