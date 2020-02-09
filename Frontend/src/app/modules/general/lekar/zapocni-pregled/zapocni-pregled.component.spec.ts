import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZapocniPregledComponent } from './zapocni-pregled.component';

describe('ZapocniPregledComponent', () => {
  let component: ZapocniPregledComponent;
  let fixture: ComponentFixture<ZapocniPregledComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZapocniPregledComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZapocniPregledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
