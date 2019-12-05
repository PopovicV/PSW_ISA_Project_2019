import {environment} from '../../../../environments/environment';
import {Component, OnInit} from '@angular/core';
import { Korisnik } from 'src/app/model/korisnik';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls : ['./login.component.css']

})
export class LoginComponent implements OnInit{

  name = environment.application.name;
  angular = environment.application.angular;
  bootstrap = environment.application.bootstrap;

  korisnik: Korisnik;
  loginForm: FormGroup;

  constructor(private loginService: LoginService) {
    this.korisnik = new Korisnik();
  }
  
  onSubmit() {
    this.loginService.logIn(this.korisnik).subscribe(
      data => {
        alert("Ulogovan korisnik" + data.email);
        return true;
      }
    )
  }

  ngOnInit() {
    this.loginForm = new FormGroup({
      email: new FormControl('',Validators.required),
      lozinka: new FormControl('', Validators.required)
    });
  }


}
