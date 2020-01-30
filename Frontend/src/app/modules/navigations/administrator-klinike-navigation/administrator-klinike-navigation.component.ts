import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {LogoutService} from '../../../service/logout.service';

@Component({
  selector: 'app-administrator-klinike-navigation',
  templateUrl: './administrator-klinike-navigation.component.html',
  styleUrls: ['./administrator-klinike-navigation.component.css']
})
export class AdministratorKlinikeNavigationComponent {

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
