import {Component, Input} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {LogoutService} from '../../../service/logout.service';
import {Pacijent} from '../../../model/pacijent';
import {AdministratorKlinike} from '../../../model/administratorKlinike';

@Component({
  selector: 'app-administrator-klinike-navigation',
  templateUrl: './administrator-klinike-navigation.component.html',
  styleUrls: ['./administrator-klinike-navigation.component.css']
})
export class AdministratorKlinikeNavigationComponent {
  @Input() pacijenti: Array<Pacijent>;

  @Input()
  ulogovanKorisnik: AdministratorKlinike;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private logoutService: LogoutService, private breakpointObserver: BreakpointObserver) {}

  public logout() {
    this.logoutService.logout().subscribe(
      data => {
        return true;
      }
    );
  }
}
