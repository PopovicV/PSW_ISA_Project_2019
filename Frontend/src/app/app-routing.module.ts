import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './modules/general/home/home.component';
import { NotFoundComponent } from './modules/general/not-found/not-found.component';
import {ProfileComponent} from './modules/general/profile/profile.component';
import {LoginComponent} from './modules/general/login/login.component';
import {RegisterComponent} from './modules/general/register/register.component';
import {ProfilKlinikeComponent} from './modules/general/profilKlinike/profilKlinike.component';
import {ProfilAdministratoraKlinickogCentraComponent} from './modules/general/profilAdministratoraKlinickogCentra/profilAdministratoraKlinickogCentra.component';
import {ProfilAdministratoraKlinikeComponent} from './modules/general/administratorKlinike/profilAdministratoraKlinike.component';
import { ProfilPacijentaComponent } from './modules/general/pacijent/profilPacijenta.component';
import {RegistracijaKlinikeComponent} from './modules/general/registracijaKlinike/registracijaKlinike.component';
import {AdministratorKlinikeNavigationComponent} from './modules/navigations/administrator-klinike-navigation/administrator-klinike-navigation.component';
import { ZapravoProfilComponent } from './modules/general/pacijent/zapravo-profil/zapravo-profil.component';
import { PacijentListaKlinikaComponent } from './modules/general/pacijent/pacijent-lista-klinika/pacijent-lista-klinika.component';
import { RegisterConfirmComponent } from './register-confirm/register-confirm.component';
import {KlinikeTableComponent} from './klinike-table/klinike-table.component';
import {PacijentiTableComponent} from './pacijenti-table/pacijenti-table.component';
import {LekariTableComponent} from './lekari-table/lekari-table/lekari-table.component';
import {AdministratorKlinikeProfilPageComponent} from './modules/general/administratorKlinike/profil/administrator-klinike-profil-page/administrator-klinike-profil-page.component';

const routes: Routes = [
  // { path: '', component: HomeComponent, },
  { path: '', component: LoginComponent },
  {
    path: 'register', component: RegisterComponent,
  },
  { path: 'profile', component: ProfileComponent},
  { path: 'profil-administratora-klinike', component: ProfilAdministratoraKlinikeComponent,
    children: [
      {
        path: '',
        component: AdministratorKlinikeProfilPageComponent,
      },
      {
        path: 'profilKlinike',
        component: ProfilKlinikeComponent,
      },
      {
        path: 'lekari',
        component: LekariTableComponent,
      },
      {
        path: 'profilPage',
        component: AdministratorKlinikeProfilPageComponent,
      }
    ]
  },
  { path: 'profil-klinike', component: ProfilKlinikeComponent},
  { path: 'profil-administratora-klinickog-centra', component: ProfilAdministratoraKlinickogCentraComponent,
    children: [
      { path: '', redirectTo: '', pathMatch: 'full'},
      { path: 'app-klinike-table', component: KlinikeTableComponent}
    ]
  },
  { path: 'registrationConfirm', component: RegisterConfirmComponent},
  { path: 'profil-pacijenta', component: ProfilPacijentaComponent, 
  children:[
    {
      path: '',
      component: ZapravoProfilComponent
    }, 
    {
      path: 'pacijent-lista-klinika',
      component: PacijentListaKlinikaComponent
    }
  ]},
  { path: 'registracija-klinike', component: RegistracijaKlinikeComponent},
  {
    path: 'about',
    loadChildren: () => import('./modules/general/about/about.module').then(mod => mod.AboutModule)
  },
  {
    path: 'contact',
    loadChildren: () => import('./modules/general/contact/contact.module').then(mod => mod.ContactModule)
  },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AppRoutingModule { }
