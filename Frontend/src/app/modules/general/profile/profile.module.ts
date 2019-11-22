import {NgModule} from '@angular/core';
import {ProfileComponent} from './profile.component';
import {AppRoutingModule} from '../../../app-routing.module';
import {BrowserModule} from '@angular/platform-browser';

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  declarations: [
    ProfileComponent
  ]
})
export class ProfileModule {

}
