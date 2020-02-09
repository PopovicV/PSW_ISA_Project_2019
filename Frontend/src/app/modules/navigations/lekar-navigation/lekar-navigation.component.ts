import {Component, Input} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import {LogoutService} from '../../../service/logout.service';

@Component({
  selector: 'app-lekar-navigation',
  templateUrl: './lekar-navigation.component.html',
  styleUrls: ['./lekar-navigation.component.css']
})
export class LekarNavigationComponent {
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
