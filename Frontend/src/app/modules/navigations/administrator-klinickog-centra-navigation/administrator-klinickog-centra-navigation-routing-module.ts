import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {
  KlinikeTableComponent
} from '../../general/administratorKlinike/klinike-table/klinike-table.component';
import {PacijentiTableComponent} from '../../../pacijenti-table/pacijenti-table.component';
import {AddAdministratorKlinickogCentraDialogComponent} from './administrator-klinickog-centra-navigation.component';

const routes: Routes = [
  { path: 'app-klinike-table', component: KlinikeTableComponent},
  { path: 'app-pacijenti-table', component: PacijentiTableComponent},
  { path: 'app-add-administrator-klinickog-centra-dialog', component: AddAdministratorKlinickogCentraDialogComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AdministratorKlinickogCentraNavigationRoutingModule { }
