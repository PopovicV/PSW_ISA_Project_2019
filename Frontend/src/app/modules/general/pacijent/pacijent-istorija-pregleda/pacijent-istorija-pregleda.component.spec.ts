import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacijentIstorijaPregledaComponent } from './pacijent-istorija-pregleda.component';

describe('PacijentIstorijaPregledaComponent', () => {
  let component: PacijentIstorijaPregledaComponent;
  let fixture: ComponentFixture<PacijentIstorijaPregledaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacijentIstorijaPregledaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacijentIstorijaPregledaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
