import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './modules/general/home/home.component';
import { NotFoundComponent } from './modules/general/not-found/not-found.component';
import {ProfileComponent} from './modules/general/profile/profile.component';
import {LoginComponent} from './modules/general/login/login.component';
import {RegisterComponent} from './modules/general/register/register.component';
import {ProfilKlinikeComponent} from './modules/general/profilKlinike/profilKlinike.component';
import {
  ProfilAdministratoraKlinickogCentraComponent
} from './modules/general/profilAdministratoraKlinickogCentra/profilAdministratoraKlinickogCentra.component';
import {
  ProfilAdministratoraKlinikeComponent
} from './modules/general/administratorKlinike/profilAdministratoraKlinike.component';
import { ProfilPacijentaComponent } from './modules/general/pacijent/profilPacijenta.component';
import {RegistracijaKlinikeComponent} from './modules/general/registracijaKlinike/registracijaKlinike.component';
import {AdministratorKlinikeNavigationComponent} from './modules/navigations/administrator-klinike-navigation/administrator-klinike-navigation.component';
import { ZapravoProfilComponent } from './modules/general/pacijent/zapravo-profil/zapravo-profil.component';
import { PacijentListaKlinikaComponent } from './modules/general/pacijent/pacijent-lista-klinika/pacijent-lista-klinika.component';
import { RegisterConfirmComponent } from './register-confirm/register-confirm.component';
import {KlinikeTableComponent} from './modules/general/profilAdministratoraKlinickogCentra/klinike-table/klinike-table.component';
import {PacijentiTableComponent} from './pacijenti-table/pacijenti-table.component';
import {LekariTableComponent} from './modules/general/administratorKlinike/lekari-table/lekari-table.component';
import {AdministratorKlinikeProfilPageComponent} from './modules/general/administratorKlinike/administrator-klinike-profil-page/administrator-klinike-profil-page.component';
import {SaleTableComponent} from './modules/general/administratorKlinike/sale-table/sale-table.component';
import {PreglediKalendarComponent} from './modules/general/administratorKlinike/pregledi-kalendar/pregledi-kalendar.component';
import {CenovnikComponent} from './modules/general/administratorKlinike/cenovnik/cenovnik.component';
import { PacijentListaDijagnozaComponent } from './modules/general/pacijent/pacijent-lista-dijagnoza/pacijent-lista-dijagnoza.component';
import { PacijentProfilKlinikeComponent } from './modules/general/pacijent/pacijent-profil-klinike/pacijent-profil-klinike.component';
import { PacijentIstorijaOperacijaComponent } from './modules/general/pacijent/pacijent-istorija-operacija/pacijent-istorija-operacija.component';
import { PacijentIstorijaPregledaComponent } from './modules/general/pacijent/pacijent-istorija-pregleda/pacijent-istorija-pregleda.component';
import {LekarComponent} from './modules/general/lekar/lekar.component';
import {LekarProfilComponent} from './modules/general/lekar/lekar-profil/lekar-profil.component';
import { PacijentPredefinisaniPreglediComponent } from './modules/general/pacijent/pacijent-predefinisani-pregledi/pacijent-predefinisani-pregledi.component';
import {LekarPacijentiTableComponent} from './modules/general/lekar/pacijenti-table/lekar-pacijenti-table.component';



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
      },
      {
        path: 'sale',
        component: SaleTableComponent,
      },
      {
        path: 'pregledi',
        component: PreglediKalendarComponent,
      },
      {
        path: 'cenovnik',
        component: CenovnikComponent,
      },
    ]
  },
  { path: 'profil-klinike', component: ProfilKlinikeComponent},
  { path: 'profil-administratora-klinickog-centra', component: ProfilAdministratoraKlinickogCentraComponent,
    children: [
      { path: '', redirectTo: '', pathMatch: 'full'},
      { path: 'app-klinike-table', component: KlinikeTableComponent},
      { path: 'app-pacijenti-table', component: PacijentiTableComponent}
    ]
  },
  { path: 'registrationConfirm', component: RegisterConfirmComponent},
  { path: 'profil-pacijenta', component: ProfilPacijentaComponent,
  children: [
    {
      path: '',
      component: ZapravoProfilComponent
    },
    {
      path: 'pacijent-lista-klinika',
      component: PacijentListaKlinikaComponent,
    },
    {
      path: 'pacijentKlinika',
      component: PacijentProfilKlinikeComponent
    },
    {
      path: 'pacijent-lista-dijagnoza',
      component: PacijentListaDijagnozaComponent
    },
    {
      path: 'pacijent-istorija-operacija',
      component: PacijentIstorijaOperacijaComponent
    },
    {
      path: 'pacijent-istorija-pregleda',
      component: PacijentIstorijaPregledaComponent
    },
    {
      path: 'pacijent-predefinisani-pregledi',
      component: PacijentPredefinisaniPreglediComponent
    }
  ]},
  { path: 'registracija-klinike', component: RegistracijaKlinikeComponent},
  {
    path: 'lekar', component: LekarComponent,
    children: [
      { path: '', component: LekarProfilComponent},
      { path: 'pacijenti', component: LekarPacijentiTableComponent},
    ],
  },
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
