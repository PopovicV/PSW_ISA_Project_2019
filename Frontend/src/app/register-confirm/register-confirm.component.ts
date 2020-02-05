import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterService } from '../service/register.service';

@Component({
  selector: 'app-register-confirm',
  templateUrl: './register-confirm.component.html',
  styleUrls: ['./register-confirm.component.css']
})
export class RegisterConfirmComponent implements OnInit {

  constructor(private router: Router, private registerService: RegisterService) { }

  ngOnInit() {
    let href = this.router.url;
    var splitted = href.split("?")
    alert(splitted[1])
    this.registerService.verify(splitted[1]).subscribe( 
      data => {})
  }
  
  public redirect() {
    this.router.navigate(['']);
  }
}
