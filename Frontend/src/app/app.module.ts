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

import { RegisterService} from './service/register.service';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './service/login.service';
import {ProfilAdministratoraKlinickogCentraModule} from './modules/general/profilAdministratoraKlinickogCentra/profilAdministratoraKlinickogCentra.module';
import {ProfilAdministratoraKlinikeModule} from './modules/general/administratorKlinike/profilAdministratoraKlinike.module';
import {AdministratorKlinikeService} from './service/administratorKlinike.service';
import {AdministratorKlinickogCentraService} from './service/administratorKlinickogCentra.service';
import { PacijentService } from './service/pacijent.service';
import { ProfilPacijentaModule } from './modules/general/pacijent/profilPacijenta.module';
import { LogoutService } from './service/logout.service';
import {RegistracijaKlinikeModule} from './modules/general/registracijaKlinike/registracijaKlinike.module';
import {RegistracijaKlinikeService} from './service/registracijaKlinike.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegisterConfirmComponent } from './register-confirm/register-confirm.component';
import { SalaService } from './service/sala.service';
import {KlinikaService} from './service/klinika.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import {TipPregledaService} from './service/tip-pregleda.service';
import {PregledService} from './service/pregled.service';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent,
    RegisterConfirmComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ProfileModule,
    LoginModule,
    RegisterModule,
    ProfilKlinikeModule,
    ProfilAdministratoraKlinikeModule,
    ProfilAdministratoraKlinickogCentraModule,
    ProfilPacijentaModule,
    HttpClientModule,
    RegistracijaKlinikeModule,
    BrowserAnimationsModule,
    CommonModule,
    FormsModule,
  ],

  providers: [
    RegisterService,
    LoginService,
    AdministratorKlinikeService,
    AdministratorKlinickogCentraService,
    PacijentService,
    RegistracijaKlinikeService,
    LogoutService,
    SalaService,
    KlinikaService,
    TipPregledaService,
    PregledService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
