import { Component, OnInit } from '@angular/core';
import {LekarService} from '../../../service/lekar.service';
import {Lekar} from '../../../model/lekar';

@Component({
  selector: 'app-lekar',
  templateUrl: './lekar.component.html',
  styleUrls: ['./lekar.component.css'],
})
export class LekarComponent implements OnInit {
  ulogovanKorisnik: Lekar;
  constructor(lekarServivce: LekarService) {
  }

  ngOnInit() {
  }

}
