import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from '../../../app-routing.module';
import {ProfileComponent} from '../profile/profile.component';
import {ProfilKlinikeComponent} from './profilKlinike.component';

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  declarations: [
    ProfilKlinikeComponent
  ]
})

export class ProfilKlinikeModule {

}
