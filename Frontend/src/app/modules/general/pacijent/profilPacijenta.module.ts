import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { FormsModule } from '@angular/forms';
import { ProfilPacijentaComponent } from './profilPacijenta.component';

@NgModule({
    imports: [
        BrowserModule, 
        AppRoutingModule,
        FormsModule
    ],
    declarations: [
        ProfilPacijentaComponent
    ]
})

export class ProfilPacijentaModule{

}