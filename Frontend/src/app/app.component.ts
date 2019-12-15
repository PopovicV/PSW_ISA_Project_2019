import {Component} from '@angular/core';
import { LogoutService } from './service/logout.service';
import {Router} from '@angular/router';

@Component ({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  constructor(private logoutService: LogoutService, private router: Router,) {

  }

  public logout() {
    this.logoutService.logout().subscribe(
      data => {
      return true;
      }
    );
    
  }
 }
