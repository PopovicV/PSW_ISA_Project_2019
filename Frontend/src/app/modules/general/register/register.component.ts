import {environment} from '../../../../environments/environment';
import {Component, OnInit} from '@angular/core';
import { RegisterService } from 'src/app/service/register.service';
import {Pacijent} from '../../../model/pacijent';
import {FormControl, FormGroup, AbstractControl, FormBuilder, Validators} from '@angular/forms';
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
  lozinkaOriginalna: string;
  lozinkaConfirm: string;
  registerForm: FormGroup;
  submitted = false;

  constructor(private registerService: RegisterService) {
    this.pacijent = new Pacijent();
  }

  onSubmit() {
    this.submitted = true;

    this.lozinkaOriginalna = (document.getElementById('lozinka') as HTMLInputElement).value;
    this.lozinkaConfirm = (document.getElementById('lozinkaConfirm') as HTMLInputElement).value;
    alert(this.lozinkaOriginalna)
    alert(this.lozinkaConfirm)
    if (this.lozinkaOriginalna === this.lozinkaConfirm) {
      this.registerService.logIn(this.registerForm.value).subscribe(
        data => {
          this.registerForm.reset();
          return true;
        },
      );
    }
  }

  get f() { return this.registerForm.controls; }

  ngOnInit() {
    this.registerForm = new FormGroup({
      ime: new FormControl('', Validators.required),
      prezime: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      lozinka: new FormControl('', Validators.required),
      lozinkaConfirm: new FormControl('', Validators.required),
      kontaktTelefon: new FormControl('', Validators.required),
      adresa: new FormControl('', Validators.required),
      grad: new FormControl('', Validators.required),
      drzava: new FormControl('', Validators.required),
      jbo: new FormControl('', Validators.required),
    });
  }
}
