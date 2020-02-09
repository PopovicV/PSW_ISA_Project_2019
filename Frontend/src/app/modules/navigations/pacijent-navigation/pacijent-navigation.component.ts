import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { map, shareReplay } from 'rxjs/operators';
import {Router} from '@angular/router';
import { LogoutService } from 'src/app/service/logout.service';
import {MatExpansionModule} from '@angular/material/expansion';

@Component({
  selector: 'app-pacjient-navigation',
  templateUrl: './pacijent-navigation.component.html',
  styleUrls: ['./pacijent-navigation.component.css']
})
export class PacijentNavigationComponent implements OnInit {

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
  .pipe(
    map(result => result.matches),
    shareReplay()
  );

  constructor(private breakpointObserver: BreakpointObserver, private router: Router, private logoutService: LogoutService) { }

  ngOnInit() {
  }

  public logout() {
    this.logoutService.logout().subscribe(
        data => {
            return true;
        }
    )
}
}
