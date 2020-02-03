import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {KlinikeTableComponent} from '../../general/administratorKlinike/klinike-table/klinike-table.component';

const routes: Routes = [
  { path: 'app-klinike-table', component: KlinikeTableComponent}
]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  declarations: []
})
export class AdministratorKlinickogCentraNavigationRoutingModule { }
