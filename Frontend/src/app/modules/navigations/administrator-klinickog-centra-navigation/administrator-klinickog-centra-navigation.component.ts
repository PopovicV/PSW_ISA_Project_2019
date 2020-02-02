import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {LogoutService} from '../../../service/logout.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-administrator-klinickog-centra-navigation',
  templateUrl: './administrator-klinickog-centra-navigation.component.html',
  styleUrls: ['./administrator-klinickog-centra-navigation.component.css']
})
export class AdministratorKlinickogCentraNavigationComponent {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );

  constructor(private logoutService: LogoutService, private router: Router , private breakpointObserver: BreakpointObserver) {}

  public logout() {
    this.logoutService.logout().subscribe(
      data => {
        return true;
      }
    );
  }
}
