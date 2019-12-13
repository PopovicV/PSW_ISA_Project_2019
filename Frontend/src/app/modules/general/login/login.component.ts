import {environment} from '../../../../environments/environment';
import {Component, OnInit} from '@angular/core';
import { Korisnik } from 'src/app/model/korisnik';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { LoginService } from 'src/app/service/login.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls : ['./login.component.css']

})
export class LoginComponent implements OnInit {

  name = environment.application.name;
  angular = environment.application.angular;
  bootstrap = environment.application.bootstrap;

  korisnik: Korisnik;
  loginForm: FormGroup;

  constructor(private router: Router, private loginService: LoginService) {
    this.korisnik = new Korisnik();
  }

  onSubmit() {
    this.loginService.logIn(this.korisnik).subscribe(
      data => {
        alert(data.uloga);
        if (data.uloga === 'ADMINISTRATOR_KLINIKE') {
          this.router.navigate(['profil-administratora-klinike']);
        } else if (data.uloga === 'ADMINISTRATOR_KLINICKOG_CENTRA') {
          this.router.navigate(['profil-administratora-klinickog-centra']);
        }

        return true;
      }
    );
  }

  ngOnInit() {
    this.loginForm = new FormGroup({
      email: new FormControl('', Validators.required),
      lozinka: new FormControl('', Validators.required)
    });
  }


}
