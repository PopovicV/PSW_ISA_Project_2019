import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './modules/general/home/home.component';
import { NotFoundComponent } from './modules/general/not-found/not-found.component';
import { AppRoutingModule } from './app-routing.module';
import {ProfileModule} from './modules/general/profile/profile.module';

import {LoginModule} from './modules/general/login/login.module';
import {RegisterModule} from './modules/general/register/register.module';
import {ProfilKlinikeModule} from './modules/general/profilKlinike/profilKlinike.module';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ProfileModule,
    LoginModule,
    RegisterModule,
    ProfilKlinikeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
