import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './modules/general/home/home.component';
import { NotFoundComponent } from './modules/general/not-found/not-found.component';
<<<<<<< HEAD

const routes: Routes = [
  { path: '', component: HomeComponent, },
=======
import {ProfileComponent} from './modules/general/profile/profile.component';
import {LoginComponent} from './modules/general/login/login.component';
import {RegisterComponent} from './modules/general/register/register.component';
import {ProfilKlinikeComponent} from './modules/general/profilKlinike/profilKlinike.component';
import {ProfilAdministratoraKlinickogCentraComponent} from "./modules/general/profilAdministratoraKlinickogCentra/profilAdministratoraKlinickogCentra.component";

const routes: Routes = [
  // { path: '', component: HomeComponent, },
  { path: '', component: LoginComponent, },
  {
    path: 'register', component: RegisterComponent,
  },
  { path: 'profile', component: ProfileComponent},
  { path: 'profil-klinike', component: ProfilKlinikeComponent},
  { path: 'profil-administratora-klinickog-centra', component: ProfilAdministratoraKlinickogCentraComponent},
>>>>>>> 809b48e4dbe06a550be6afa9298f71b5f0047172
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
