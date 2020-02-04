import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { FormsModule } from '@angular/forms';
import { ProfilPacijentaComponent } from './profilPacijenta.component';
import { PacijentNavigationComponent } from '../../navigations/pacijent-navigation/pacijent-navigation.component';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { LogoutService } from 'src/app/service/logout.service';
import { Router } from '@angular/router';
import { ZapravoProfilComponent } from './zapravo-profil/zapravo-profil.component';
import { PacijentListaKlinikaComponent } from './pacijent-lista-klinika/pacijent-lista-klinika.component';
import { KlinikaService } from 'src/app/service/klinika.service';
import { MatFormFieldModule, MatInputModule, MatExpansionModule } from '@angular/material';
import { PacijentListaDijagnozaComponent } from './pacijent-lista-dijagnoza/pacijent-lista-dijagnoza.component';
import { DijagnozaService } from 'src/app/service/dijagnoza.service';


@NgModule({
    imports: [
        BrowserModule, 
        AppRoutingModule,
        FormsModule,
        MatToolbarModule,
        MatButtonModule,
        MatSidenavModule,
        MatIconModule,
        MatListModule,
        MatTableModule,
        MatPaginatorModule,
        MatSortModule,
        MatFormFieldModule,
        MatInputModule,
        MatExpansionModule,
    ],
    declarations: [
        ProfilPacijentaComponent,
        PacijentNavigationComponent,
        ZapravoProfilComponent,
        PacijentListaKlinikaComponent,
        PacijentListaDijagnozaComponent
    ],
    exports: [
        ProfilPacijentaComponent,
        MatFormFieldModule,
        MatInputModule
    ],
    providers: [
        LogoutService,
        KlinikaService,
        DijagnozaService
    ]

})

export class ProfilPacijentaModule{
    constructor(private logoutService: LogoutService, private router: Router) {

    }

    
public logout() {
    this.logoutService.logout().subscribe(
        data => {
            return true;
        }
    )
}

}

