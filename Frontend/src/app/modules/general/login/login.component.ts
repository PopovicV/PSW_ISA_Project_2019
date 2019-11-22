import {environment} from '../../../../environments/environment';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls : ['./login.component.css']

})
export class LoginComponent implements OnInit{

  name = environment.application.name;
  angular = environment.application.angular;
  bootstrap = environment.application.bootstrap;

  constructor() {}

  ngOnInit() {
  }


}
