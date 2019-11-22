import {environment} from '../../../../environments/environment';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './register.component.html',
  styleUrls : ['./register.component.css']

})
export class RegisterComponent implements OnInit {

  name = environment.application.name;
  angular = environment.application.angular;
  bootstrap = environment.application.bootstrap;

  constructor() {}

  ngOnInit() {
  }
}
