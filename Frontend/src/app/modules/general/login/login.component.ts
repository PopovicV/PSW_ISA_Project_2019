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
  submitted = false;
  badLogIn = false;

  constructor(private router: Router, private loginService: LoginService) {
    this.korisnik = new Korisnik();
  }

  onSubmit() {
    this.submitted = true;

    if (this.loginForm.invalid) {
      return;
     }
    this.loginService.logIn(this.loginForm.value).subscribe(
      data => {
        alert('Ulogovan: ' + data.uloga);
        if (data.uloga === 'ADMINISTRATOR_KLINIKE') {
          this.router.navigate(['profil-administratora-klinike']);
        } else if (data.uloga === 'ADMINISTRATOR_KLINICKOG_CENTRA') {
          this.router.navigate(['profil-administratora-klinickog-centra']);
        } else if (data.uloga === 'PACIJENT') {
          this.router.navigate(['profil-pacijenta']);
        } else if (data.uloga === 'LEKAR') {
          this.router.navigate(['lekar']);
        }


        return true;
      },
      error => {
        this.badLogIn = true;
      }
    );
  }

  get f() { return this.loginForm.controls; }

  ngOnInit() {
    this.loginForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      lozinka: new FormControl('', Validators.required)
    });
  }


}
