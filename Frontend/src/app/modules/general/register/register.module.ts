import {NgModule, OnInit} from '@angular/core';
import {RegisterComponent} from './register.component';
import {AppRoutingModule} from '../../../app-routing.module';
import {LoginModule} from '../login/login.module';
import {LoginComponent} from '../login/login.component';
import {BrowserModule} from '@angular/platform-browser';
import {AppModule} from '../../../app.module';
import {RouterModule} from '@angular/router';
import {FormsModule} from '@angular/forms';


@NgModule( {
  declarations: [
    RegisterComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  exports : [
    RegisterComponent
  ],
  bootstrap: [RegisterComponent]
})
export class RegisterModule { }
