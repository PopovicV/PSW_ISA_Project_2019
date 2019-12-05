import {environment} from '../../../../environments/environment';
import {Component, OnInit} from '@angular/core';
import { RegisterService } from 'src/app/service/register.service'
import {Pacijent} from '../../../model/pacijent';
import {FormControl, FormGroup, Validators} from '@angular/forms';
@Component({
  selector: 'app-login',
  templateUrl: './register.component.html',
  styleUrls : ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  name = environment.application.name;
  angular = environment.application.angular;
  bootstrap = environment.application.bootstrap;

  pacijent: Pacijent;
  lozinkaConfirm: string;
  registerForm: FormGroup;

  constructor(private registerService: RegisterService) {
    this.pacijent = new Pacijent();
  }

  onSubmit() {
    this.lozinkaConfirm = (document.getElementById('passwordConfirm') as HTMLInputElement).value;
    if (this.lozinkaConfirm === this.pacijent.lozinka) {
      alert(JSON.stringify(this.pacijent))
      this.registerService.logIn(this.pacijent).subscribe(
        data => {
          this.registerForm.reset();
          return true;
        },
      );
      alert('saljem zahtev');
    }
  }

  ngOnInit() {
    this.registerForm = new FormGroup({
      ime: new FormControl('', Validators.required),
      prezime: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      lozinka: new FormControl('', Validators.required),
      kontaktTelefon: new FormControl('', Validators.required),
      adresa: new FormControl('', Validators.required),
      grad: new FormControl('', Validators.required),
      drzava: new FormControl('', Validators.required),
      jbo: new FormControl('', Validators.required),
    });
  }
}
