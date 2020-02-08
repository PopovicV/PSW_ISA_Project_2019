import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacijentPredefinisaniPreglediComponent } from './pacijent-predefinisani-pregledi.component';

describe('PacijentPredefinisaniPreglediComponent', () => {
  let component: PacijentPredefinisaniPreglediComponent;
  let fixture: ComponentFixture<PacijentPredefinisaniPreglediComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacijentPredefinisaniPreglediComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacijentPredefinisaniPreglediComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
