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
import { AdministratorKlinikeNavigationComponent } from './modules/navigations/administrator-klinike-navigation/administrator-klinike-navigation.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import {MatDrawerContent, MatSidenavModule} from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { PacijentNavigationComponent } from './modules/navigations/pacijent-navigation/pacijent-navigation.component';
import { RegisterConfirmComponent } from './register-confirm/register-confirm.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent,
    Pacijent_pocetna,
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
    BrowserAnimationsModule
  ],

  providers: [
    RegisterService,
    LoginService,
    AdministratorKlinikeService,
    AdministratorKlinickogCentraService,
    PacijentService,
    RegistracijaKlinikeService,
    LogoutService,
  ],


  bootstrap: [AppComponent]
})
export class AppModule { }
