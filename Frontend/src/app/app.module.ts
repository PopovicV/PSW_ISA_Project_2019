import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './modules/general/home/home.component';
import { NotFoundComponent } from './modules/general/not-found/not-found.component';
import { AppRoutingModule } from './app-routing.module';
<<<<<<< HEAD
=======
import {ProfileModule} from './modules/general/profile/profile.module';

import {LoginModule} from './modules/general/login/login.module';
import {RegisterModule} from './modules/general/register/register.module';
import {ProfilKlinikeModule} from './modules/general/profilKlinike/profilKlinike.module';

import { RegisterService} from './service/register.service';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from './service/login.service';
import { FormsModule } from '@angular/forms';
import {ProfilAdministratoraKlinickogCentraModule} from './modules/general/profilAdministratoraKlinickogCentra/profilAdministratoraKlinickogCentra.module';
>>>>>>> 809b48e4dbe06a550be6afa9298f71b5f0047172

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
<<<<<<< HEAD
=======
    ProfileModule,
    LoginModule,
    RegisterModule,
    ProfilKlinikeModule,
    ProfilAdministratoraKlinickogCentraModule,
    HttpClientModule
>>>>>>> 809b48e4dbe06a550be6afa9298f71b5f0047172
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
