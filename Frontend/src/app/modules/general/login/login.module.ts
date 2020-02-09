import {NgModule} from '@angular/core';
import {LoginComponent} from './login.component';
import {RegisterModule} from '../register/register.module';
import {AppRoutingModule} from '../../../app-routing.module';
import {RegisterComponent} from '../register/register.component';
import {BrowserModule} from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule( {
  declarations: [
    LoginComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports : [
    LoginComponent
  ],
  bootstrap: [LoginComponent]
})
export class LoginModule { }
